package com.premsinghdaksha.giphystatus.utils;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.util.Random;

import static android.content.Context.DOWNLOAD_SERVICE;
import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class UltimateShareImage extends AsyncTask<File, File, File> {
    static Context context;
    static String image_url;
    private ProgressDialog dialog;
    private String filename = "";
    Uri contentUri;
    private long enqueue;
    private DownloadManager dm;

    public UltimateShareImage(Context context, String image_url) {
        this.context = context;
        this.image_url = image_url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setMessage("preparing gif to share ...");
        dialog.setCancelable(false);
        dialog.show();
        callBroadCast();
    }

    private void callBroadCast() {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                    long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(enqueue);
                    Cursor c = dm.query(query);
                    if (c.moveToFirst()) {
                        int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if (DownloadManager.STATUS_SUCCESSFUL == c.getInt(columnIndex)) {
                            File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS) + "/" + filename);
                            Log.d("filePath__", String.valueOf(file));
                            Log.d("STATUS_SUCCESSFUL__", "Completed");
                            Uri contentUri = getImageContentUri(context, file);
                            if (contentUri != null) {
                                dialog.dismiss();
                                Log.d("contentUri___", String.valueOf(contentUri));
                                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                                sharingIntent.setType("image/*");
                                sharingIntent.putExtra(Intent.EXTRA_TEXT, "Share image by Giphy Status");
                                sharingIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                                context.startActivity(Intent.createChooser(sharingIntent, "Share with:"));
                            }
                        }
                    }
                }
            }
        };

        context.registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

    }

    @Override
    protected File doInBackground(File... files) {
        File file = null;
        try {
            LoadUrl(image_url);
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d("exception____", "exception");

        }

        return file;

    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        callBroadCast();

    }

    public void LoadUrl(String url) {
        String id = getSaltString("number");
        filename = id + "_Img" + ".gif";
        dm = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request1 = new DownloadManager.Request(Uri.parse(url));
        request1.setDestinationInExternalPublicDir(DIRECTORY_DOWNLOADS, filename);
        request1.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request1.setVisibleInDownloadsUi(false);
        enqueue = dm.enqueue(request1);

    }


    public static Uri getImageContentUri(Context context, File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
            Log.d("media_id", String.valueOf(id));
            cursor.close();
            return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "" + id);
        } else {
            if (imageFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return context.getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }

    protected String getSaltString(String typevalue) {
        String SALTCHARS = null;
        if (typevalue.equals("number")) {
            SALTCHARS = "0123456789";
        } else {
            SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        }
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}

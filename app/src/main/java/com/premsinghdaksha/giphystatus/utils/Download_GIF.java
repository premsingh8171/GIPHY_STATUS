package com.premsinghdaksha.giphystatus.utils;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Download_GIF extends AsyncTask<String, Void, String> {
    static String url_image = null;
    static Context context;
    private ProgressDialog dialog;

    public Download_GIF(Context context, String url) {
        this.url_image = url;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setMessage("preparing gif to share ...");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        String filepath = null;
        try {
            //set the download URL, a url that points to a file on the internet
            //this is the file to be downloaded
            URL url = new URL(url_image);
            //create the new connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //set up some things on the connection
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            //and connect!
            urlConnection.connect();
            Log.d("wrwdsssds", url.getPath());

            //set the path where we want to save the file
            //in this case, going to save it on the root directory of the
            //sd card.
            File SDCardRoot = new File(url.getPath());
            //create a new file, specifying the path, and the filename
            //which we want to save the file as.
            Log.d("SDCardRoot___", String.valueOf(SDCardRoot));

            String filename = "downloadedFile.gif";   // you can download to any type of file ex:.jpeg (image) ,.txt(text file),.mp3 (audio file)
            Log.i("Local filename:", "" + filename);
            File file;
            file = new File(SDCardRoot, filename);
            if (file.createNewFile()) {
                file.createNewFile();
            }

            //this will be used to write the downloaded data into the file we created
            FileOutputStream fileOutput = new FileOutputStream(file);

            //this will be used in reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            //this is the total size of the file
            int totalSize = urlConnection.getContentLength();
            //variable to store total downloaded bytes
            int downloadedSize = 0;

            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0; //used to store a temporary size of the buffer

            //now, read through the input buffer and write the contents to the file
            while ((bufferLength = inputStream.read(buffer)) > 0) {
                //add the data in the buffer to the file in the file output stream (the file on the sd card
                fileOutput.write(buffer, 0, bufferLength);
                //add up the size so we know how much is downloaded
                downloadedSize += bufferLength;
                //this is where you would do something to report the prgress, like this maybe
                Log.i("Progress:", "downloadedSize:" + downloadedSize + "totalSize:" + totalSize);

            }
            //close the output stream when done
            fileOutput.close();
            if (downloadedSize == totalSize) filepath = file.getPath();

            //catch some possible errors...
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            filepath = null;
            e.printStackTrace();
        }
        Log.i("filepath:", " " + filepath);

        return filepath;


    }

    public void download(String url, String type) {

        String DownloadUrl = url;
        DownloadManager.Request request1 = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request1.setDescription("your document downloaded  successfully");   //appears the same in Notification bar while downloading
        request1.setTitle(type);
        request1.setMimeType("Onedios");
        request1.setVisibleInDownloadsUi(true);
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url));
        request1.setMimeType(mimeString);

        request1.setDestinationInExternalFilesDir(context, "/File", type);
        request1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, type);
        DownloadManager.Request filePath =request1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, type);
        DownloadManager manager1 = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        request1.allowScanningByMediaScanner();

        request1.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(manager1).enqueue(request1);
            if (DownloadManager.STATUS_SUCCESSFUL == 8) {
                if (type.equals(".pdf")) {
                } else {
                    Toast.makeText(context, "Your document has been saved in download folder !", Toast.LENGTH_LONG);
                }
            }
        }

    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        dialog.dismiss();

        if (s != null) {
            //Uri contentUri = Helper.getImageContentUri(context, result);
            Uri contentUri = Uri.parse(s);
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            sharingIntent.setType("image/gif");
            sharingIntent.putExtra(Intent.EXTRA_STREAM, contentUri);

            // start the chooser
            context.startActivity(Intent.createChooser(sharingIntent, "Share with:"));
        } else {
            Toast.makeText(context, "Error Downloading ...", Toast.LENGTH_SHORT).show();
        }

    }
}

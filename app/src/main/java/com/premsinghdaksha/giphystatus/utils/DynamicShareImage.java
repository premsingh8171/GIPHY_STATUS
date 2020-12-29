package com.premsinghdaksha.giphystatus.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.premsinghdaksha.giphystatus.utils.ImagePath.getImagePath;

public class DynamicShareImage {
    String sTrImage;
    Context context;

    public DynamicShareImage(Context context) {
        this.context = context;
    }

    //start code for share image on social media
    public void shareImage(ArrayList<String> image_list, String shareText) {
        Log.d("image_listStr__", image_list.get(0) + "---" + shareText);

        Intent shareIntent = new Intent();
        try {
            boolean isImage = false;
            if (image_list.get(0) != null
                    && image_list.size() >= 0) {
                try {
                    String imgPath;
                    //  List<String> imgs =
                    for (int j = 0; j < image_list.size(); j++) {
                        String extension = "";
                        if (image_list.get(j).contains(".")) {
                            extension = image_list.get(j).substring(image_list.get(j).lastIndexOf("."));
                        }

                        if (extension.contains("jpg") || extension.contains("jpeg") || extension.contains("png")
                                || extension.contains(".gif") || extension.contains(".svg") || extension.contains(".pdf")) {
                            imgPath = getImagePath(image_list.get(0));
                            sTrImage = imgPath;
                            isImage = true;
                            break;
                        }
                    }

                    if (isImage) {
                        new MyAsync().execute(shareText);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                if (shareText != null && !"".equals(shareText)) {
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    //shareIntent.setType("image/*");
                    shareIntent.setType("image/.gif");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, sTrImage);
                    context.startActivity(Intent.createChooser(shareIntent, "Share with"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Tag___", String.valueOf(e));
        }
    }

    public class MyAsync extends AsyncTask<String, Void, Bitmap> {
        String shareText;
        boolean isPerms = false;


        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                shareText = urls[0];
                URL url = new URL(sTrImage);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(Bitmap bm) {
            super.onPostExecute(bm);
            String url = "";
            try {
                if (bm != null) {
                    isPerms = askForPermissions();
                    url = MediaStore.Images.Media.insertImage(context.getContentResolver(), bm, "", "");
                    Log.d("url____", url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent shareIntent = new Intent();
            if (url != null && !"".equals(url) && isPerms) {
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(url));
                shareIntent.setType("image/.gif");
                if (shareText != null && !"".equals(shareText)) {
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                } else {
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                }
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.sharedFrom));
                context.startActivity(Intent.createChooser(shareIntent, "Share with"));
                Log.d("url___fff", url);
            } else {
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                if (shareText != null && !"".equals(shareText)) {
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "share file");
                    context.startActivity(Intent.createChooser(shareIntent, "Share with"));
                } else {
                    Toast.makeText(context, "con't share image", Toast.LENGTH_LONG);
                }
            }
        }
    }


    private boolean askForPermissions() {
        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();
        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                return false;
            }
            return false;
        } else {
            return true;
        }

    }


}

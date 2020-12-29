package com.premsinghdaksha.giphystatus.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.premsinghdaksha.actionsheet.ActionSheet;
import com.premsinghdaksha.actionsheet.callback.ActionSheetCallBack;
import com.premsinghdaksha.giphystatus.R;
import com.premsinghdaksha.giphystatus.adapter.DataAdapter;
import com.premsinghdaksha.giphystatus.interfaces.ApiInterface;
import com.premsinghdaksha.giphystatus.model.DataDTO;
import com.premsinghdaksha.giphystatus.model.ResponseDTO;
import com.premsinghdaksha.giphystatus.utils.APIClient;
import com.premsinghdaksha.giphystatus.utils.BaseActivity;
import com.premsinghdaksha.giphystatus.utils.DynamicShareImage;
import com.premsinghdaksha.giphystatus.utils.LocalPreference;
import com.premsinghdaksha.giphystatus.utils.UltimateShareImage;
import com.premsinghdaksha.startactivityanimationlibrary.AppUtils;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends BaseActivity {
    private ApiInterface apiInterface;
    private DataAdapter dataAdapter;
    private RecyclerView rv_gif;
    private EditText search_giphy;
    private SwipeRefreshLayout refrece;
    private LocalPreference localPreference;
    private List<DataDTO> dataList = new ArrayList<>();
    private List<DataDTO> filters_dataList = new ArrayList<>();
    private ArrayList<String> actionsList = new ArrayList<>();
    private ArrayList<String> image = new ArrayList<>();
    private DynamicShareImage dynamicShareImage;
    private int clickHandle = 0;
    private static final int MY_PERMISSIONS_REQUEST_CODE = 121;
    private int permissionClick = 0;
    private long enqueue;
    private DownloadManager dm;
    String filename = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        localPreference = new LocalPreference(MainActivity.this);
        search_giphy = findViewById(R.id.search_giphy);
        rv_gif = findViewById(R.id.rv_gif);
        refrece = findViewById(R.id.refrece);
        apiInterface = APIClient.getClient().create(ApiInterface.class);
        dynamicShareImage = new DynamicShareImage(MainActivity.this);
        actionsList.add("Share");
        actionsList.add("View");
        dataList = new ArrayList<>();
        dataList.clear();
        dataList = localPreference.getData("offline");

        if (dataList == null) {
            if (isConnectingToInternet()) {
                ApiResponce();
                //apiCall("https://api.giphy.com/v1/gifs/trending?api_key=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV&limit=25");
            }
            {
                Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        } else {
            dataList = localPreference.getData("offline");
            Log.d("dataList_sizeoff", String.valueOf(dataList.size()));

            rvSetData(dataList);
        }

        refrece.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isConnectingToInternet()) {
                    localPreference.clear();
                    dataList.clear();
                    refrece.setRefreshing(true);
                    ApiResponce();

                    // apiCall("https://api.giphy.com/v1/gifs/trending?api_key=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV&limit=25");
                } else {
                    Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();
                    refrece.setRefreshing(false);

                }
            }
        });

        search_giphy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (dataList.isEmpty()) {
                    return;
                }
                filters_dataList = filter(dataList, s.toString());
                dataAdapter.setFilter(filters_dataList);
                dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        BroadcastReceiver receiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String action = intent.getAction();
//                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
//                    long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
//                    DownloadManager.Query query = new DownloadManager.Query();
//                    query.setFilterById(enqueue);
//                    Cursor c = dm.query(query);
//                    if (c.moveToFirst()) {
//                        int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
//                        if (DownloadManager.STATUS_SUCCESSFUL == c
//                                .getInt(columnIndex)) {
//                            File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS) + "/" + filename);
//                            Log.d("filePath__", String.valueOf(file));
//                            Log.d("rrrrr_", "complete");
//                            Uri contentUri = getImageContentUri(context, file);
//                            if (contentUri != null) {
//                                Log.d("contentUri___", String.valueOf(contentUri));
//                                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//                                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//                                sharingIntent.setType("image/gif");
//                                sharingIntent.putExtra(Intent.EXTRA_TEXT, "Share image by Giphy Status");
//                                sharingIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
//                                context.startActivity(Intent.createChooser(sharingIntent, "Share with:"));
//                            }
//
//
//                        }
//                    }
//                }
//            }
//        };
//
//        registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));


    }

    private void actionDialog(String gifUrl) {
        new ActionSheet(MainActivity.this, actionsList)
                .setTitle("What do you want to do with the file")
                .setCancelTitle("Cancel")
                .setColorTitle(getResources().getColor(R.color.title))
                .setColorTitleCancel(getResources().getColor(R.color.action))
                .setColorData(getResources().getColor(R.color.action))
                .create(new ActionSheetCallBack() {
                    @Override
                    public void data(@NotNull String data, int position) {
                        switch (position) {
                            case 0:
                                image.clear();
                                image.add(gifUrl);
                                new UltimateShareImage(MainActivity.this, gifUrl).execute();
//                                String id = getSaltString("number");
//                                filename = id + "_Img" + ".gif";
//                                dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//                                DownloadManager.Request request1 = new DownloadManager.Request(Uri.parse(gifUrl));
//                                request1.setDestinationInExternalPublicDir(DIRECTORY_DOWNLOADS, filename);
//                                request1.setVisibleInDownloadsUi(false);
//                                enqueue = dm.enqueue(request1);

                                break;
                            case 1:
                                Intent intent = new Intent(MainActivity.this, GifFullScreen.class);
                                intent.putExtra("url", gifUrl);
                                AppUtils.startActivityRightToLeft(MainActivity.this, intent);
                        }
                    }
                });
    }

    //using retrofit
    private void ApiResponce() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        Call<ResponseDTO> call = apiInterface.getdata("eLPy7CXqimAo9wqht5EKRcAujKGpzDsV", "1000");
        call.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                Log.d("Response___", response.body().toString());
                refrece.setRefreshing(false);

                progressDialog.dismiss();
                dataList = response.body().getData();
                localPreference.StoreData(dataList, "offline");
                rvSetData(dataList);


            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                refrece.setRefreshing(false);
                progressDialog.dismiss();
            }
        });
    }

    //using volley
    private void apiCall(String urls) {
        refrece.setRefreshing(false);
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.GET, urls, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response", response);
                refrece.setRefreshing(false);
                dataList.clear();
                progressDialog.dismiss();
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                ResponseDTO responseDTO = gson.fromJson(response, ResponseDTO.class);
                dataList = responseDTO.getData();
                localPreference.StoreData(dataList, "offline");
                rvSetData(responseDTO.getData());
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

    private void rvSetData(List<DataDTO> dataDTO) {
        dataAdapter = new DataAdapter(dataDTO, MainActivity.this, new DataAdapter.OnClickGif() {
            @Override
            public void onClik(DataDTO dataDTO) {
                if (clickHandle == 0) {
                    // String gif = "https://media1.giphy.com/media/" + dataDTO.getId() + "/giphy.gif";
                    String gif = dataDTO.getImages().getOriginal().getUrl();
                    Log.d("gif", gif);
                    actionDialog(gif);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clickHandle = 0;
                    }
                }, 2000L);
            }
        });
        rv_gif.setAdapter(dataAdapter);
    }

    //search List logic
    private List<DataDTO> filter(List<DataDTO> models, String query) {
        query = query.toLowerCase();

        final List<DataDTO> filteredModelList = new ArrayList<>();
        for (DataDTO model : models) {
            final String text = model.getTitle().toLowerCase();
            //  final String text1 = model.getCategories_name().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);

            }
        }
        return filteredModelList;

    }

    //end code
    protected void checkPermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                + ContextCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.CAMERA)
                + ContextCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)

                != PackageManager.PERMISSION_GRANTED
        ) {

// Do something, when permissions not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    MainActivity.this, Manifest.permission.CAMERA)
// || ActivityCompat.shouldShowRequestPermissionRationale(
// ActivateProductUploadDocuments.this, Manifest.permission.READ_CONTACTS)
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
/*|| ActivityCompat.shouldShowRequestPermissionRationale(
ActivateProductUploadDocuments.this, Manifest.permission.READ_PHONE_STATE*/

            ) {
// If we should give explanation of requested permissions

// Show an alert dialog here with request explanation


                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{
                                Manifest.permission.CAMERA,
//Manifest.permission.READ_CONTACTS,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
//Manifest.permission.READ_PHONE_STATE
                        },
                        MY_PERMISSIONS_REQUEST_CODE
                );
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Camera, Read and Write External" +
                        " Storage permissions are required to do the task.");
                builder.setTitle("Please grant those permissions");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(
                                MainActivity.this,
                                new String[]{
                                        Manifest.permission.CAMERA,
// Manifest.permission.READ_CONTACTS,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
//Manifest.permission.READ_PHONE_STATE
                                },
                                MY_PERMISSIONS_REQUEST_CODE
                        );
                    }
                });
// builder.setNeutralButton("Cancel", null);
                AlertDialog dialog = builder.create();
//dialog.show();
            } else {
// Directly request for required permissions, without explanation
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{
                                Manifest.permission.CAMERA,
// Manifest.permission.READ_CONTACTS,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
// Manifest.permission.READ_PHONE_STATE
                        },
                        MY_PERMISSIONS_REQUEST_CODE
                );
            }
        } else {
            permissionClick = 1;
//Toast.makeText(ActivateProductUploadDocuments.this, "Permissions already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CODE: {
                if ((grantResults[0] == 0 && grantResults[1] == 0
                        && grantResults[2] == 0)) {
                    permissionClick = 1;

                } else {

                }
                return;
            }
        }
    }
}
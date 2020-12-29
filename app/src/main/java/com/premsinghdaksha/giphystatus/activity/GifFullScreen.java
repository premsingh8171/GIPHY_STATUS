package com.premsinghdaksha.giphystatus.activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.premsinghdaksha.giphystatus.R;
import com.premsinghdaksha.giphystatus.utils.BaseActivity;
import com.premsinghdaksha.startactivityanimationlibrary.AppUtils;

import static android.R.attr.uiOptions;

public class GifFullScreen extends BaseActivity {
    PhotoView photoView;
    ImageView ImgCacel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_full_screen);
        photoView = findViewById(R.id.zoomImg);
        ImgCacel = findViewById(R.id.ImgCacel);
        if (getIntent().getStringExtra("url") != null) {
            String cover = getIntent().getStringExtra("url");
                Glide.with(this).load(cover).into(photoView);
        }

        ImgCacel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.finishActivityLeftToRight(GifFullScreen.this);
            }
        });

        photoView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            fullScreen();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void fullScreen() {

        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled = isImmersiveModeEnabled();
        if (isImmersiveModeEnabled) {
            Log.i("TEST", "Turning immersive mode mode off. ");
        } else {
            Log.i("TEST", "Turning immersive mode mode on.");
        }

        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean isImmersiveModeEnabled() {
        return ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        AppUtils.finishActivityLeftToRight(GifFullScreen.this);

    }
}

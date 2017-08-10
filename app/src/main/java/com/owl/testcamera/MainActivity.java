package com.owl.testcamera;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.owl.recorder.CameraPreview;
import com.owl.recorder.CameraUtils;
import com.owl.utils.MLog;

public class MainActivity extends Activity {

    private FrameLayout mCameraLayout;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MLog.d("onCreate");

        initView();
    }

    private void initView() {
        mCameraLayout = (FrameLayout) findViewById(R.id.layout_camera);

        CameraPreview preview = new CameraPreview(this);
        mCamera = CameraUtils.getCameraInstance();
        preview.setCamera(mCamera);

        mCameraLayout.addView(preview);
    }
}

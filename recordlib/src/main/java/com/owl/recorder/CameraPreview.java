package com.owl.recorder;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by qiushunming on 17/8/9.
 */

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder mHolder;
    private Camera mCamera;

    public CameraPreview(Context context) {
        super(context);
        init(context);
    }

    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setCamera(Camera camera) {
        if (mCamera == camera) {
            return;
        }

        mCamera = camera;
    }


    private void init(Context context) {
        mHolder = getHolder();
        mHolder.addCallback(this);

        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (mHolder.getSurface() == null) {
            return;
        }

        try {
            mCamera.stopPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.release();
    }

//    private SurfaceView mSurfaceView;
//    private SurfaceHolder mHolder;
//
//    private Camera.Size mPreviewSize;
//
//    private Camera mCamera;
//    List<Camera.Size> mSupportedPreviewSizes;
//
//    public CameraPreview(Context context) {
//        super(context);
//        init(context);
//    }
//
//    public CameraPreview(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init(context);
//    }
//
//    private void init(Context context) {
//        mSurfaceView = new SurfaceView(context);
//        addView(mSurfaceView);
//
//        mHolder = mSurfaceView.getHolder();
//        mHolder.addCallback(this);
//        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//        MLog.d("surfaceCreated");
//
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//        MLog.d("surfaceChanged");
//
//        Camera.Parameters parameters = mCamera.getParameters();
//        parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
//        requestLayout();
//
//        mCamera.setParameters(parameters);
//
//        mCamera.startPreview();
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        MLog.d("surfaceDestroyed");
//        // Surface will be destroyed when we return, so stop the preview.
//        if (mCamera != null) {
//            // Call stopPreview() to stop updating the preview surface.
//            mCamera.stopPreview();
//        }
//    }
//
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        MLog.d("onLayout changed:" + changed);
//    }
//
//    //open camera
//    public boolean safeCameraOpen(int id) {
//        boolean isOpen = false;
//
//        try {
//
//            releaseCameraAndPreview();
//            mCamera = Camera.open();
//            isOpen = (mCamera != null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return isOpen;
//    }
//
//    private void releaseCameraAndPreview() {
//        setCamera(null);
//        if (mCamera != null) {
//            mCamera.release();
//            mCamera = null;
//        }
//    }
//
//    public void setCamera(Camera camera) {
//        if (mCamera == camera) {
//            return;
//        }
//
//        stopPreviewAndFreeCamera();
//        mCamera = camera;
//
//        if (mCamera != null) {
//            List<Camera.Size> previewSizes = mCamera.getParameters().getSupportedPreviewSizes();
//            mSupportedPreviewSizes = previewSizes;
//
//            requestLayout();
//
//            try {
//                mCamera.setPreviewDisplay(mHolder);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            mCamera.startPreview();
//        }
//    }
//
//    private void stopPreviewAndFreeCamera() {
//
//        if (mCamera != null) {
//            // Call stopPreview() to stop updating the preview surface.
//            mCamera.stopPreview();
//
//            // Important: Call release() to release the camera for use by other
//            // applications. Applications should release the camera immediately
//            // during onPause() and re-open() it during onResume()).
//            mCamera.release();
//
//            mCamera = null;
//        }
//    }
}

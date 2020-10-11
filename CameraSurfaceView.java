package com.example.ddaogi;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder mHolder;
    private Camera camera = null;

    public CameraSurfaceView(Context context){
        super(context);

        mHolder = getHolder();
        mHolder.addCallback(this);
    }
    public void surfaceCreated(SurfaceHolder holder){
        camera = Camera.open();

        try{
            camera.setPreviewDisplay(mHolder);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
        camera.startPreview();
    }

    public void surfaceDestroyed(SurfaceHolder holder){
        camera.stopPreview();
        camera.release();
        camera = null;
    }

//    사진 찍는 메소드
//    public boolean capture(Camera.PictureCallback handler){
//        if(camera != null){
//            camera.takePicture(null,null, handler);
//            return true;
//        } else {
//            return false;
//        }
//    }
}

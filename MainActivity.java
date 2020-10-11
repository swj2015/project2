package com.example.ddaogi;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;


public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
    CameraSurfaceView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = findViewById(R.id.camera_view);

        cameraView = new CameraSurfaceView(this);
        frameLayout.addView(cameraView);

        AutoPermissions.Companion.loadAllPermissions(this, 101);

//        불필요 메소드
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                takePicture();
//            }
//        });

    }



//    public void takePicture(){
//        cameraView.capture(new Camera.PictureCallback(){
//            public void onPictureTaken(byte[] data, Camera camera){
//                try{
//                    Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
//                    String outUriStr = MediaStore.Images.Media.insertImage(
//                            getContentResolver(),
//                            bitmap,
//                            "captured Image",
//                            "Captured Image using Camera.");
//                    if(outUriStr == null){
//                        Log.d("SampleCapture","Image insert failed.");
//                        return;
//                    } else {
//                        Uri outUri = Uri.parse(outUriStr);
//                        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, outUri));
//                    }
//                    camera.startPreview();
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    @Override
    public void onDenied(int i, String[] strings) {

    }

    @Override
    public void onGranted(int i, String[] strings) {

    }
}

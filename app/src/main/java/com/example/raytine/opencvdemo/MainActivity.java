package com.example.raytine.opencvdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raytine.opencvdemo.untils.NDKloader;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "OpenCVLoader";
    private ImageView show_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        TextView textView = (TextView)findViewById(R.id.sample_text);
        textView.setText(NDKloader.stringFromJNI());
        show_image = (ImageView) findViewById(R.id.show_image);
        show_image.setImageResource(R.drawable.timg);
        findViewById(R.id.pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //恢复
                backPic();
            }
        });
        findViewById(R.id.gray_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //变灰
                grayPic();
            }
        });
    }
    private void backPic(){
        show_image.setImageResource(R.drawable.timg);
    }
    private void grayPic(){
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.timg);
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        int[] pixels = new int[w*h];
        bmp.getPixels(pixels, 0, w, 0, 0, w, h);
        //recall JNI
        int[] resultInt = NDKloader.getGrayImage(pixels, w, h);
        Bitmap resultImg = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        resultImg.setPixels(resultInt, 0, w, 0, 0, w, h);
        show_image.setImageBitmap(resultImg);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (OpenCVLoader.initDebug()) {
//            Log.i(TAG, "OpenCV initialize success");
//        } else {
//            Log.i(TAG, "OpenCV initialize failed");
//        }
    }
}

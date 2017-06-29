package com.example.raytine.opencvdemo.untils;

/**
 * Created by Raytine on 2017/6/28.
 */

public class NDKloader {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("opencv_java3");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public static native String stringFromJNI();

    //public static native String validate(long matAddrGr, long matAddrRgba);

    public static native String stringFromJNI();

    public static native String validate(long matAddrGr, long matAddrRgba);

    //图像处理
    public static native int[] getGrayImage(int[] pixels, int w, int h);

}

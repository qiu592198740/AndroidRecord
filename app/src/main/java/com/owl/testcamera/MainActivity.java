package com.owl.testcamera;

import android.app.Activity;
import android.os.Bundle;

import com.owl.utils.MLog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MLog.d("onCreate");
    }
}

package com.adolph.jrm.thefirstdemo_screenlock;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class LockActivity extends Activity {

    private GestureLock lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        SharedPreferences sharedPreferences = getSharedPreferences("password",MODE_PRIVATE);
        final String password = sharedPreferences.getString("password","");

        lock = (GestureLock) findViewById(R.id.view2);
        lock.setOnDrawFinishedListener(new GestureLock.onDrawFinishedListener() {
            @Override
            public boolean onDrawFinished(List<Integer> passList) {
                StringBuilder pwd = new StringBuilder();
                for (Integer i : passList){
                    pwd.append(i);
                }
                if(pwd.toString().equals(password)){
                    Toast.makeText(LockActivity.this, "密码正确", Toast.LENGTH_LONG).show();
                    return true;
                } else {
                    Toast.makeText(LockActivity.this, "密码错误", Toast.LENGTH_LONG).show();
                    return false;
                }
            }
        });
    }
}

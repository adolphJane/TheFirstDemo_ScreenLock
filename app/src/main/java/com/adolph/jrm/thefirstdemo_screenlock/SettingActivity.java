package com.adolph.jrm.thefirstdemo_screenlock;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class SettingActivity extends Activity {

    private GestureLock lock;
    private Button btn_reset;
    private Button btn_save;
    private List<Integer> passList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        lock = (GestureLock) findViewById(R.id.view);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_save = (Button) findViewById(R.id.btn_save);

        lock.setOnDrawFinishedListener(new GestureLock.onDrawFinishedListener() {
            @Override
            public boolean onDrawFinished(List<Integer> passList) {
                if(passList.size() < 3){
                    Toast.makeText(SettingActivity.this,"密码不能小于3",Toast.LENGTH_LONG).show();
                    return false;
                }else {
                    SettingActivity.this.passList = passList;
                    return true;
                }
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lock.resetPoints();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passList != null){
                    StringBuilder stringBuilder = new StringBuilder();
                    for(Integer i : passList){
                        stringBuilder.append(i);
                    }

                    SharedPreferences sharedPreferences = SettingActivity.this.getSharedPreferences("password",SettingActivity.this.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("password",stringBuilder.toString());
                    editor.commit();

                    Toast.makeText(SettingActivity.this,"保存完成",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

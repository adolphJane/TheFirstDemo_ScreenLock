package com.adolph.jrm.thefirstdemo_screenlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button setting_btn;
    private Button lock_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting_btn = (Button) findViewById(R.id.set_btn);
        lock_btn = (Button) findViewById(R.id.rest_btn);

        setting_btn.setOnClickListener(this);
        lock_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_btn:
                Intent intent1 = new Intent(this,SettingActivity.class);
                startActivity(intent1);
                break;
            case R.id.rest_btn:
                Intent intent2 = new Intent(this,LockActivity.class);
                startActivity(intent2);
                break;
        }
    }
}

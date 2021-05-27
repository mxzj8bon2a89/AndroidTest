package com.example.cxc.widgettest_316cxc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NewActivity extends AppCompatActivity implements View.OnClickListener{
    private  Button btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent intent = getIntent();
        String str = intent.getStringExtra("param1");
        int n = intent.getIntExtra("param2", 0);
        System.out.println("-----" + str + "-----" + n);
        //Toast显示
        Toast.makeText(this, str + "---" + String.valueOf(n), Toast.LENGTH_SHORT);
        //在界面的TextView显示
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(str + "---" + String.valueOf(n));

        Button btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnClose:
                finish();
                break;
        }
    }
}

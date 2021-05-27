package com.example.cxc.widgettest_316cxc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private EditText editText;
    private Button btngetContent,btngetsex,btnswap,btnhobby;
    private ImageButton imageButton;
    private ImageView iv;
    private RadioButton rbmale,rbfemale;
    private CheckBox cbbaseket,cbfootball,cbswim;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        //获取六个控件
        textView=(TextView)findViewById(R.id.textView);
        editText=(EditText)findViewById(R.id.editText);
        btngetContent=(Button)findViewById(R.id.btngetContent);
        btngetsex=(Button)findViewById(R.id.btngetsex);
        btnhobby=(Button)findViewById(R.id.btnhobby);
        imageButton=(ImageButton)findViewById(R.id.imageButton);
        iv=(ImageView)findViewById(R.id.iv);
        rg=(RadioGroup)findViewById(R.id.rg);
        rbmale=(RadioButton)findViewById(R.id.rbmale);
        rbfemale=(RadioButton)findViewById(R.id.rbfemale);
        cbbaseket=(CheckBox)findViewById(R.id.cbbaseket);
        cbfootball=(CheckBox)findViewById(R.id.cbfootball);
        cbswim=(CheckBox)findViewById(R.id.cbswim);
        //设置监听器按钮
        imageButton.setOnClickListener(this);
        btngetsex.setOnClickListener(this);
        btngetContent.setOnClickListener(this);
        btnhobby.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btngetContent:
                String str=editText.getText().toString();
                textView.setText(str);
                break;
            case R.id.btnswap:
               iv.setImageResource(R.drawable.guge);
                break;
            case R.id.imageButton:
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("param1",editText.getText().toString());
                intent.putExtra("param2",3);
                startActivity(intent);
                break;
            case R.id.btngetsex:
                if(rbmale.isChecked()) textView.setText("男");
                if(rbfemale.isChecked()) textView.setText("女");
                break;
            case R.id.btnhobby:
                String msg="";
                if(cbbaseket.isChecked()) msg="篮球";
                if(cbfootball.isChecked()) msg="足球";
                if(cbswim.isChecked()) msg="游泳";
                textView.setText(msg);
                break;
        }
    }

}

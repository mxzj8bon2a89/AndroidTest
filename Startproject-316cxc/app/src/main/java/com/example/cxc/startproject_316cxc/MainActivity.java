package com.example.cxc.startproject_316cxc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cxc.startproject_316cxc.bean.WeatherInfo;
import com.example.cxc.startproject_316cxc.iface.WeatherListener;
import com.example.cxc.startproject_316cxc.model.WeatherModel;
import com.example.cxc.startproject_316cxc.model.Weather51Model;

import static com.example.cxc.startproject_316cxc.R.id.editText;

public class MainActivity extends AppCompatActivity implements WeatherListener,View.OnClickListener{
    private EditText etcityno;
    private Button btnfind1,btnfind2;
    private TextView tvcityname,tvcityname2,tvcityname3,tvcityname4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        etcityno=(EditText)findViewById(R.id.editText);
        btnfind1=(Button)findViewById(R.id.button);
        btnfind2=(Button)findViewById(R.id.button2);
        tvcityname=(TextView)findViewById(R.id.textView);
        tvcityname2=(TextView)findViewById(R.id.textView2);
        tvcityname3=(TextView)findViewById(R.id.textView7);
        tvcityname4=(TextView)findViewById(R.id.textView9);

        btnfind1.setOnClickListener(this);
        btnfind2.setOnClickListener(this);
    }

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        if(weatherInfo!=null){
            tvcityname.setText(weatherInfo.getCity());
            tvcityname2.setText(weatherInfo.getWD());
            tvcityname3.setText(weatherInfo.getTemp());
            tvcityname4.setText(weatherInfo.getSD());
        }else {
            tvcityname.setText("未知");
            tvcityname2.setText("未知");
            tvcityname3.setText("未知");
            tvcityname4.setText("未知");
        }

    }

    @Override
    public void OnFail(String msg) {
        tvcityname.setText(msg);
        tvcityname2.setText(msg);
    }

    @Override/*所有点击事件都在这里实现*/
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                System.out.println("---");
                WeatherModel weatherModel = new WeatherModel();
                weatherModel.getWeather(
                        etcityno.getText().toString(),this);
                break;
            case R.id.button2:
                //普通创建对象方式
                Weather51Model weather51Model = new Weather51Model();
                weather51Model.getWeather(etcityno.getText().toString(), this);
                //工厂模式
                //WeatherFactory.getInstance("51wnl").getWeather(cityNOInput.getText().toString(),this);

                break;
            default:
                break;
        }
    }
}

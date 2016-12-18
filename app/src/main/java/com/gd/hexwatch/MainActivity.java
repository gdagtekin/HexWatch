package com.gd.hexwatch;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    TextView textView;
    Date date;
    private android.os.Handler handler;
    String saatS, dakikaS, saniyeS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative);
        textView = (TextView) findViewById(R.id.textView);

        Typeface myTypeface=Typeface.createFromAsset(getAssets(),"ubuntul.ttf");
        textView.setTypeface(myTypeface);

        handler=new android.os.Handler();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                date = new Date();
                String tarih = date.toString();
                int saat = Integer.parseInt(tarih.substring(11, 13));
                if(saat<10){
                    saatS="0"+String.valueOf(saat);
                }
                else{
                    saatS=String.valueOf(saat);
                }
                int dakika = Integer.parseInt(tarih.substring(14, 16));
                if(dakika<10){
                    dakikaS="0"+String.valueOf(dakika);
                }
                else{
                    dakikaS=String.valueOf(dakika);
                }
                int saniye = Integer.parseInt(tarih.substring(17, 19));
                if(saniye<10){
                    saniyeS="0"+String.valueOf(saniye);
                }
                else{
                    saniyeS=String.valueOf(saniye);
                }
                String renk = saatS +dakikaS+ saniyeS;
                relativeLayout.setBackgroundColor(Color.parseColor("#"+renk));
               // ımageView.setBackgroundColor(Color.parseColor("#"+renk));
                textView.setText("#"+saatS + dakikaS+ saniyeS);
                handler.postDelayed(this,1000);
            }
        };

        handler.postDelayed(runnable,500);

    }




}

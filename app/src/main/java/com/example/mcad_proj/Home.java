package com.example.mcad_proj;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    ImageView india,world;
    Spinner spinner;
    Button stat;
    Button callbutton,smsbutton;
    ImageView button_notify,symp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        india=findViewById(R.id.indiaflag);
        world=findViewById(R.id.worldflag);
        stat=findViewById(R.id.stat);
        callbutton=findViewById(R.id.button);
        smsbutton = findViewById(R.id.button2);
        symp=findViewById(R.id.imageView6);

        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this, Statistics.class);
                startActivity(i);

            }

        });

        world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this, Statisticsworld.class);
                startActivity(i);

            }

        });



        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this, Statistics.class);
                startActivity(i);

            }

        });

        callbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8022967200"));
                startActivity(intent);
            }
        });

        smsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //So you can get the edittext value
                String mobileNumber = "8061914960";
                String message = "Hi! I need help regarding corona";
                boolean installed = appInstalledOrNot("com.whatsapp");
                if (installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+mobileNumber + "&text="+message));
                    startActivity(intent);
                }else {
                    Toast.makeText(Home.this, "Whatsapp not installed on your device", Toast.LENGTH_SHORT).show();
                }

            }
        });

        symp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,symptoms.class);
                startActivity(intent);
            }
        });



    }

    private boolean appInstalledOrNot(String url) {
        PackageManager packageManager =getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return app_installed;
    }
}

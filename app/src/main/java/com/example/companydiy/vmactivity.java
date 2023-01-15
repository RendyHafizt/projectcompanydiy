package com.example.companydiy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class vmactivity extends AppCompatActivity {
    TextView tVisi,tMisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vmactivity);

        tVisi = findViewById(R.id.tvisi);
        tMisi = findViewById(R.id.tmisi);
        tVisi.setText(tampilFile("visi"));
        tMisi.setText(tampilFile("misi"));
    }
    public String tampilFile(String fileName) {
        String text = "";
        try {
            InputStream is = getResources().openRawResource(getResources().getIdentifier(fileName, "raw", getPackageName()));
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}
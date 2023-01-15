package com.example.companydiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class UtamaActivity extends AppCompatActivity {
    GridView gridView;
    String [] product = {"Perkakas","Perabotan","Listrik","Aksesoris","Olahraga","Mainan","Komputer","Kosmetik"};
    int [] logoproduct ={R.drawable.settings,R.drawable.home,R.drawable.lightning,R.drawable.aksesoris,R.drawable.sport,R.drawable.toy,R.drawable.komputer,R.drawable.kosmetik};
    ImageButton pro,founder,vm,prestasi;
    String user;
    TextView tuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        pro =findViewById(R.id.profilbutton);
        founder = findViewById(R.id.founderbutton);
        vm = findViewById(R.id.vmbutton);
        prestasi = findViewById(R.id.pencapaianbutton);

        gridView = findViewById(R.id.grid);

        CostumAdapter costumAdapter = new CostumAdapter();
        gridView.setAdapter(costumAdapter);

        tuser = findViewById(R.id.user);
        user = getIntent().getExtras().getString("user");
        tuser.setText("Selamat Datang! \n "+user);

        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(UtamaActivity.this,profilactivity.class);
                startActivity(p);
            }
        });
        founder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(UtamaActivity.this,founderactivity.class);
                startActivity(p);
            }
        });
        vm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(UtamaActivity.this,vmactivity.class);
                startActivity(p);
            }
        });
        prestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(UtamaActivity.this,penghargaanactivity.class);
                startActivity(p);
            }
        });
    }
    private class CostumAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return logoproduct.length;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name = view1.findViewById(R.id.perkakas);
            ImageView image = view1.findViewById(R.id.gambar);

            name.setText(product[i]);
            image.setImageResource(logoproduct[i]);
            return view1;

        }
    }
}
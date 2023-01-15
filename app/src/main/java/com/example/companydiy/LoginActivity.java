package com.example.companydiy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText eUser,ePass;
    ImageButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUser = findViewById(R.id.eusername);
        ePass = findViewById(R.id.epassword);
        login = findViewById(R.id.buttonlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonlogin();
            }
        });
    }
    public void buttonlogin (){
        String user,pass;
        user = eUser.getText().toString();
        pass = ePass.getText().toString();

        if (pass.equals("admin")){
            Toast.makeText(this,"Selamat Datang ,"+user,Toast.LENGTH_LONG).show();
            Intent a = new Intent(LoginActivity.this,UtamaActivity.class);
            a.putExtra("user",user);
            startActivity(a);
        }else {
            showDialog();
        }
    }
    public void showDialog(){
        AlertDialog.Builder pesanSalah = new AlertDialog.Builder(this);
        pesanSalah.setTitle("Erorr!!!");
        pesanSalah
                .setMessage("Maaf Username atau Password Salah")
                .setIcon(R.drawable.error)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = pesanSalah.create();
        alertDialog.show();

    }
}
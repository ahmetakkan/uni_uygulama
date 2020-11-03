package com.example.ilkders;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private EditText name;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.txtisim);
        send = (Button) findViewById(R.id.btngiris);
        send.setOnClickListener(this);
        setTitle("Kullanıcı Girişi");
    }
    public void onClick(View view) {
        if(isValidName(name.getText().toString()))
            goToWelcome(name.getText().toString());
        else
            Toast.makeText(this,"Lütfen geçerli bir isim girin (3-20 harf aralığında)", Toast.LENGTH_SHORT).show();
    }
    private boolean  isValidName(String name){
        return name.length() >= 3 && name.length() <= 20;
    }
    private void goToWelcome(String name){
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
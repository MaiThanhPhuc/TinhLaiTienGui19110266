package com.android.s19110266;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText stginput;
    private EditText lsginput;
    private EditText khginput;

    public static final int REQUEST_CALC = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stginput = findViewById(R.id.stginput);
        lsginput = findViewById(R.id.lsginput);
        khginput = findViewById(R.id.khginput);
    }

    public void TinhLai(View view){
        if (stginput.getText().toString().length() == 0 || lsginput.getText().toString().length() == 0 || lsginput.getText().toString().length() == 0||
        khginput.getText().toString().length() == 0){
            Toast.makeText(this, "Please fill all textbox", Toast.LENGTH_SHORT).show();
        }
        else {
            String tienGui = stginput.getText().toString();
            String laiSuat = lsginput.getText().toString();
            String kyHan = khginput.getText().toString();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("TG", tienGui);
            intent.putExtra("LS", laiSuat);
            intent.putExtra("KH", kyHan);
            startActivityForResult(intent,REQUEST_CALC);
        }
    }

}
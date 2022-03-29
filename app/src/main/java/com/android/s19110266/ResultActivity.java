package com.android.s19110266;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 1;
    private double tienLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double tienGui = Double.parseDouble(intent.getStringExtra("TG"));
        double laisuat = Double.parseDouble(intent.getStringExtra("LS")) ;
        double kyhan = Double.parseDouble(intent.getStringExtra("KH"));
        this.tienLai =  (tienGui*(laisuat/100)*(kyhan*30))/360;

        TextView tienLaiView = findViewById(R.id.tienlai);
        tienLaiView.setText(String.valueOf(tienLai) +"₫");
        TextView tongtienView = findViewById(R.id.tongtien);
        tongtienView.setText(String.valueOf(tienLai + tienGui)+"₫");
    }
    public void takeAPicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_CAMERA);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            finish();
        }
    }
}
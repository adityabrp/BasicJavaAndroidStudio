package com.aditya.intentactivitynavigasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_moveactivity);
        Button btnMoveWithData = findViewById(R.id.btn_activity_data);
        Button btnDialPhone = findViewById(R.id.btn_dial_number);

        btnMoveWithData.setOnClickListener(this);
        btnMoveActivity.setOnClickListener(this);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_moveactivity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
            break;

            case R.id.btn_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, moveWithData.class);
                moveWithDataIntent.putExtra(moveWithData.EXTRA_NAME, "Aditya Bagus ");
                moveWithDataIntent.putExtra(moveWithData.EXTRA_AGE, 22);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "08976567899";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}

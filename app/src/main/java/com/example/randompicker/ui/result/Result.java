package com.example.randompicker.ui.result;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.randompicker.R;

public class Result extends AppCompatActivity {

    private TextView result;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.resultText);
        back = (ImageButton) findViewById(R.id.resultButton);

        Bundle b = getIntent().getExtras();
        String item = b.getString("result");

        result.setText(item);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

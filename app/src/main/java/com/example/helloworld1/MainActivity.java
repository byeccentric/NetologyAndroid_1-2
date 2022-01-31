package com.example.helloworld1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        Button btnSave = findViewById(R.id.buttonOk);
        Button btnClear = findViewById(R.id.buttonClear);

        EditText userName = findViewById(R.id.userName);
        EditText userEmail = findViewById(R.id.userEmail);

        TextView resultText = findViewById(R.id.resultText);
        Resources res = getResources();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                if (name.equals("") || email.equals("")) {
                    Toast.makeText(MainActivity.this, R.string.error_text, Toast.LENGTH_LONG).show();
                } else {

                    resultText.setText(String.format(res.getString(R.string.result_text), name, email));
                    resultText.setVisibility(View.VISIBLE);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText.setVisibility(View.INVISIBLE);
                resultText.setText("");
                userName.setText("");
                userEmail.setText("");
            }
        });
    }
}
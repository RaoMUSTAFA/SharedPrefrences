package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val =  editText.getText().toString();
                SharedPreferences sp = getSharedPreferences("My Pref",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",val);
                editor.apply();
                textView.setText(val);
            }
        });
        SharedPreferences sp = getSharedPreferences("My Pref",MODE_PRIVATE);
        String editVal = sp.getString("name","No value as of now");
        textView.setText(editVal);
    }
}
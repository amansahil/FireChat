package com.example.amansahil.firechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText username;
    Spinner lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEnter();
    }

    public void userEnter(){
        b1 = findViewById(R.id.login_button);
        username = findViewById(R.id.username);
        lang = findViewById(R.id.lang);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String userLang = lang.getSelectedItem().toString();
                String selectedLang = "";
                switch(userLang) {
                    case "Spanish":
                        selectedLang = "es";
                        break;
                    case "French":
                        selectedLang = "fr";
                        break;
                    case "Arabic":
                        selectedLang = "ar";
                        break;
                    default:
                        selectedLang = "en";
                }
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                i.putExtra("username", name);
                i.putExtra("userLang", selectedLang);
                startActivity(i);
            }

        });
    }
}

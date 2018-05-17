package com.example.amansahil.firechat;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class MenuActivity extends Activity{
    TextView t1;
    Button science;
    Button technology;
    Button pets;
    Button humour;
    Button nutella;
    Button sports;

    private static final String API_KEY = "INSERT YOUR API KEY HERE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        translatedText();
        redirect();
    }

    public void translatedText(){
        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");
        final String userLang = bundle.getString("userLang");
        t1 = findViewById(R.id.hello);
        t1.setText("Hello " + username);
        final Handler textViewHandler = new Handler();
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                TranslateOptions options = TranslateOptions.newBuilder().setApiKey(API_KEY).build();
                final Translate translate = options.getService();
                final Translation translation = translate.translate("Hello " + username, Translate.TranslateOption.targetLanguage(userLang));
                textViewHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        t1.setText(Html.fromHtml(translation.getTranslatedText()));
                    }
                });
                return null;
            }
        }.execute();
    }
    public void redirect() {
        science = findViewById(R.id.science);

        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");
        final String userLang = bundle.getString("userLang");
        technology = findViewById(R.id.technology);
        pets = findViewById(R.id.pet);
        humour = findViewById(R.id.humour);
        nutella = findViewById(R.id.nutella);
        sports = findViewById(R.id.sports);
        String cat ="science";
        final Intent i = new Intent(MenuActivity.this, ChatActivity.class);
        i.putExtra("username", username);
        i.putExtra("userLang", userLang);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("cat", "science");
                startActivity(i);
            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("cat", "technology");
                startActivity(i);
            }
        });

        pets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("cat", "pets");
                startActivity(i);
            }
        });
        humour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("cat", "humour");
                startActivity(i);
            }
        });
        nutella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("cat", "nutella");
                startActivity(i);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("cat", "sports");
                startActivity(i);
            }
        });

    }
}

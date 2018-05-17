package com.example.amansahil.firechat;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class ChatActivity extends Activity {

    private FirebaseListAdapter<ChatMessage> adapter; //New
    FloatingActionButton send;
    EditText message;
    ListView messageList;
    private static final String API_KEY = "INSERT YOUR API KEY HERE";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        addData();
        displayData();
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void displayData(){
        messageList = findViewById(R.id.list_of_messages);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("username");
        String cat = bundle.getString("cat");
        final String userlang = bundle.getString("userLang");
        Query query = database.getReference().child(cat).child("Messages");
        FirebaseListOptions<ChatMessage> options = new FirebaseListOptions.Builder<ChatMessage>().setQuery(query, ChatMessage.class).setLayout(R.layout.messages).build();
        adapter = new FirebaseListAdapter<ChatMessage>(options) {
            @Override
            protected void populateView(View v, final ChatMessage model, int position) {
                final TextView username = v.findViewById(R.id.username);
                final TextView usermessage = v.findViewById(R.id.usermessage);
                ImageView useravatar = v.findViewById(R.id.imageView);
                useravatar.setBackgroundResource(R.drawable.user);
                username.setText(model.getMessageUser());
                final Handler textViewHandler = new Handler();
                new AsyncTask<Void, Void, Void>(){
                    @Override
                    protected Void doInBackground(Void... voids) {
                        TranslateOptions options = TranslateOptions.newBuilder().setApiKey(API_KEY).build();
                        final Translate translate = options.getService();
                        final Translation translation = translate.translate(model.getMessageText(), Translate.TranslateOption.targetLanguage(userlang));
                        textViewHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                usermessage.setText(Html.fromHtml(translation.getTranslatedText()));
                            }
                        });
                        return null;
                    }
                }.execute();

            }
        };

        messageList.setAdapter(adapter);
    }

    public void addData(){
        send = findViewById(R.id.fab);
        message = findViewById(R.id.input);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usermessage = message.getText().toString();
                if(usermessage != null && !usermessage.trim().isEmpty()){
                    Bundle bundle = getIntent().getExtras();
                    String username = bundle.getString("username");
                    String cat = bundle.getString("cat");
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference().child(cat).child("Messages");
                    DatabaseReference keyRef = myRef.push();
                    keyRef.setValue(new ChatMessage(usermessage, username));
                    message.setText("");
                }
            }
        });
    }}

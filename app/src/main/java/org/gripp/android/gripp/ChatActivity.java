package org.gripp.android.gripp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private Button chatbtnSend;
    private EditText chatMsg;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public String name,email,message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mDatabase = FirebaseDatabase.getInstance().getReference("suggestionchats");

        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    name=firebaseAuth.getCurrentUser().getDisplayName();
                    email=firebaseAuth.getCurrentUser().getEmail();
                    chatbtnSend=(Button) findViewById(R.id.chatbtnSend);
                    chatMsg=(EditText) findViewById(R.id.chatMsg);
                    message=chatMsg.getText().toString();
                    chatbtnSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SuggestionChatClass suggestionChatClass=new SuggestionChatClass(name,message,email);
                            mDatabase.setValue(suggestionChatClass);
                        }
                    });
                }else{
                    startActivity(new Intent(ChatActivity.this,MainActivity.class));
                }
            }
        };



    }

}

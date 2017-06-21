package com.samih.abs.yknmsharedprefex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    private EditText etEmail,etPassw;
    private Button btnSigIn,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassw=(EditText)findViewById(R.id.etPassw);
        btnSigIn=(Button)findViewById(R.id.btnLognIn);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);

        eventHandler();
    }

    private void eventHandler() {
        btnSigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    private void dataHandler() {
        String stemail=etEmail.getText().toString();
        String stpassw=etPassw.getText().toString();

        SharedPreferences pref=getSharedPreferences("mypref",MODE_PRIVATE);
        String em=pref.getString("em",null);
        String pw=pref.getString("pw",null);

        if(em!=null && em.equals(stemail) && pw!=null && pw.equals(stpassw))
        {
            startActivity(new Intent(getBaseContext(),MainActivity.class));
        }
        else
        {
            etEmail.setError("Wrong Email Or Password");
            etPassw.setError("Wrong Email Or Password");
        }

    }
}

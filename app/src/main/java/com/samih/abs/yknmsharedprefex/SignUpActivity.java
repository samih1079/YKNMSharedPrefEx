package com.samih.abs.yknmsharedprefex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private EditText etEmail,etPassw1,etPassw2;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassw1=(EditText)findViewById(R.id.etPassw1);
        etPassw2=(EditText)findViewById(R.id.etPassw2);

        btnSave=(Button)findViewById(R.id.btnSave);

        eventHandler();

    }
    private void  eventHandler()
    {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }
    private   void dataHandler()
    {
        String stemail=etEmail.getText().toString();
        String stPassw1=etPassw1.getText().toString();
        String stPassw2=etPassw2.getText().toString();
        boolean isOk=true;
        if(stemail.length()==0 || !stemail.contains("@"))
        {
            isOk=false;
            etEmail.setError("Wrong Email");
        }
        if(stPassw1.length()<3)
        {
            isOk=false;
            etPassw1.setError("Wrong Password , at least 3 chars");
        }
        if(!stPassw1.equals(stPassw2))
        {
            etPassw2.setError("Must be the same Password!");
            isOk=false;
        }
        if(isOk)
        {
            SharedPreferences pref=getSharedPreferences("mypref",MODE_PRIVATE);

            SharedPreferences.Editor editor=pref.edit();
            editor.putString("em",stemail);
            editor.putString("pw",stPassw1);
            editor.commit();
            Intent i=new Intent(this,SignInActivity.class);
            startActivity(i);

        }
    }

}

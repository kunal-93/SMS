package com.example.sms;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;
import java.util.Dictionary;
import java.util.Hashtable;

public class LoginActivity extends AppCompatActivity {

    private EditText SchoolCode;
    private EditText UserId;
    private EditText Password;
    private Button SignInBtn;


    private Dictionary UserMap = new Hashtable();

    private void makeUserMap(){
        UserMap.put("kdhawan","kunal");
        UserMap.put("pthakur","priyanka");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SchoolCode = (EditText) findViewById(R.id.SchoolCode);
        UserId = (EditText)findViewById(R.id.UserId);
        Password = (EditText) findViewById(R.id.LoginPassword);
        SignInBtn = (Button)findViewById(R.id.SignInBtn);

        makeUserMap();

        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCredentials(UserId.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validateCredentials(String UserName, String LoginPassword){
        Toast toast;
        System.out.println(UserMap.get(UserName.toLowerCase()));
        if(UserMap.get(UserName.toLowerCase()).equals(LoginPassword)){
            toast = Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            toast = Toast.makeText(getApplicationContext(),"Incorrect UserName/Password", Toast.LENGTH_SHORT);

        }
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}

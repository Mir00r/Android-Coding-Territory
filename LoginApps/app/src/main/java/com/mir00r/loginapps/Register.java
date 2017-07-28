package com.mir00r.loginapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText name, surName, age, userName, password;
    String strName, strSurName, strAge, strUserName, strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        viewInitializer();
    }


    public void viewInitializer () {
        name = (EditText) findViewById(R.id.editText_name);
        surName = (EditText) findViewById(R.id.editText_surname);
        age = (EditText) findViewById(R.id.editText_age);
        userName = (EditText) findViewById(R.id.editText_user_name);
        password = (EditText) findViewById(R.id.editText_password);
    }

    public void OnRegister(View view) {
        strName = name.getText().toString();
        strSurName = surName.getText().toString();
        strAge = age.getText().toString();
        strUserName = userName.getText().toString();
        strPassword = password.getText().toString();
        String type = "register";

        BackGroundWorker backGroundWorker = new BackGroundWorker(this);
        backGroundWorker.execute(type, strName, strSurName, strAge, strUserName, strPassword);
    }
}

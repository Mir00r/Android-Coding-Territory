package com.mir00r.loginapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userNameEt, passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputInitializer();
    }

    public void inputInitializer () {
        userNameEt = (EditText) findViewById(R.id.etUserName);
        passwordEt = (EditText) findViewById(R.id.etPassword);
    }

    public void OnLogin(View view) {
        String userName = userNameEt.getText().toString();
        String password = passwordEt.getText().toString();
        String type = "login";

        BackGroundWorker backGroundWorker = new BackGroundWorker(this);
        backGroundWorker.execute(type, userName, password);
    }

    public void OnRegi (View view) {
        startActivity(new Intent(this, Register.class));
    }
}

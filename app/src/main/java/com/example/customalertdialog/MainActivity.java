package com.example.customalertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CustomDialog.ExampleDialogListener {

    TextView mUsername, mPassword;
    Button mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.textview_username);
        mPassword = findViewById(R.id.textview_password);
        mDialog = findViewById(R.id.button_dialog);

        mDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogAction();

            }
        });

    }

    public void dialogAction(){

        CustomDialog customDialog = new CustomDialog();
        customDialog.show(getSupportFragmentManager(), "Example Dialog");

    }

    @Override
    public void applyTexts(String username, String password) {

        mUsername.setText(username);
        mPassword.setText(password);

    }

}

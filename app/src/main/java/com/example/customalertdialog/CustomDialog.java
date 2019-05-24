package com.example.customalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDialog extends AppCompatDialogFragment {

    EditText editUsername, editPassword;

    ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(view)
                .setTitle("Login Forum")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String username = editUsername.getText().toString();
                        String password = editPassword.getText().toString();

                        if (username.length()!=0 && password.length()!=0){

                            listener.applyTexts(username, password);


                        }

                        else {

                            Toast.makeText(getActivity(), "Enter the values", Toast.LENGTH_SHORT).show();
                            builder.setCancelable(true);

                        }
                    }
                });

        editUsername = view.findViewById(R.id.edit_username);
        editPassword = view.findViewById(R.id.edit_password);

        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement example dialog listener");
        }

    }

    // To get and pass the data to the MainActivity

    public interface ExampleDialogListener {

        void applyTexts(String username, String password);

    }

}

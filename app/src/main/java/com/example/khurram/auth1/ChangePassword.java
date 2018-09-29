package com.example.khurram.auth1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {

    EditText e1;
   private FirebaseAuth auth;
      ProgressDialog dialog;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        dialog = new ProgressDialog(this);
        e1 = (EditText)findViewById(R.id.editpass);


    }

    public void btnUserLogin_Click(View v) {
        {

            if(user != null) {

                dialog.setMessage("Changing Password , Please Wait!!!");
                dialog.show();
                user.updatePassword(e1.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {



                                    Toast.makeText(getApplicationContext(), "Your Password has been change", Toast.LENGTH_LONG).show();
                                    FirebaseAuth.getInstance().signOut();
                                    finish();
                                    Intent i = new Intent(ChangePassword.this, LoginActivity.class);
                                    startActivity(i);


                                } else {



                                    Toast.makeText(getApplicationContext(), "Password could not be change", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        }
    }}



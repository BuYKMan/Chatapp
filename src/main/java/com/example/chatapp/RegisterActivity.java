package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
public class RegisterActivity extends AppCompatActivity {

    EditText name,email,password;
    Button register_button;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name =findViewById(R.id.name);
        email =findViewById(R.id.email);
        password =findViewById(R.id.password);
        register_button =findViewById(R.id.Register_buutton);
        auth  = FirebaseAuth.getInstance();

        register_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
           if(name==null || name.getText().toString().isEmpty()||password==null || password.getText().toString().isEmpty())
            {
                Toast.makeText(RegisterActivity.this,"Please fill al fields",Toast.LENGTH_SHORT).show();
            }
            else
            {
                String username =name.getText().toString().trim();
                String mail =email.getText().toString().trim();
                String passwd = password.getText().toString().trim();
                try {
                Register(mail,passwd);
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            }
        }

        });
    }

    private void Register(String mail, String passwd) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(mail, passwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = auth.getCurrentUser();
                            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(name.toString()).build();

                            user.updateProfile(profileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                        Toast.makeText(RegisterActivity.this, "Authentication is successful.",
                                                Toast.LENGTH_SHORT).show();{

                                    }
                                }
                            });

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        // [END create_user_with_email]
    }
}
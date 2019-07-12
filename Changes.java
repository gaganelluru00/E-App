package com.example.gagan.system;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Changes extends AppCompatActivity {
   private Button b1,b2,b3;
    private TextView t1,t2;
   private EditText e1,e2;
   private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changes);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
       // b4=(Button)findViewById(R.id.b4);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        mAuth=FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                user.updateEmail(e1.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Changes.this, "Email address updated ", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Changes.this, "Failed to update email", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user1=FirebaseAuth.getInstance().getCurrentUser();
                user1.updatePassword(e2.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Changes.this, "password updated successfully ", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Changes.this, "Failed to update password", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           mAuth.signOut();
                LoginManager.getInstance().logOut();
                updateUI();
            }
        });
      /*  auth.signOut();
        FirebaseAuth.AuthStateListener authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {

                    startActivity(new Intent(Changes.this, Login.class));
                    finish();
                }
            }
        };
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();

            }
        });*/
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null){
            updateUI();
        }
    }
    private void updateUI(){
        Intent a=new Intent(Changes.this,Login.class);
        startActivity(a);
        finish();
        Toast.makeText(Changes.this, "You're Logged Out", Toast.LENGTH_SHORT).show();
    }
}

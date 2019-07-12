package com.example.gagan.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.gagan.system.R.*;

public class Login extends AppCompatActivity {
    private Button b1,b2;
   private EditText email,password;
   private ProgressBar progressBar;
   private FirebaseAuth auth,mAuth;
   private CallbackManager mCallbackManager;
   private static final String TAG="FACELOG";
   private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);
        // Initialize Facebook Login button


        auth=FirebaseAuth.getInstance();
       /* if(auth.getCurrentUser()!=null){
            Intent x=new Intent(Login.this,Index.class);
            startActivity(x);
            finish();}*/
        setContentView(layout.activity_login);



 auth=FirebaseAuth.getInstance();
            b1=(Button)findViewById(id.b1);
        email=(EditText)findViewById(id.e1);
        password=(EditText)findViewById(id.e2);
        progressBar=(ProgressBar)findViewById(id.pb1);
        b2=(Button)findViewById(id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w=new Intent(Login.this,forgotpassword.class);
                startActivity(w);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String e=email.getText().toString();
           final String p=password.getText().toString();
           if(TextUtils.isEmpty(e)){
               Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(p)){
               Toast.makeText(Login.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
               return;
           }

           progressBar.setVisibility(View.VISIBLE);
           auth.signInWithEmailAndPassword(e,p).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   progressBar.setVisibility(View.GONE);
                   if (!task.isSuccessful()) {
                       // there was an error
                       if (p.length() < 6) {

                           Toast.makeText(Login.this, "password is too short", Toast.LENGTH_SHORT).show();
                       } else {
                           Toast.makeText(Login.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                       }
                   }
                       else{
                       Intent z=new Intent(Login.this,Page.class);
                       startActivity(z);
                       finish();
                   }

               }
           });

            }
        });
///////
        mAuth=FirebaseAuth.getInstance();
        b3=(Button)findViewById(id.b3);
        mCallbackManager = CallbackManager.Factory.create();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setEnabled(false);
                LoginManager.getInstance().logInWithReadPermissions(Login.this,Arrays.asList("email","public_profile"));
                LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d(TAG, "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "facebook:onCancel");
                        // ...
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d(TAG, "facebook:onError", error);
                        // ...
                    }
                });
            }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            updateUI();
        }
    }
    private void updateUI(){
        Intent a=new Intent(Login.this,Page.class);
        startActivity(a);
        finish();
        Toast.makeText(Login.this, "You're Logged In", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            b3.setEnabled(true);
                            updateUI();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            b3.setEnabled(true);
                            updateUI();
                        }

                        // ...
                    }
                });
    }

}

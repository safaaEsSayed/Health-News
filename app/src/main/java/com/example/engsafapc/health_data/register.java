package com.example.engsafapc.health_data;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    EditText email1 , password1 , name1 , phonenum1;
    Button register;
    ImageView imageView;
    TextView login1;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.register );
        email1 = findViewById ( R.id.email );
        password1 = findViewById ( R.id.password );
        register = findViewById ( R.id.buttonRegister );
        name1 = findViewById ( R.id.name );
        phonenum1 = findViewById ( R.id.phone );
        imageView= findViewById ( R.id.icon );
        login1= findViewById ( R.id.login );
        //fireBase auth
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String SEmail=email1.getText ().toString ();
                String SPassword=password1.getText ().toString ();
              if(TextUtils.isEmpty ( SEmail )){
                  email1.setError ( "E-mail is Required" );
                  return;
              }
              if(TextUtils.isEmpty ( SPassword )){
                  password1.setError ( "password is Required" );
                  return;
              }
              if(SPassword.length ()>6){
                  password1.setError ( "password is too long" );
                  return;
              }
              //ask for e.mail and password
              auth.createUserWithEmailAndPassword ( SEmail,SPassword ).addOnCompleteListener ( new OnCompleteListener <AuthResult> () {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful ()){
                          Toast.makeText ( com.example.engsafapc.health_data.register.this,"Register is completed",Toast.LENGTH_SHORT).show ();
                          startActivity ( new Intent ( com.example.engsafapc.health_data.register.this, home.class ) );
                      }
                      else {
                          Toast.makeText ( com.example.engsafapc.health_data.register.this,"Register is failed" ,Toast.LENGTH_SHORT).show ();
                      }
                  }
              } );

            }
        } );
login1.setOnClickListener ( new View.OnClickListener () {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent ( com.example.engsafapc.health_data.register.this,login.class );
        startActivity ( intent );
    }
} );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem languages =menu.add ( "Languages" );
        return true;
    }
}

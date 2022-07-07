package com.example.engsafapc.health_data;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
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

public class login extends AppCompatActivity {
EditText editmail , editpass ;
Button sub;
TextView login;
ImageView imageEye;
static boolean showitem = false;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        editmail=findViewById ( R.id.email );
        editpass=findViewById ( R.id.password );
        sub=findViewById ( R.id.loginbtn );
        login=findViewById ( R.id.loginWord );
        imageEye=findViewById ( R.id.eyeLogo );
        auth=FirebaseAuth.getInstance ();
        sub.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String SEmail=editmail.getText ().toString ();
                String SPassword=editpass.getText ().toString ();
                if(TextUtils.isEmpty ( SEmail )){
                    editmail.setError ( "E-mail is Required" );
                    return;
                }
                if(TextUtils.isEmpty ( SPassword )){
                    editpass.setError ( "password is Required" );
                    return;
                }
                if(SPassword.length ()>6){
                    editpass.setError ( "password is too long" );
                    return;
                }
                //password and email sign in
                auth.signInWithEmailAndPassword ( SEmail,SPassword ).addOnCompleteListener ( new OnCompleteListener <AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task <AuthResult> task) {
                        if(task.isSuccessful ()){
                            Toast.makeText ( login.this,"Register is completed",Toast.LENGTH_SHORT).show ();
                            startActivity ( new Intent ( login.this, home.class ) );
                            finish();
                        }
                        else{
                            Toast.makeText ( login.this,"Register is failed" ,Toast.LENGTH_SHORT).show ();
                        }
                    }
                } );

               }


        } );
        //show and hide password
        imageEye.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (showitem == false) {
                    editpass.setInputType ( InputType.TYPE_CLASS_TEXT );
                    imageEye.setImageResource ( R.drawable.hide );
                    showitem=true;

                } else {
                    editpass.setInputType ( InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD );
                    imageEye.setImageResource ( R.drawable.show );
                    showitem = false;
                }

            }
        } );
        login.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( login.this,register.class );
                startActivity ( intent );
            }
        } );
    }
}

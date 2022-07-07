package com.example.engsafapc.health_data;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ChangingLang extends AppCompatActivity implements View.OnClickListener {


    protected CheckBox arabic;
    protected CheckBox english;
    protected CheckBox egypt;
    protected CheckBox saudi;
    protected CheckBox united;
    protected Button submit;
    protected TextView logout;
    private String Lang = "en";
    private String Coun = "us";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_changing_lang);
        initView();
        Log.e("user" ,  FirebaseAuth.getInstance().getCurrentUser()+"");
        onCountryChecked();
        onLangChecked();
    }

    private void onCountryChecked() {
        egypt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Coun = "eg";
                    check3(egypt, saudi, united);
                }


            }
        });

        saudi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Coun = "sa";
                    check3(saudi, egypt, united);
                }


            }
        });

        united.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Coun = "us";
                    check3(united, saudi, egypt);

                }


            }
        });
    }


    private void onLangChecked() {
        english.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Lang = "en";
                    check2(english, arabic);
                }
            }
        });

        arabic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Lang = "ar";
                    check2(arabic, english);

                }
            }
        });
    }


    private void check2(CheckBox chick, CheckBox unCheck) {
        chick.setChecked(true);
        unCheck.setChecked(false);
    }

    private void check3(CheckBox chick, CheckBox unCheck1, CheckBox unCheck2) {
        chick.setChecked(true);
        unCheck1.setChecked(false);
        unCheck2.setChecked(false);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit) {
            Intent intent = new Intent(ChangingLang.this, home.class);
            intent.putExtra("Lang", Lang);
            intent.putExtra("Coun", Coun);
            startActivity(intent);
        } else if (view.getId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
           startActivity(new Intent(ChangingLang.this , login.class));
           finish();
        }
    }

    private void initView() {
        arabic = (CheckBox) findViewById(R.id.arabic);
        english = (CheckBox) findViewById(R.id.english);
        egypt = (CheckBox) findViewById(R.id.egypt);
        saudi = (CheckBox) findViewById(R.id.saudi);
        united = (CheckBox) findViewById(R.id.united);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(ChangingLang.this);
        logout = (TextView) findViewById(R.id.logout);
        logout.setOnClickListener(ChangingLang.this);
    }
}
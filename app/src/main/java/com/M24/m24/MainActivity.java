package com.M24.m24;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import Modalclass.EmergencyServices;

public class MainActivity extends AppCompatActivity {
    LinearLayout loginActivity,Form,Otp,Address,blur;
    TextView Login,Register,Forgetpassword;
    EditText Email,Password,Phonenumber,Conformpassword,Otp1,Otp2,Otp3,Otp4,Otp5,Otp6;
    Button Logreg,Resend,Confirm,Submit;
    ImageView Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ////////////login page start/////////
        loginActivity = findViewById(R.id.loginactivity);
        Form = findViewById(R.id.loginform);
        blur = findViewById(R.id.blurbackground);
        //Animation bgfade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.backgroundfading);
       // loginActivity.startAnimation(bgfade);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               // loginActivity.setBackgroundColor(Color.WHITE);
//                Form.animate().setStartDelay(4000).setDuration(100).setListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                     // Form.setVisibility(View.VISIBLE);
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//
//                    }
//                });
              // blur.setBackgroundColor(Color.rgb(255,254,254));
               Form.setVisibility(View.VISIBLE);
//
            }
        },5300);
        ///////////////end of login/////////
        Login=findViewById(R.id.login);
        Register=findViewById(R.id.register);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Phonenumber = findViewById(R.id.phonenumber);
        Conformpassword = findViewById(R.id.conform);
        Forgetpassword = findViewById(R.id.forget);
        Logreg = findViewById(R.id.loginregister);
        Logo = findViewById(R.id.logo);

        Otp = findViewById(R.id.otp);
        Otp1 = findViewById(R.id.otp1);
        Otp2 = findViewById(R.id.otp2);
        Otp3 = findViewById(R.id.otp3);
        Otp4 = findViewById(R.id.otp4);
        Otp5 = findViewById(R.id.otp5);
        Otp6 = findViewById(R.id.otp6);
        Resend = findViewById(R.id.resend);
        Confirm = findViewById(R.id.confirm);

        Address =findViewById(R.id.address);
        Submit =findViewById(R.id.submit);
        Register.setTypeface(null, Typeface.BOLD);
        Login.setTypeface(null, Typeface.NORMAL);
        
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.setTypeface(null, Typeface.BOLD);
                Register.setTypeface(null, Typeface.NORMAL);
                Conformpassword.setVisibility(View.GONE);
                Phonenumber.setVisibility(View.GONE);
                Forgetpassword.setVisibility(View.VISIBLE);
                Logreg.setText("Login");
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register.setTypeface(null, Typeface.BOLD);
                Login.setTypeface(null, Typeface.NORMAL);
                Conformpassword.setVisibility(View.VISIBLE);
                Phonenumber.setVisibility(View.VISIBLE);
                Forgetpassword.setVisibility(View.GONE);
                Logreg.setText("Register");
            }
        });
        Logreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Form.setVisibility(View.GONE);
                Otp.setVisibility(View.VISIBLE);
            }
        });
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Otp.setVisibility(View.GONE);
                Logo.setVisibility(View.GONE);
                Address.setVisibility(View.VISIBLE);
                Logo.setVisibility(View.GONE);
            }
        });
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
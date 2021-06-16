
package com.M24.m24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Modalclass.EmergencyServices;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    LinearLayout Form,logbar,regbar,carbox,bikebox,heavybox,carformbox,bikeformbox,heavyformbox;
    ConstraintLayout login,register,otpbox,passwordbox,register1;
    TextView Login,Register,Forgetpassword,emailwarning,passwordwarning;
    EditText Emaillog,Passwordlog,name,place,district,pincode,phonenum,email,otp,pass,confpass,carmanu,caryear,carmodel,
             bikemanu,bikemodel,bikeyear,heavymanu,heavymodel,heavyyear;
    Button Logb,regb,Submitb,resend,conformotp,setpass,car,bike,heavy;
    ImageView Logo,carok,bikeok,heavyok;
    String  Emaillogtxt,Passwordlogtxt,nametxt,placetxt,districttxt,pincodetxt,phonenumtxt,emailtxt,otptxt,passtxt,confpasstxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ////////////login page start/////////
        Form = findViewById(R.id.loginform);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Form.setVisibility(View.VISIBLE);
            }
        }, 5300);
        mAuth = FirebaseAuth.getInstance();


        Login =findViewById(R.id.logintxt);
        Register = findViewById(R.id.registertxt);
        logbar = findViewById(R.id.loginbar);
        regbar = findViewById(R.id.registerbar);
        login = findViewById(R.id.loginbox);
        register1 = findViewById(R.id.registerbox1);
        register= findViewById(R.id.registerbox);
        otpbox = findViewById(R.id.otpbox);
        passwordbox = findViewById(R.id.passwordbox);
        carbox = findViewById(R.id.carlayout);
        bikebox = findViewById(R.id.bikelayout);
        heavybox = findViewById(R.id.heavylayout);
        carformbox = findViewById(R.id.carformlayout);
        bikeformbox = findViewById(R.id.bikeformlayout);
        heavyformbox = findViewById(R.id.heavyformlayout);




        carok = findViewById(R.id.carok);
        bikeok = findViewById(R.id.bikeok);
        heavyok = findViewById(R.id.heavyok);





        Emaillog = findViewById(R.id.email);
        Passwordlog = findViewById(R.id.password);
        name = findViewById(R.id.name);
        place = findViewById(R.id.place);
        district = findViewById(R.id.dist);
        pincode = findViewById(R.id.pin);
        phonenum = findViewById(R.id.Phonenumber);
        email = findViewById(R.id.email);
        Forgetpassword = findViewById(R.id.forgetpassword);
        emailwarning = findViewById(R.id.emailidwarning);
        passwordwarning = findViewById(R.id.passworddwarning);
        otp = findViewById(R.id.otp);
        pass = findViewById(R.id.setpassword);
        confpass = findViewById(R.id.setpasswordconform);
        carmanu = findViewById(R.id.carmanufactetxt);
        bikemanu = findViewById(R.id.bikemanufactetxt);
        heavymanu = findViewById(R.id.heavymanufactetxt);
        carmodel = findViewById(R.id.carmodeletxt);
        bikemodel = findViewById(R.id.bikemodeletxt);
        heavymodel = findViewById(R.id.heavymodeletxt);
        caryear = findViewById(R.id.caryearetxt);
        bikeyear = findViewById(R.id.bikeyearetxt);
        heavyyear = findViewById(R.id.heavyyearetxt);






        regb= findViewById(R.id.submit);
        resend = findViewById(R.id.otpresendbutton);
        conformotp = findViewById(R.id.otpconformbutton);
        setpass =findViewById(R.id.setpasswordbutton);
        Logb = findViewById(R.id.loginbutton);
        car = findViewById(R.id.carbutton);
        bike = findViewById(R.id.bikebutton);
        heavy = findViewById(R.id.heavybutton);




        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logbar.setVisibility(View.GONE);
                Handler log = new Handler();
                log.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        regbar.setVisibility(View.INVISIBLE);
                        logbar.setVisibility(View.VISIBLE);
                        register.setVisibility(View.GONE);
                        login.setVisibility(View.VISIBLE);
                    }
                },200);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regbar.setVisibility(View.GONE);
                Handler log = new Handler();
                log.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logbar.setVisibility(View.INVISIBLE);
                        regbar.setVisibility(View.VISIBLE);
                        login.setVisibility(View.GONE);
                        register.setVisibility(View.VISIBLE);
                    }
                },200);
            }
        });
        regb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              register1.setVisibility(View.GONE);
              otpbox.setVisibility(View.VISIBLE);
            }
        });
        conformotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register1.setVisibility(View.GONE);
                otpbox.setVisibility(View.GONE);
                passwordbox.setVisibility(View.VISIBLE);
            }
        });
        setpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Logb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Emaillogtxt = Emaillog.getText().toString().trim();
               Passwordlogtxt = Passwordlog.getText().toString().trim();
               if (Emaillogtxt.isEmpty() && Passwordlogtxt.isEmpty()){
                   passwordwarning.setText("Please Enter An Valid Password!");
                   emailwarning.setText("Please Enter An Valid Email Id!");
               }
               else if (Passwordlogtxt.isEmpty()){
                   passwordwarning.setText("Please Enter An Valid Password!");
               }
               else if (Emaillogtxt.isEmpty() ){
                   emailwarning.setText("Please Enter An Valid Email Id!");
               }
               else {
                   passwordwarning.setText("");
                   emailwarning.setText("");
                   mAuth.signInWithEmailAndPassword(Emaillogtxt,Passwordlogtxt).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                       @Override
                       public void onSuccess(AuthResult authResult) {
                        String Uid = authResult.getUser().getUid();
                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                            String ex = e.getMessage();

                            if (ex == "A network error(such as timeout,interrupted connection or unreachable host)has occurred"){
                                Toast.makeText(MainActivity.this,"Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                            }
                            else if (ex == "The email address is badly formatted."){
                                emailwarning.setText("Please Enter An Valid Email Id!");
                            }
                            else if (ex == "There is no user record corresponding to this identifier. The user may have been deleted."){
                                emailwarning.setText("Please Enter An Valid Email Id!");
                            }
                            else if (ex == "The password is invalid or the user does not have a password."){
                                passwordwarning.setText("Password Error!");
                            }
                       }
                   });
               }

            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bikebox.setVisibility(View.GONE);
                heavybox.setVisibility(View.GONE);
                car.setVisibility(View.GONE);
                carformbox.setVisibility(View.VISIBLE);
            }
        });
        carok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bikebox.setVisibility(View.VISIBLE);
                heavybox.setVisibility(View.VISIBLE);
                car.setVisibility(View.VISIBLE);
                carformbox.setVisibility(View.GONE);
            }
        });
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carbox.setVisibility(View.GONE);
                heavybox.setVisibility(View.GONE);
                bike.setVisibility(View.GONE);
                bikeformbox.setVisibility(View.VISIBLE);
            }
        });
        bikeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carbox.setVisibility(View.VISIBLE);
                heavybox.setVisibility(View.VISIBLE);
                bike.setVisibility(View.VISIBLE);
                bikeformbox.setVisibility(View.GONE);
            }
        });
        heavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bikebox.setVisibility(View.GONE);
                carbox.setVisibility(View.GONE);
                heavy.setVisibility(View.GONE);
                heavyformbox.setVisibility(View.VISIBLE);
            }
        });
        heavyok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bikebox.setVisibility(View.VISIBLE);
                carbox.setVisibility(View.VISIBLE);
                heavy.setVisibility(View.VISIBLE);
                heavyformbox.setVisibility(View.GONE);
            }
        });

    }
}
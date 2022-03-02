package com.example.Meetstranger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import com.hbb20.CountryCodePicker;
import com.example.Meetstranger.util.PersistentUser;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private String userId = "";
    private boolean isUserRegisteredBefore = false;

    private LinearLayout linearLayoutMain,linearLayoutWait;
    private EditText editTextUsername;
    private EditText editTextUserage;
    private CountryCodePicker ccp;
    private EditText editTextUsernumber;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private int userAge = 13;
    private String userName = "null";
    private String userGender = "unknown";
    private String userNumber = "null";
    private String userCountryDefault = "null";
    private String userCountrySelected = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userId = PersistentUser.getDeviceId(this.getApplicationContext());
        isUserRegisteredBefore = PersistentUser.isRegisteredBefore(this.getApplicationContext());

        linearLayoutMain = findViewById(R.id.linear_layout_main);
        linearLayoutWait = findViewById(R.id.linear_layout_wait);
        editTextUsername = findViewById(R.id.edit_text_username);
        editTextUserage = findViewById(R.id.edit_text_userage);
        ccp = findViewById(R.id.ccp);
        editTextUsernumber = findViewById(R.id.edit_text_usernumber);
        radioGroup = findViewById(R.id.radio_group);
        //

        internetConnectionChecking();

        findViewById(R.id.button_register).setOnClickListener(v->{
            register();
        });

    }

    private void register(){
        //
        userName = editTextUsername.getText().toString().trim();
        if(TextUtils.isEmpty(userName)){
            Toast.makeText(getApplicationContext(),"Enter your name to register",Toast.LENGTH_SHORT).show();
            return;
        }
        if(userName.length()<3){
            Toast.makeText(getApplicationContext(),"Enter your correct name to register",Toast.LENGTH_SHORT).show();
            return;
        }

        String age = editTextUserage.getText().toString().trim();
        if(TextUtils.isEmpty(age)){
            Toast.makeText(getApplicationContext(),"Enter your age to continue",Toast.LENGTH_SHORT).show();
            return;
        }
        userAge = Integer.parseInt(age);
        if(userAge<18){
            Toast.makeText(getApplicationContext(),"You must be atleast 18 years old to use this app",Toast.LENGTH_SHORT).show();
            return;
        }

        String tUserNumber = editTextUsernumber.getText().toString().trim();
        if(TextUtils.isEmpty(tUserNumber)){
            Toast.makeText(getApplicationContext(),"Enter your Phone Number to register",Toast.LENGTH_SHORT).show();
            return;
        }
        userNumber = ccp.getSelectedCountryCodeWithPlus()+tUserNumber;

        if(userGender.equals("Male")){
            maleUserRegistration();
        }else if(userGender.equals("Female")){
            femaleUserRegistration();
        }else if(userGender.equals("unknown")){
            Toast.makeText(getApplicationContext(),"Choose your gender to register",Toast.LENGTH_SHORT).show();
            return;
        }

        userCountryDefault = ccp.getDefaultCountryName();
        userCountrySelected = ccp.getSelectedCountryName();
        
        linearLayoutMain.setVisibility(View.GONE);
        linearLayoutWait.setVisibility(View.VISIBLE);

        PersistentUser.setRegister(this.getApplicationContext(),true);
        PersistentUser.setRegisterBefore(this.getApplicationContext(),true);

        PersistentUser.setUserAge(this.getApplicationContext(),String.valueOf(userAge));
        PersistentUser.setUserGender(this.getApplicationContext(),userGender.toLowerCase());
        PersistentUser.setUserName(this.getApplicationContext(),userName);
        PersistentUser.setUserNumber(this.getApplicationContext(),userNumber.toLowerCase());
        PersistentUser.setUserCountryDefault(this.getApplicationContext(),userCountryDefault.toLowerCase());
        PersistentUser.setUserCountrySelected(this.getApplicationContext(),userCountrySelected.toLowerCase());

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserDetails").child(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("user_name",userName);
        map.put("user_age",String.valueOf(userAge));
        map.put("user_gender",userGender.toLowerCase());
        map.put("user_number",userNumber.toLowerCase());
        map.put("user_country_default",userCountryDefault.toLowerCase());
        map.put("user_country_selected",userCountrySelected.toLowerCase());
        reference.updateChildren(map).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users").child(userId);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("id",userId);
        hashMap.put("username",userName);
        hashMap.put("imageURL","default");
        hashMap.put("status","offline");
        hashMap.put("search",userName.toLowerCase());
        ref.updateChildren(hashMap).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        //

    }

    private void maleUserRegistration(){

        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Users").child(userId);
        current_user_db.child("status").setValue("offline");
        current_user_db.child("history").child("-").setValue("true");
        Intent in = new Intent(RegisterActivity.this,MoreActivity.class);
        startActivity(in);
        finish();
    }

    private void femaleUserRegistration(){

        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("UserCallDatabase").child("Users").child(userId);
        current_user_db.child("status").setValue("offline");
        current_user_db.child("history").child("-").setValue("true");
        Intent in = new Intent(RegisterActivity.this,MoreActivity.class);
        startActivity(in);
        finish();

    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        userGender = radioButton.getText().toString();
    }

    private void userNotRegisteredBefore(){
        linearLayoutMain.setVisibility(View.VISIBLE);
        linearLayoutWait.setVisibility(View.GONE);
    }

    private void registerUser(){
        PersistentUser.setRegister(this.getApplicationContext(),true);
        String gender = PersistentUser.getUserGender(RegisterActivity.this);
        if(gender.equals("male")){
            startActivity(new Intent(RegisterActivity.this,MoreActivity.class));
        }else if(gender.equals("female")){
            startActivity(new Intent(RegisterActivity.this,MoreActivity.class));
        }
        finish();
    }

    private void userRegisteredBefore(){
        if(PersistentUser.isRegistered(this.getApplicationContext())){
            String gender = PersistentUser.getUserGender(this.getApplicationContext());
            if(gender.equals("male")){
                startActivity(new Intent(RegisterActivity.this,MoreActivity.class));
            }else if(gender.equals("female")){
                startActivity(new Intent(RegisterActivity.this,MoreActivity.class));
            }
            finish();
        }else{
            //Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_SHORT).show();
            registerUser();
        }
    }

    private void internetDone(){
        if(isUserRegisteredBefore){
            //Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_SHORT).show();
            userRegisteredBefore();
        }else{
            //Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_SHORT).show();
            userNotRegisteredBefore();
        }
    }

    private void internetConnectionChecking(){
        if(!isInternetAvailable()){
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.internet_connection), Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(RegisterActivity.this)
                    .setTitle("Connection Error")
                    .setMessage(getResources().getString(R.string.internet_connection))
                    .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(isInternetAvailable()){
                                internetDone();
                                dialog.cancel();
                            }else{
                                internetConnectionChecking();
                            }
                        }
                    })
                    .setCancelable(false)
                    .create().show();
        }else{
            internetDone();
        }
    }

    public boolean isInternetAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return (networkInfo!=null);
    }

}
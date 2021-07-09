package com.example.Meetstranger.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.example.Meetstranger.GlobalChat.Model.User;
import com.example.Meetstranger.R;
import com.example.Meetstranger.util.PersistentUser;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private String deviceId = "";

    private TextView tvUserName,tvUserAge,tvUserGender,tvUserPhone;
    private String userName,userAge,userGender,userPhone;

    private CircleImageView profileImage,profileImageEdit;
    StorageReference storageReference;
    private static final int IMAGE_REQUEST = 1;
    private Uri imageUri;
    private StorageTask uploadTask;
    private DatabaseReference reference;

    private int imageFlag = 0;
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity_profile);

        deviceId = PersistentUser.getDeviceId(this.getApplicationContext());

        profileImage = findViewById(R.id.profile_image);
        profileImageEdit = findViewById(R.id.profile_image_edit);
        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        reference = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users").child(deviceId);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if(user.getImageURL().equals("default")){
                    profileImage.setImageResource(R.mipmap.default_user);
                }else{
                    imageFlag = 1;
                    imageUrl = user.getImageURL();
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(profileImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        profileImageEdit.setOnClickListener(v->{
            openImage();
        });
        profileImage.setOnClickListener(v->{
            Intent intent = new Intent(ProfileActivity.this, ImageView.class);
            intent.putExtra("imageFlag",imageFlag);
            intent.putExtra("imageUrl",imageUrl);
            startActivity(intent);
        });

        deviceId = PersistentUser.getDeviceId(this.getApplicationContext());

        userName = userAge = userGender = userPhone = "";
        userName = PersistentUser.getUserName(this.getApplicationContext());
        userAge = PersistentUser.getUserAge(this.getApplicationContext());
        userGender = PersistentUser.getUserGender(this.getApplicationContext());
        userPhone = PersistentUser.getUserNumber(this.getApplicationContext());

        initializeViews();

        setText();

    }

    private void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null ){
            imageUri = data.getData();

            if(uploadTask != null && uploadTask.isInProgress()){
                Toast.makeText(getApplicationContext(),
                        "Upload in progress",
                        Toast.LENGTH_SHORT).show();
            }else{
                uploadImage();
            }
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    private void uploadImage(){
        final ProgressDialog pd = new ProgressDialog(ProfileActivity.this);
        pd.setMessage("Uploading");
        pd.show();

        if(imageUri!=null){
            final StorageReference fileReference = storageReference.child(System.currentTimeMillis()
                    +"."+getFileExtension(imageUri));

            uploadTask = fileReference.putFile(imageUri);
            uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>(){
                @Override
                public Task<Uri> then(Task<UploadTask.TaskSnapshot> task)throws Exception{
                    if(!task.isSuccessful()){
                        throw task.getException();
                    }
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful()){
                        Uri downloadUri = task.getResult();
                        String mUri = downloadUri.toString();

                        reference = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users").child(deviceId);
                        HashMap<String ,Object> map = new HashMap<>();
                        map.put("imageURL",mUri);
                        reference.updateChildren(map);

                        pd.dismiss();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "Failed!",
                                Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),
                            e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),
                    "No image selected",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeViews(){
        tvUserName = findViewById(R.id.tv_user_name);
        tvUserAge = findViewById(R.id.tv_user_age);
        tvUserGender = findViewById(R.id.tv_user_gender);
        tvUserPhone = findViewById(R.id.tv_user_phone);
    }

    private void setText(){
        userName = PersistentUser.getUserName(this.getApplicationContext());
        userAge = PersistentUser.getUserAge(this.getApplicationContext());
        userGender = PersistentUser.getUserGender(this.getApplicationContext());
        userPhone = PersistentUser.getUserNumber(this.getApplicationContext());

        TextView textView = findViewById(R.id.username);
        textView.setText(userName);

        tvUserName.setText(userName);
        tvUserAge.setText(userAge);
        tvUserGender.setText(userGender);
        tvUserPhone.setText(userPhone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }

    private void update(String name,String age,Dialog dialog){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("UserDetails").child(deviceId);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("user_age",age);
        hashMap.put("user_name",name);
        ref.updateChildren(hashMap).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Make sure you connected to interne and try again",Toast.LENGTH_SHORT).show();
                return;
            }
        });

        ref = FirebaseDatabase.getInstance().getReference().child("globalchat").child("Users").child(deviceId);
        hashMap.clear();
        hashMap.put("search",name.toLowerCase());
        hashMap.put("username",name);
        ref.updateChildren(hashMap).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Make sure you connected to internet and try again",Toast.LENGTH_SHORT).show();
                return;
            }
        });

        PersistentUser.setUserAge(this.getApplicationContext(),age);
        PersistentUser.setUserName(this.getApplicationContext(),name);
        setText();
        Toast.makeText(getApplicationContext(),"Profile Updated Successfully",Toast.LENGTH_SHORT).show();
        dialog.cancel();
    }

    private void editUserProfile(){
        final Dialog dialog = new Dialog(ProfileActivity.this);
        dialog.setContentView(R.layout.activity_register);
        dialog.setCanceledOnTouchOutside(false);
        LinearLayout llmain,llwait,llphone;
        llmain = dialog.findViewById(R.id.linear_layout_main);
        llmain.setVisibility(View.VISIBLE);
        llwait = dialog.findViewById(R.id.linear_layout_wait);
        llwait.setVisibility(View.GONE);
        llphone = dialog.findViewById(R.id.linear_layout_phone);
        llphone.setVisibility(View.GONE);

        EditText etname,etage;
        etname = dialog.findViewById(R.id.edit_text_username);
        etname.setHint("Change your name");
        etage = dialog.findViewById(R.id.edit_text_userage);
        etage.setHint("Change your age");

        dialog.findViewById(R.id.tv_choose_gender).setVisibility(View.GONE);
        dialog.findViewById(R.id.tv_registration).setVisibility(View.GONE);

        RadioGroup radioGroup = dialog.findViewById(R.id.radio_group);
        radioGroup.setVisibility(View.GONE);

        Button editProfile = dialog.findViewById(R.id.button_register);
        editProfile.setText("Edit Profile");

        editProfile.setOnClickListener(v->{
            String name = etname.getText().toString().trim();
            String age = etage.getText().toString().trim();
            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(age)){
                Toast.makeText(getApplicationContext(),"Enter all the fields",Toast.LENGTH_SHORT).show();
            }else{
                int ageInt = Integer.parseInt(age);
                if(ageInt<18){
                    Toast.makeText(getApplicationContext(),"Age must be atleast 18 to use this app",Toast.LENGTH_SHORT).show();
                }else{
                    update(name,age,dialog);
                }
            }
        });

        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_edit){
            editUserProfile();
            return true;
        }
        return false;
    }

}
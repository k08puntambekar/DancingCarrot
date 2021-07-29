package ReKritiks.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Initial_Register extends AppCompatActivity {

   private EditText name_text;
   private EditText username_text;
   private EditText email_text;
   private EditText mobile_text;
   private EditText password_text;
   private FirebaseAuth firebaseAuth;
   private FirebaseDatabase firebaseDatabase;
   private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        name_text = findViewById(R.id.name_text);
        username_text = findViewById(R.id.username_text);
        email_text = findViewById(R.id.email_text);
        mobile_text = findViewById(R.id.mobile_text);
        password_text = findViewById(R.id.password_text);
    }

    public void back(View view) {
        Intent back_arrow = new Intent(Initial_Register.this, Initial_MainActivity.class);
        startActivity(back_arrow);
    }

    public void checkUser(View view) {

        String getUsername = username_text.getText().toString();
        String getName = name_text.getText().toString();
        String getMobile = mobile_text.getText().toString();
        String getEmail = email_text.getText().toString();
        String getPassword = password_text.getText().toString();

        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("username", getUsername);
        userMap.put("name", getName);
        userMap.put("mobile", getMobile);
        userMap.put("email", getEmail);
        userMap.put("password", getPassword);

        firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        databaseReference.child("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(userMap)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        //Toast.makeText(Initial_Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(Initial_Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                        Intent go_to_login = new Intent(Initial_Register.this, Initial_MainActivity.class);
                                        startActivity(go_to_login);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @NotNull Exception e) {
                                Toast.makeText(Initial_Register.this, "Not registered", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Initial_Register.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
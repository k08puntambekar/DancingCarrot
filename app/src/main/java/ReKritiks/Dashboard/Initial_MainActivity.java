package ReKritiks.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Initial_MainActivity extends AppCompatActivity
{

    private EditText email_text;
    private EditText password_text;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_activity_main);

        email_text = findViewById(R.id.email_text);
        password_text = findViewById(R.id.password_text);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        String getEmail = email_text.getText().toString();
        String getPassword = password_text.getText().toString();


        firebaseAuth.signInWithEmailAndPassword(getEmail, getPassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Initial_MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                        Intent dashboardIntent = new Intent(Initial_MainActivity.this, Dashboard_Activity_Main.class);
                        startActivity(dashboardIntent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Initial_MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void register(View view) {
        Intent registerIntent = new Intent(this, Initial_Register.class);
        startActivity(registerIntent);
    }

}
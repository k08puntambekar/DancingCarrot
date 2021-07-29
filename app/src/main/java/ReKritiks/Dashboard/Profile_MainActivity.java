package ReKritiks.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import ReKritiks.Dashboard.utils.Constants;

public class Profile_MainActivity extends AppCompatActivity {

    TextView nameText ;
    EditText usrNameText,phoneText,emailIDText;
    Button updateBtn;
    String profEmail;
    DatabaseReference rootRef ;
    DatabaseReference userRef;
    FirebaseAuth mAuth;
    private String oldName,oldEmail,oldPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity_main);

        nameText = findViewById(R.id.name_text);
        usrNameText = findViewById(R.id.UsrName_Text);
        phoneText = findViewById(R.id.phone_text);
        emailIDText = findViewById(R.id.emailId_Text);
        updateBtn = findViewById(R.id.updateBtn);
        Intent profIntent = getIntent();
        profEmail = profIntent.getStringExtra("ProfEmail");
        Log.i("Profile Email",profEmail);


        mAuth = FirebaseAuth.getInstance();
         rootRef = FirebaseDatabase.getInstance().getReference();
         userRef = rootRef.child(Constants.USER);

        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                 for(DataSnapshot snap: snapshot.getChildren()){
                     userRef.child(snap.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                             UserModel user = snapshot.getValue(UserModel.class);
                             nameText.setText(user.name);
                             emailIDText.setText(user.email);
                             phoneText.setText(user.mobile);
                             usrNameText.setText(user.username);
                             oldName = nameText.getText().toString();
                             oldEmail = emailIDText.getText().toString();
                             oldPhone = phoneText.getText().toString();
                         }

                         @Override
                         public void onCancelled(@NonNull @NotNull DatabaseError error) {

                         }
                     });
                 }

             }

             @Override
             public void onCancelled(@NonNull @NotNull DatabaseError error) {

             }
         });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNameChanged()){
                    Toast.makeText(Profile_MainActivity.this, "Name Updated!!", Toast.LENGTH_SHORT).show();

                }
                if(isEmailChanged()){
                    Toast.makeText(Profile_MainActivity.this, "Email Updated!!", Toast.LENGTH_SHORT).show();

                }
                if(isPhoneChanged()){
                    Toast.makeText(Profile_MainActivity.this, "Phone Updated!!", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private boolean isPhoneChanged() {
        if (!oldPhone.equals(phoneText.getText().toString())) {
            userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("mobile").setValue(phoneText.getText().toString());
            oldPhone = phoneText.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!oldEmail.equals(emailIDText.getText().toString())) {

            userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("email").setValue(emailIDText.getText().toString());
            oldEmail = emailIDText.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isNameChanged() {
        if (!oldName.equals(usrNameText.getText().toString())) {
            Log.i("Old username : ", oldName);
            Log.i("Username : ", usrNameText.getText().toString());
            userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("username").setValue(usrNameText.getText().toString());
            oldName = usrNameText.getText().toString();
            return true;
        } else {
            return false;
        }

    }
}
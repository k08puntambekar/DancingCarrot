package ReKritiks.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

    TextView nameText ,usrNameText,phoneText,emailIDText;
    String profEmail;
    DatabaseReference rootRef ;
    DatabaseReference userRef;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity_main);

        nameText = findViewById(R.id.name_text);
        usrNameText = findViewById(R.id.UsrName_Text);
        phoneText = findViewById(R.id.phone_text);
        emailIDText = findViewById(R.id.emailId_Text);
        Intent profIntent = getIntent();
        profEmail = profIntent.getStringExtra("ProfEmail");
        Log.i("Profile Email",profEmail);


        mAuth = FirebaseAuth.getInstance();
         rootRef = FirebaseDatabase.getInstance().getReference();
         userRef = rootRef.child(Constants.USER);

        userRef.orderByChild("email").equalTo(profEmail).addListenerForSingleValueEvent(new ValueEventListener() {
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


    }
}
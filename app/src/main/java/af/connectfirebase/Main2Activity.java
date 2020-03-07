package af.connectfirebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppAppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    EditText firstname, mobile, email;
    Button button;
    DatabaseReference reff;
    Member2 obj1;
    long maxid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(Main2Activity.this,"Firebase connection success", Toast.LENGTH_LONG).show();
        firstname = (EditText)findViewById((R.id.firstname));
        mobile = (EditText)findViewById((R.id.mobile));
        email = (EditText)findViewById((R.id.email));
        button = (Button) findViewById((R.id.button4));
        obj1 = new Member2();
        reff = FirebaseDatabase.getInstance().getInstance().getReference().child("member2");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mobilenumber = Integer.parseInt(mobile.getText().toString().trim());
                obj1.setFname(firstname.getText().toString().trim());
                obj1.setEmailaddress(email.getText().toString().trim());
                obj1.setMobilenumber(mobilenumber);
                reff.child(String.valueOf(maxid+1)).setValue(obj1);
                Toast.makeText(Main2Activity.this,"data inserted successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
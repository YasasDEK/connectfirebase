package af.connectfirebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppAppCompatActivity;

public class MainActivity extends AppCompatActivity {
EditText firstname, mobile, email;
Button button;
DatabaseReference reff;
Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Firebase connection success", Toast.LENGTH_LONG).show();
        firstname = (EditText)findViewById((R.id.firstname));
        mobile = (EditText)findViewById((R.id.mobile));
        email = (EditText)findViewById((R.id.email));
        button = (Button) findViewById((R.id.button));
        member = new Member();
        reff = FirebaseDatabase.getInstance().getInstance().getReference().child("member");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mobilenumber = Integer.parseInt(mobile.getText().toString().trim());
                member.setFname(firstname.getText().toString().trim());
                member.setEmailaddress(email.getText().toString().trim());
                member.setMobilenumber(mobilenumber);
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this,"data inserted successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
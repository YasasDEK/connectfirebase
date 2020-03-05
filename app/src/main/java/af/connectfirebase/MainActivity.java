package af.connectfirebase;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Firebase connection success", Toast.LENGTH_LONG).show();
        firstname = (EditText)findViewById((R.id.firstname));
        mobile = (EditText)findViewById((R.id.mobile));
        email = (EditText)findViewById((R.id.email));
        button = (Button) findViewById((R.id.button));
        reff = FirebaseDatabase.getInstance().getInstance().getReference().child("member");
    }
}
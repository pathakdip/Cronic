package pathak.com.cronic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pathak.com.cronic.MainActivity.isValidEmail;

/**
 * Created by Dip on 2/20/2017.
 */
public class SignUpActivity extends AppCompatActivity{
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private TextView tvlogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText nameET = (EditText) findViewById(R.id.sname);
        final EditText emailET = (EditText) findViewById(R.id.semail);
        final EditText passwordET = (EditText) findViewById(R.id.spwd);
        final EditText cpwdET = (EditText) findViewById(R.id.scpwd);
        Button btnsignup = (Button) findViewById(R.id.sbtn);
        tvlogin=(TextView)findViewById(R.id.slogin);
        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestr=nameET.getText().toString();
                String emailstr = emailET.getText().toString();
                String passwordstr = passwordET.getText().toString();
                String cpstr = cpwdET.getText().toString();
                if (namestr.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                }else if (emailstr.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(emailstr)) {
                    Toast.makeText(SignUpActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                }else if (passwordstr.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else if (cpstr.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                }else if (!cpstr.equals(passwordstr)) {
                    Toast.makeText(SignUpActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Sign-up Successfull!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static boolean isValidEmail(CharSequence target) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(target);
        return matcher.matches();
    }


}

package pathak.com.cronic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dip on 2/26/2017.
 */

public class NewPassword extends AppCompatActivity {
   private Button btnsubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpwd);
        btnsubmit=(Button)findViewById(R.id.new_pwd_submit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NewPassword.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}

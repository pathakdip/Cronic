package pathak.com.cronic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dip on 2/21/2017.
 */
public class ForgotPassActivity extends AppCompatActivity{
   private Button btnnext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_forgot_pwd);
        btnnext=(Button)findViewById(R.id.fpwd_btnnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgotPassActivity.this,NewPassword.class);
                startActivity(intent);
            }
        });
    }
}

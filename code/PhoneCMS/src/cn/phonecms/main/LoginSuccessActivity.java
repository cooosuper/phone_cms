package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginSuccessActivity extends BaseActivity {
  
  private static final String TAG = null;
  private Button appRegisterBtnCompany, appLogoffBtn;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
      setContentView(R.layout.activity_login_successful);
      
      appRegisterBtnCompany = (Button)findViewById(R.id.register_company);
      appLogoffBtn = (Button)findViewById(R.id.log_off);
      
      appRegisterBtnCompany.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          doTaskRegisterCompany();
        }
      });
      
      appLogoffBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(LoginSuccessActivity.this, MainActivity.class);
          startActivity(myIntent);
          LoginSuccessActivity.this.finish();
        }
      });
      
  }
   
  private void doTaskRegisterCompany() {
    Intent intent = new Intent();
    intent.setClass(LoginSuccessActivity.this, RegisterCompanyActivity.class);
    LoginSuccessActivity.this.startActivity(intent);
  }
  
}

package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterAccountSuccess extends Activity {

  private Button app_btn_goLogin;
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_register_successful);
    
    app_btn_goLogin = (Button)findViewById(R.id.app_login_btn_navigate);
    
    app_btn_goLogin.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        goLoginPage();
      }
    });
    
  }
  
  private void goLoginPage() {
    Intent intent = new Intent();
    intent.setClass(RegisterAccountSuccess.this, LoginActivity.class);
    RegisterAccountSuccess.this.startActivity(intent);
  }
}

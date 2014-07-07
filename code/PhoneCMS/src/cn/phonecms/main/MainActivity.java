package cn.phonecms.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.MenuItem;  

/**
 * 程序主入口
 * 
 */
public class MainActivity extends BaseActivity {
  
  private Button appRegisterBtnSubmit;
  private Button appLoginBtnLogin;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
      setContentView(R.layout.activity_main);

    appRegisterBtnSubmit = (Button)findViewById(R.id.app_register_btn_submit);
    appLoginBtnLogin     = (Button)findViewById(R.id.app_login_btn_navigate);
    
    appRegisterBtnSubmit.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        doTaskRegister();
      }
    });
    
    appLoginBtnLogin.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        goLoginPage();
      }
    });

  }

  private void doTaskRegister() {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, RegisterAccountActivity.class);
    MainActivity.this.startActivity(intent);
  }

  private void goLoginPage() {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, LoginActivity.class);
    MainActivity.this.startActivity(intent);
  }
}

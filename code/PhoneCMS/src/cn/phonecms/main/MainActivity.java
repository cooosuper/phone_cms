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
    appLoginBtnLogin = (Button)findViewById(R.id.app_login_btn_navigate);
    
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
    intent.setClass(MainActivity.this, RegisterAccount.class);
    MainActivity.this.startActivity(intent);
  }

  private void goLoginPage() {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, LoginActivity.class);
    MainActivity.this.startActivity(intent);
  }
  
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem item) 
  {

    super.onOptionsItemSelected(item);

    switch (item.getItemId()) 
    {

      case R.id.company:                             
//        forward(Login.class);
        break;
  
      case R.id.product:                           
//        forward(Login.class);
        break;
  
      case R.id.activity:                          
//        forward(Login.class);
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ManageActivity.class);
        MainActivity.this.startActivity(intent);
        break;
      
      case R.id.more:
//        forward(Login.class);
        break;
      
      case R.id.comment:
//        forward(Login.class);
        break;
       
      case R.id.recruit:
//        forward(Login.class);
        break;
        
      case R.id.sub_company:
//        forward(Login.class); 
        break;

    }
    
    return super.onOptionsItemSelected(item);

    }

}

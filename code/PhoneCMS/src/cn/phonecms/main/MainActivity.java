package cn.phonecms.main;

import java.util.HashMap;

//import com.app.demos.R;
//import com.app.demos.base.C;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.Menu;  
import android.view.MenuItem;  

/**
 * 程序主入口
 * 
 */
public class MainActivity extends Activity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intent = getIntent();
    String value = intent.getStringExtra("testIntent");

    // 这个地方的比较永远进不去，字符串比较不能用==，要用equals
    if (value != null && value.equals("register_successed")) {
      setContentView(R.layout.activity_register_successful);
    }else if(value != null && value.equals("login_successed")){
      setContentView(R.layout.activity_login_successful);
    } else{
      setContentView(R.layout.activity_main);
    }

    OnClickListener mOnClickListener = new OnClickListener() {
      @Override
      public void onClick(View v) {
        switch (v.getId()) {
        case R.id.app_register_btn_submit:
          doTaskRegister();
          break;
        case R.id.login:
          goLoginPage();
        }
      }
    };
//    Button appRegisterBtnSubmit = (Button) findViewById(R.id.app_register_btn_submit);
//    Button appLoginBtnLogin = (Button)findViewById(R.id.login);
    // 这里，你通过findViewById获取一个Button控件，但是你没有加载布局，所以获取控件为空
    findViewById(R.id.app_register_btn_submit).setOnClickListener(
        mOnClickListener);
    findViewById(R.id.login).setOnClickListener(mOnClickListener);

  }

  private void doTaskRegister() {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, Register.class);
    MainActivity.this.startActivity(intent);
  }

  private void goLoginPage() {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, Login.class);
    MainActivity.this.startActivity(intent);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);

    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem item) 
  {

    super.onOptionsItemSelected(item);

    switch (item.getItemId()) 
    {

      case R.id.media_play:                        
  
      break;
  
      case R.id.media_pause:                        
  
      break;
  
      case R.id.file_open:                        
  
      break;
  
      case R.id.file_save:
  
      break;

    }

    return true;

    }

}

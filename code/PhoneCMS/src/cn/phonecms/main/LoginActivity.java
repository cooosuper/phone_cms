package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;



public class LoginActivity extends Activity 
{
  private EditText loginUsername;
  private EditText loginPasswd;
  private Button   loginBtn;
  
  protected void onCreate(Bundle savedInstanceState) 
  {
    
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
   
    loginUsername = (EditText)findViewById(R.id.app_login_edit_name);
    loginPasswd   = (EditText)findViewById(R.id.app_login_edit_pass);
    loginBtn    = (Button)findViewById(R.id.app_login_btn_submit);
    
    loginBtn.setOnClickListener(new OnClickListener(){
      public void onClick(View v) { 
        doTaskLogin();
      }
    });
    
  }
  
  
  private void doTaskLogin()
  {
    if(!checkEdit()){
      return;
    } 
    Intent intent = new Intent();
    intent.putExtra("testIntent", "login_successed");
    intent.setClass(LoginActivity.this, CompanyLoginSuccessActivity.class);
    LoginActivity.this.startActivity(intent);
  }
  
  private boolean checkEdit(){
    if(loginUsername.getText().toString().trim().equals("")){
      Toast.makeText(LoginActivity.this, "用户名不能为空 ", Toast.LENGTH_SHORT).show();
    }else if(loginPasswd.getText().toString().trim().equals("")){
      Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }else if(!loginUsername.getText().toString().trim().equals("123")){
      Toast.makeText(LoginActivity.this, "用户名不正确", Toast.LENGTH_SHORT).show();
    }else if(!loginPasswd.getText().toString().trim().equals("123")){
      Toast.makeText(LoginActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
    }    
    else{
      return true;
    }
    return false;
  }

  
}

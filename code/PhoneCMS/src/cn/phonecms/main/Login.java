package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;



public class Login extends Activity 
{
  private EditText login_username;
  private EditText login_passwd;
  
  protected void onCreate(Bundle savedInstanceState) 
  {
    
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
   
    login_username = (EditText)findViewById(R.id.editText1);
    login_passwd   = (EditText)findViewById(R.id.editText2);
    
    OnClickListener mOnClickListener = new OnClickListener() {
      @Override
      public void onClick(View v) {
          switch (v.getId()) {
              case R.id.app_register_btn_submit : 
                  doTaskRegister();
                  break;
              case R.id.app_login_btn_submit :
                  doTaskLogin();
          }
      }
    };
    
    findViewById(R.id.app_register_btn_submit).setOnClickListener(mOnClickListener);
    findViewById(R.id.app_login_btn_submit).setOnClickListener(mOnClickListener);
    
  }
  
  private void doTaskRegister() 
  {
    Intent intent = new Intent();
    intent.setClass(Login.this, Register.class);
    Login.this.startActivity(intent);
  }
  
  private void doTaskLogin()
  {
    if(!checkEdit()){
      return;
    }
    Intent intent = new Intent();
    intent.setClass(Login.this, MainActivity.class);
    Login.this.startActivity(intent);
  }
  
  private boolean checkEdit(){
    if(login_username.getText().toString().trim().equals("")){
      Toast.makeText(Login.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
    }else if(login_passwd.getText().toString().trim().equals("")){
      Toast.makeText(Login.this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }else if(!login_username.getText().toString().trim().equals("123")){
      Toast.makeText(Login.this, "用户名不正确，请重新输入", Toast.LENGTH_SHORT).show();
    }else if(!login_passwd.getText().toString().trim().equals("123")){
      Toast.makeText(Login.this, "密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
    }    
    else{
      return true;
    }
    return false;
  }

  
}

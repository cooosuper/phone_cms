package cn.phonecms.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;  

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterAccountActivity extends Activity 
{
  private EditText registerUsername; 
  private EditText registerPasswd;
  private EditText reregisterPasswd;
  private EditText registerPhone;
  private EditText registerMail;
  private EditText registerAddress;
  private Button   registerSubmit;
  private Button   backBtn;

  
  protected void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    
    registerUsername = (EditText)findViewById(R.id.app_login_edit_username);
    registerPasswd   = (EditText)findViewById(R.id.app_login_edit_pass);
    reregisterPasswd = (EditText)findViewById(R.id.re_app_login_edit_pass);
    registerPhone    = (EditText)findViewById(R.id.app_edit_phone);
    registerMail     = (EditText)findViewById(R.id.app_edit_email);
    registerAddress  = (EditText)findViewById(R.id.app_edit_address);
    registerSubmit   = (Button)findViewById(R.id.app_btn_register_submit);
    backBtn          = (Button)findViewById(R.id.backBtn);
    registerUsername.setOnFocusChangeListener(new OnFocusChangeListener()
    {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
        if(!hasFocus){
          if(registerUsername.getText().toString().trim().length()<4){
            Toast.makeText(RegisterAccountActivity.this, "用户名长度不能小于四个字符", Toast.LENGTH_SHORT).show();
          }
        }
      }
      
    });
    
    registerPasswd.setOnFocusChangeListener(new OnFocusChangeListener()
    {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
        if(!hasFocus){
          if(registerPasswd.getText().toString().trim().length()<6){
            Toast.makeText(RegisterAccountActivity.this, "密码长度不能小于6个字符", Toast.LENGTH_SHORT).show();
          }
        }
      }
      
    });

    reregisterPasswd.setOnFocusChangeListener(new OnFocusChangeListener()
    {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
        if(!hasFocus){
          if(!reregisterPasswd.getText().toString().trim().equals(registerPasswd.getText().toString().trim())){
            Toast.makeText(RegisterAccountActivity.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show(); 
          }
        }
      }
      
    });
    
    backBtn.setOnClickListener(new OnClickListener(){
      

      @Override
      public void onClick(View arg0) {
        // TODO Auto-generated method stub
        finish();
      }
    });

    registerSubmit.setOnClickListener(new OnClickListener(){

      @Override
      public void onClick(View v) {
        
        if(!checkEdit()){
          return;
        }
        // TODO Auto-generated method stub
        String httpUrl="http://***:8080/***/register.php";
        HttpPost httpRequest=new HttpPost(httpUrl);
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username",registerUsername.getText().toString().trim()));
        params.add(new BasicNameValuePair("password",registerPasswd.getText().toString().trim()));
        params.add(new BasicNameValuePair("phone",registerPhone.getText().toString().trim()));
        params.add(new BasicNameValuePair("mail", registerMail.getText().toString().trim()));
        params.add(new BasicNameValuePair("address", registerAddress.getText().toString().trim()));
        HttpEntity httpentity = null;
        try {
          httpentity = new UrlEncodedFormEntity(params,"utf8");
        } catch (UnsupportedEncodingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        httpRequest.setEntity(httpentity);
        HttpClient httpclient=new DefaultHttpClient();
        HttpResponse httpResponse = null;
        try {
          httpResponse = httpclient.execute(httpRequest);
        } catch (ClientProtocolException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        if(httpResponse.getStatusLine().getStatusCode()==200)
        {
          String strResult = null;
          try {
            strResult = EntityUtils.toString(httpResponse.getEntity());
          } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          Toast.makeText(RegisterAccountActivity.this, strResult, Toast.LENGTH_SHORT).show();
          
          Intent intent = new Intent();
          intent.putExtra("testIntent", "register_successed");
          intent.setClass(RegisterAccountActivity.this, RegisterAccountSuccessActivity.class);
          RegisterAccountActivity.this.startActivity(intent);
          
          
          
        }
        else
        {
          Toast.makeText(RegisterAccountActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
        }
        
      }
      
    });

    
  }
  
  private boolean checkEdit(){
    if(registerUsername.getText().toString().trim().equals("")){
      Toast.makeText(RegisterAccountActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
    }else if(registerPasswd.getText().toString().trim().equals("")){
      Toast.makeText(RegisterAccountActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }else if(!registerPasswd.getText().toString().trim().equals(reregisterPasswd.getText().toString().trim())){
      Toast.makeText(RegisterAccountActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
    }else{
      return true;
    }
    return false;
  }

}

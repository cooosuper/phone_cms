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
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Activity 
{
  private EditText register_username; 
  private EditText register_passwd;
  private EditText reregister_passwd;
  private EditText register_phone;
  private EditText register_mail;
  private EditText register_address;
  private Button   register_submit;

  
  protected void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    
    register_username = (EditText)findViewById(R.id.editText1);
    register_passwd   = (EditText)findViewById(R.id.editText2);
    reregister_passwd = (EditText)findViewById(R.id.editText2_1);
    register_phone    = (EditText)findViewById(R.id.editText3);
    register_mail     = (EditText)findViewById(R.id.editText4);
    register_address  = (EditText)findViewById(R.id.editText5);
    register_submit   = (Button)findViewById(R.id.button2);
    register_username.setOnFocusChangeListener(new OnFocusChangeListener()
    {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
        if(!hasFocus){
          if(register_username.getText().toString().trim().length()<4){
            Toast.makeText(Register.this, "用户名不能小于4个字符", Toast.LENGTH_SHORT).show();
          }
        }
      }
      
    });
    
    register_passwd.setOnFocusChangeListener(new OnFocusChangeListener()
    {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
        if(!hasFocus){
          if(register_passwd.getText().toString().trim().length()<6){
            Toast.makeText(Register.this, "密码不能小于8个字符", Toast.LENGTH_SHORT).show();
          }
        }
      }
      
    });

    reregister_passwd.setOnFocusChangeListener(new OnFocusChangeListener()
    {

      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
        if(!hasFocus){
          if(!reregister_passwd.getText().toString().trim().equals(register_passwd.getText().toString().trim())){
            Toast.makeText(Register.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show(); 
          }
        }
      }
      
    });

    register_submit.setOnClickListener(new OnClickListener(){

      @Override
      public void onClick(View v) {
        
        if(!checkEdit()){
          return;
        }
        // TODO Auto-generated method stub
        String httpUrl="http://***:8080/***/register.php";
        HttpPost httpRequest=new HttpPost(httpUrl);
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username",register_username.getText().toString().trim()));
        params.add(new BasicNameValuePair("password",register_passwd.getText().toString().trim()));
        params.add(new BasicNameValuePair("phone",register_phone.getText().toString().trim()));
        params.add(new BasicNameValuePair("mail", register_mail.getText().toString().trim()));
        params.add(new BasicNameValuePair("address", register_address.getText().toString().trim()));
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
          Toast.makeText(Register.this, strResult, Toast.LENGTH_SHORT).show();
          
          Intent intent = new Intent();
          intent.setClass(Register.this, MainActivity.class);
          Register.this.startActivity(intent);
          
          
          
        }
        else
        {
          Toast.makeText(Register.this, "请求错误", Toast.LENGTH_SHORT).show();
        }
        
      }
      
    });

    
  }
  
  private boolean checkEdit(){
    if(register_username.getText().toString().trim().equals("")){
      Toast.makeText(Register.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
    }else if(register_passwd.getText().toString().trim().equals("")){
      Toast.makeText(Register.this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }else if(!register_passwd.getText().toString().trim().equals(reregister_passwd.getText().toString().trim())){
      Toast.makeText(Register.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
    }else{
      return true;
    }
    return false;
  }

}

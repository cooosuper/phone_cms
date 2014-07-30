package cn.phonecms.main;



import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterAccountActivity extends Activity 
{
  private EditText      registerUsername,registerPasswd,reregisterPasswd,registerPhone,registerMail,registerAddress;
  private Button        registerSubmit,backBtn;
  private RequestQueue  mQueue;

  
  protected void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    
    mQueue           = Volley.newRequestQueue(this); 
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
      public void onClick(View v) 
      {
        
        if(!checkEdit()){
          return;
        }
        
        StringRequest stringRequest = new StringRequest(Method.POST,"http://www.***.com",  
            new Response.Listener<String>() {  
                @Override  
                public void onResponse(String response) {  
                    Log.d("TAG", response); 
                    Intent intent = new Intent();
                    intent.putExtra("testIntent", "register_successed");
                    intent.setClass(RegisterAccountActivity.this, RegisterAccountSuccessActivity.class);
                    RegisterAccountActivity.this.startActivity(intent);
                }  
            }, new Response.ErrorListener() {  
                @Override  
                public void onErrorResponse(VolleyError error) {  
                    Log.e("TAG", error.getMessage(), error); 
                    Toast.makeText(RegisterAccountActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                }  
            }){
                protected Map<String,String> getParams()
                {
                  Map<String,String> params = new HashMap<String, String>();       
                  params.put("username", registerUsername.getText().toString().trim());  
                  params.put("password", registerPasswd.getText().toString().trim());
                  params.put("phone", registerPhone.getText().toString().trim());
                  params.put("mail", registerMail.getText().toString().trim());
                  params.put("address", registerAddress.getText().toString().trim());
                  return params;
                }
                
                public Map<String, String> getHeaders() throws AuthFailureError 
                {
                  Map<String,String> params = new HashMap<String, String>();
                  params.put("Content-Type","application/x-www-form-urlencoded");
                  return params;
                
                }
            };

            mQueue.add(stringRequest);
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

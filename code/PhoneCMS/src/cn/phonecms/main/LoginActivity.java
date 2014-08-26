package cn.phonecms.main;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
//  private RequestQueue mQueue;
  protected void onCreate(Bundle savedInstanceState) 
  {
    
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);  
    loginUsername = (EditText)findViewById(R.id.app_login_edit_name);
    loginPasswd   = (EditText)findViewById(R.id.app_login_edit_pass);
    loginBtn    = (Button)findViewById(R.id.app_login_btn_submit);
//    mQueue = Volley.newRequestQueue(this);  
  
    loginBtn.setOnClickListener(new OnClickListener(){
      public void onClick(View v) { 
        doTaskLogin();
      }
    });
    
  }
   
  private void doTaskLogin()
  {
//    if(!checkEdit()){
//      return;
//    } 
//    
//    StringRequest stringRequest = new StringRequest(Method.POST,"http://www.***.com",  
//        new Response.Listener<String>() {  
//            @Override  
//            public void onResponse(String response) {  
//                Log.d("TAG", response); 
//                Intent intent = new Intent();
//                intent.putExtra("testIntent", "login_successed");
//                intent.setClass(LoginActivity.this, CompanyLoginSuccessActivity.class);
//                LoginActivity.this.startActivity(intent);
//            }  
//        }, new Response.ErrorListener() {  
//            @Override  
//            public void onErrorResponse(VolleyError error) {  
//                Log.e("TAG", error.getMessage(), error); 
//                Toast.makeText(LoginActivity.this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
//            }  
//        }){
//            protected Map<String,String> getParams()
//            {
//              Map<String,String> params = new HashMap<String, String>();       
//              params.put("user",loginUsername.getText().toString().trim());  
//              params.put("pass",loginPasswd.getText().toString().trim());
//              return params;
//            }
//            
//            public Map<String, String> getHeaders() throws AuthFailureError 
//            {
//              Map<String,String> params = new HashMap<String, String>();
//              params.put("Content-Type","application/x-www-form-urlencoded");
//              return params;
//            
//            }
//        };
//
//        mQueue.add(stringRequest);
    Intent intent = new Intent();
    intent.putExtra("testIntent", "login_successed");
    intent.setClass(LoginActivity.this, CompanyLoginSuccessActivity.class);
    LoginActivity.this.startActivity(intent);
  }
  
//  private boolean checkEdit(){
//    if(loginUsername.getText().toString().trim().equals("")){
//      Toast.makeText(LoginActivity.this, "用户名不能为空 ", Toast.LENGTH_SHORT).show();
//    }else if(loginPasswd.getText().toString().trim().equals("")){
//      Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
//    }   
//    else{
//      return true;
//    }
//    return false;
//  }
}

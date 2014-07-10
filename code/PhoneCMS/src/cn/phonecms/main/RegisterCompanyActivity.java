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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterCompanyActivity extends Activity {
  
  private Button backBtn;
  private Button registerBtnComapny;
  private EditText companyName;
  private EditText email;
  
  protected void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register_company);
    
    backBtn = (Button)findViewById(R.id.backBtn);
    registerBtnComapny = (Button)findViewById(R.id.registerBtnCompany);
    companyName = (EditText)findViewById(R.id.edit_CompanyName);
    email = (EditText)findViewById(R.id.editEmail);
    
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        RegisterCompanyActivity.this.finish();
      }
    });
    
    registerBtnComapny.setOnClickListener(new OnClickListener(){

      @Override
      public void onClick(View v) {
        
        // TODO Auto-generated method stub
        String httpUrl="http://***:8080/***/register.php";
        HttpPost httpRequest=new HttpPost(httpUrl);
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("companyname",companyName.getText().toString().trim()));
        params.add(new BasicNameValuePair("address", email.getText().toString().trim()));
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
          Toast.makeText(RegisterCompanyActivity.this, strResult, Toast.LENGTH_SHORT).show();
          
          Intent intent = new Intent();
          intent.putExtra("testIntent", "register_successed");
          intent.setClass(RegisterCompanyActivity.this, RegisterCompanySuccessActivity.class);
          RegisterCompanyActivity.this.startActivity(intent);               
        }
        else
        {
          Toast.makeText(RegisterCompanyActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
        }
        
      }
      
    });
    
  }
}

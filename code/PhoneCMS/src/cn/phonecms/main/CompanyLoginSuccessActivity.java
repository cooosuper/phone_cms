package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CompanyLoginSuccessActivity extends BaseActivity {
  
  private Button appLogoffBtn;
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
      setContentView(R.layout.activity_companylogin_successful);
      
      appLogoffBtn = (Button)findViewById(R.id.log_off);
      

      
      appLogoffBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
            finish();
        }
      });
      
  }
   
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}

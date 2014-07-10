package cn.phonecms.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.KeyEvent;

public class ManageActivity extends BaseActivity{

  private Button backBtn;
  private Button addActivityBtn;
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_manage_activity);
    
    backBtn = (Button)findViewById(R.id.main_top_back);
    addActivityBtn = (Button)findViewById(R.id.main_top_plus);

    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageActivity.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageActivity.this.finish();
      }
    });
    

    
    addActivityBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
       // do add related coding
      }
    });
        
  }
}

package cn.phonecms.main;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageActivity extends BaseActivity{

  private Button backBtn;
  private Button addActivityBtn;
  private Button enterActivityBtn;
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_manage_activity);
    
    backBtn = (Button)findViewById(R.id.back_btn);
    addActivityBtn = (Button)findViewById(R.id.add_btn_activity);
    enterActivityBtn = (Button)findViewById(R.id.app_btn_enteractivity);
    
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        finish();
      }
    });
    
    addActivityBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
       // do add related coding
      }
    });
    
    enterActivityBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        // do enter activity related coding
       }
     });
    
  }
}

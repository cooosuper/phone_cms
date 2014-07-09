package cn.phonecms.main;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
        finish();
      }
    });
    
    addActivityBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
       // do add related coding
      }
    });
        
  }
}

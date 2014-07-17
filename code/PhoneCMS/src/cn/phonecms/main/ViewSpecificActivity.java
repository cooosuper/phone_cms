package cn.phonecms.main;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;



public class ViewSpecificActivity extends Activity implements OnClickListener{

  private ImageView imageView;
  private Button backBtn,modifyActivityBtn,deleteActivityBtn;

  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_view_specific_activity);
      initView();
      
      Intent intent = getIntent();
      String ActivityId = intent.getStringExtra("ActivityId");
      
      final String ReceivedActivityId = ActivityId;
      
      backBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ViewSpecificActivity.this, ManageActivity.class);
          startActivity(myIntent);
          ViewSpecificActivity.this.finish();
        }
      });
      
      modifyActivityBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("ActivityId", ReceivedActivityId);
          myIntent = new Intent(ViewSpecificActivity.this, ModifySpecificActivity.class);
          startActivity(myIntent);
          ViewSpecificActivity.this.finish();
        }
      });
  }
  
  private void initView() {

    imageView = (ImageView) this.findViewById(R.id.app_image_btn);
    backBtn = (Button)findViewById(R.id.main_top_back);
    modifyActivityBtn = (Button)findViewById(R.id.main_top_modify);
    deleteActivityBtn = (Button)findViewById(R.id.main_top_minus);

}
  
  @Override
  public void onClick(View arg0) {
    // TODO Auto-generated method stub
    
  }

}

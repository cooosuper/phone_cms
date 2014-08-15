package cn.phonecms.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewSpecificRecruit extends BaseActivity{

  private ImageView imageView;
  private Button backBtn,modifyRecruitBtn,deleteRecruitBtn;

  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_view_specific_recruit);
      initView();
      
      Intent intent = getIntent();
      String recruitId = intent.getStringExtra("RecruitId");
      
      final String ReceivedRecruitId = recruitId;
      
      backBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ViewSpecificRecruit.this, ManageRecruit.class);
          startActivity(myIntent);
          ViewSpecificRecruit.this.finish();
        }
      });
      
      modifyRecruitBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("RecruitId", ReceivedRecruitId);
          myIntent = new Intent(ViewSpecificRecruit.this, ModifySpecificRecruit.class);
          startActivity(myIntent);
          ViewSpecificRecruit.this.finish();
        }
      });
      
      deleteRecruitBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("RecruitId", ReceivedRecruitId);
          myIntent = new Intent(ViewSpecificRecruit.this, ManageRecruit.class);
          startActivity(myIntent);
          ViewSpecificRecruit.this.finish();
          Toast.makeText(ViewSpecificRecruit.this, "删除成功", 1).show();
        }
      });
  }
  
  private void initView() {

    imageView = (ImageView) this.findViewById(R.id.app_image_btn);
    backBtn = (Button)findViewById(R.id.main_top_back);
    modifyRecruitBtn = (Button)findViewById(R.id.main_top_modify);
    deleteRecruitBtn = (Button)findViewById(R.id.main_top_minus);

}
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}

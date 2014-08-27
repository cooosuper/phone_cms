package cn.phonecms.main.manage.feedback;


import cn.phonecms.main.BaseActivity;
import cn.phonecms.main.R;
import cn.phonecms.main.R.id;
import cn.phonecms.main.R.layout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class ModifySpecificFeedbackActivity extends BaseActivity{

  private ImageView imageView;
  private Button backBtn,modifyFeedbackBtn,deleteFeedbackBtn,replyFeedbackBtn;

  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_modify_specific_feedback);
      initView();
      
      Intent intent = getIntent();
      String commentId = intent.getStringExtra("FeedbackId");
      
      final String ReceivedActivityId = commentId;
      
      backBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ModifySpecificFeedbackActivity.this, ManageFeedbackActivity.class);
          startActivity(myIntent);
          ModifySpecificFeedbackActivity.this.finish();
        }
      });
      
      deleteFeedbackBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("FeedbackId", ReceivedActivityId);
          myIntent = new Intent(ModifySpecificFeedbackActivity.this, ManageFeedbackActivity.class);
          startActivity(myIntent);
          ModifySpecificFeedbackActivity.this.finish();
          Toast.makeText(ModifySpecificFeedbackActivity.this, "删除成功", 1).show();
        }
      });
  }
  
  private void initView() {

    imageView = (ImageView) this.findViewById(R.id.app_image_btn);
    backBtn = (Button)findViewById(R.id.main_top_back);
    modifyFeedbackBtn = (Button)findViewById(R.id.main_top_modify);
    deleteFeedbackBtn = (Button)findViewById(R.id.main_top_minus);
    replyFeedbackBtn = (Button)findViewById(R.id.app_reply_feedback_btn);

}
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}

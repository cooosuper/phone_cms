package cn.phonecms.main;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class ModifySpecificCommentActivity extends BaseActivity{

  private ImageView imageView;
  private Button backBtn,modifyCommentBtn,deleteCommentBtn,addCommentForSpecificBtn;

  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_modify_specific_comment);
      initView();
      
      Intent intent = getIntent();
      String commentId = intent.getStringExtra("CommentId");
      
      final String ReceivedActivityId = commentId;
      
      backBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ModifySpecificCommentActivity.this, ManageCommentActivity.class);
          startActivity(myIntent);
          ModifySpecificCommentActivity.this.finish();
        }
      });
      
      modifyCommentBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("CommentId", ReceivedActivityId);
          myIntent = new Intent(ModifySpecificCommentActivity.this, ManageCommentActivity.class);
          startActivity(myIntent);
          ModifySpecificCommentActivity.this.finish();
          Toast.makeText(ModifySpecificCommentActivity.this, "修改成功", 1).show();
        }
      });
      
      deleteCommentBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("CommentId", ReceivedActivityId);
          myIntent = new Intent(ModifySpecificCommentActivity.this, ManageCommentActivity.class);
          startActivity(myIntent);
          ModifySpecificCommentActivity.this.finish();
          Toast.makeText(ModifySpecificCommentActivity.this, "删除成功", 1).show();
        }
      });
  }
  
  private void initView() {

    imageView = (ImageView) this.findViewById(R.id.app_image_btn);
    backBtn = (Button)findViewById(R.id.main_top_back);
    modifyCommentBtn = (Button)findViewById(R.id.main_top_modify);
    deleteCommentBtn = (Button)findViewById(R.id.main_top_minus);
    addCommentForSpecificBtn = (Button)findViewById(R.id.app_blog_btn_comment);

}
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}

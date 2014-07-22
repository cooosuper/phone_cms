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



public class ViewSpecificComment extends BaseActivity{

  private ImageView imageView;
  private Button backBtn,modifyCommentBtn,deleteCommentBtn;

  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_view_specific_comment);
      initView();
      
      Intent intent = getIntent();
      String commentId = intent.getStringExtra("CommentId");
      
      final String ReceivedActivityId = commentId;
      
      backBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ViewSpecificComment.this, ManageProduct.class);
          startActivity(myIntent);
          ViewSpecificComment.this.finish();
        }
      });
      
      modifyCommentBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("CommentId", ReceivedActivityId);
          myIntent = new Intent(ViewSpecificComment.this, ModifySpecificComment.class);
          startActivity(myIntent);
          ViewSpecificComment.this.finish();
        }
      });
  }
  
  private void initView() {

    imageView = (ImageView) this.findViewById(R.id.app_image_btn);
    backBtn = (Button)findViewById(R.id.main_top_back);
    modifyCommentBtn = (Button)findViewById(R.id.main_top_modify);
    deleteCommentBtn = (Button)findViewById(R.id.main_top_minus);

}
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}

package cn.phonecms.main;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class ViewSpecificSubCompany extends BaseActivity{

  private ImageView imageView;
  private Button backBtn,modifySubcompanyBtn,deleteSubcompanyBtn;

  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_view_specific_subcompany);
      initView();
      
      Intent intent = getIntent();
      String subcompanyId = intent.getStringExtra("SubcompanyId");
      
      final String ReceivedSubcompanyId = subcompanyId;
      
      backBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ViewSpecificSubCompany.this, ManageSubCompany.class);
          startActivity(myIntent);
          ViewSpecificSubCompany.this.finish();
        }
      });
      
      modifySubcompanyBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("SubcompanyId", ReceivedSubcompanyId);
          myIntent = new Intent(ViewSpecificSubCompany.this, ModifySpecificSubCompany.class);
          startActivity(myIntent);
          ViewSpecificSubCompany.this.finish();
        }
      });
      
      deleteSubcompanyBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("SubcompanyId", ReceivedSubcompanyId);
          myIntent = new Intent(ViewSpecificSubCompany.this, ManageProduct.class);
          startActivity(myIntent);
          ViewSpecificSubCompany.this.finish();
          Toast.makeText(ViewSpecificSubCompany.this, "删除成功", 1).show();
        }
      });
  }
  
  private void initView() {

    imageView = (ImageView) this.findViewById(R.id.app_image_btn);
    backBtn = (Button)findViewById(R.id.main_top_back);
    modifySubcompanyBtn = (Button)findViewById(R.id.main_top_modify);
    deleteSubcompanyBtn = (Button)findViewById(R.id.main_top_minus);

}
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}

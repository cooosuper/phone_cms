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



public class ViewSpecificProduct extends BaseActivity{

  private ImageView imageView;
  private Button backBtn,modifyProductBtn,deleteProductBtn;

  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_view_specific_product);
      initView();
      
      Intent intent = getIntent();
      String productId = intent.getStringExtra("ProductId");
      
      final String ReceivedActivityId = productId;
      
      backBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ViewSpecificProduct.this, ManageProduct.class);
          startActivity(myIntent);
          ViewSpecificProduct.this.finish();
        }
      });
      
      modifyProductBtn.setOnClickListener(new OnClickListener() { 
        public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent.putExtra("ActivityId", ReceivedActivityId);
          myIntent = new Intent(ViewSpecificProduct.this, ModifySpecificProduct.class);
          startActivity(myIntent);
          ViewSpecificProduct.this.finish();
        }
      });
  }
  
  private void initView() {

    imageView = (ImageView) this.findViewById(R.id.app_image_btn);
    backBtn = (Button)findViewById(R.id.main_top_back);
    modifyProductBtn = (Button)findViewById(R.id.main_top_modify);
    deleteProductBtn = (Button)findViewById(R.id.main_top_minus);

}
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}

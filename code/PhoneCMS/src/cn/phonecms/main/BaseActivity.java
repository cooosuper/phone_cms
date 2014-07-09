package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;


public class BaseActivity extends Activity {
  
  private Button bTabCompany;
  private Button bTabProduct;
  private Button bTabActivity;
  private Button bTabMore;
  
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
    
  public void forward (Class<?> classObj) {
    Intent intent = new Intent();
    intent.setClass(this, classObj);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    this.startActivity(intent);
    this.finish();
  }
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem item) 
  {

    super.onOptionsItemSelected(item);

    switch (item.getItemId()) 
    {

      case R.id.company:                             
//        forward(LoginActivity.class);
        break;
  
      case R.id.product:                           
//        forward(LoginActivity.class);
        break;
  
      case R.id.activity:                          
        forward(ManageActivity.class);
        break;
      
      case R.id.more:
//        forward(LoginActivity.class);
        break;
      
      case R.id.comment:
//        forward(LoginActivity.class);
        break;
       
      case R.id.recruit:
//        forward(LoginActivity.class);
        break;
        
      case R.id.sub_company:
//        forward(LoginActivity.class); 
        break;

    }
    
    return super.onOptionsItemSelected(item);

    }
  
  public void bindMainTab () {
    bTabCompany  = (Button) findViewById(R.id.main_tab_company);
    bTabProduct  = (Button) findViewById(R.id.main_tab_product);
    bTabActivity = (Button) findViewById(R.id.main_tab_activity);
    bTabMore     = (Button) findViewById(R.id.main_tab_more);
    if (bTabCompany != null && bTabProduct != null && bTabActivity != null) {
      OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
          switch (v.getId()) {
            case R.id.main_tab_company:
              forward(LoginActivity.class);
              break;
            case R.id.main_tab_product:
              forward(LoginActivity.class);
              break;
            case R.id.main_tab_activity:
              forward(ManageActivity.class);
              break;
            case R.id.main_tab_more:
              bindMainTab();
              break;
          }
        }
      };
      bTabCompany.setOnClickListener(mOnClickListener);
      bTabProduct.setOnClickListener(mOnClickListener);
      bTabActivity.setOnClickListener(mOnClickListener);
      bTabMore.setOnClickListener(mOnClickListener);
    }
  }
  
  
}

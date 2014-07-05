package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends Activity {
  
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
        forward(Login.class);
        break;
  
      case R.id.product:                           
        forward(Login.class);
        break;
  
      case R.id.activity:                          
        forward(Login.class);
        break;
      
      case R.id.more:
        forward(Login.class);
        break;
      
      case R.id.comment:
        forward(Login.class);
        break;
       
      case R.id.recruit:
        forward(Login.class);
        break;
        
      case R.id.sub_company:
        forward(Login.class); 
        break;

    }
    
    return super.onOptionsItemSelected(item);

    }
  
  
}

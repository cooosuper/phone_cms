package cn.phonecms.main;

import java.util.HashMap;

//import com.app.demos.R;
//import com.app.demos.base.C;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 程序主入口
 * 
 */
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		OnClickListener mOnClickListener = new OnClickListener() {
      @Override
      public void onClick(View v) {
          switch (v.getId()) {
              case R.id.app_register_btn_submit : 
                  doTaskRegister();
                  break;
              case R.id.login :
                  goLoginPage();
          }
      }
		};
		
    findViewById(R.id.app_register_btn_submit).setOnClickListener(mOnClickListener);
    findViewById(R.id.login).setOnClickListener(mOnClickListener);

	}
	
  private void doTaskRegister() 
  {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, Register.class);
    MainActivity.this.startActivity(intent);
  }
  
  private void goLoginPage() 
  {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, Login.class);
    MainActivity.this.startActivity(intent);
  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

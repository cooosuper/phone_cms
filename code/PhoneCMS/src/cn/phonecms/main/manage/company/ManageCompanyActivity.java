package cn.phonecms.main.manage.company;

import cn.phonecms.main.BaseActivity;
import cn.phonecms.main.CompanyLoginSuccessActivity;
import cn.phonecms.main.R;
import cn.phonecms.main.R.id;
import cn.phonecms.main.R.layout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageCompanyActivity extends BaseActivity{

  private Button backBtn, addCompanyBtn;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);   
    setContentView(R.layout.activity_manage_company);
   
    backBtn = (Button)findViewById(R.id.main_top_back);

    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageCompanyActivity.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageCompanyActivity.this.finish();
      }
    });      
  }

  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
  
}

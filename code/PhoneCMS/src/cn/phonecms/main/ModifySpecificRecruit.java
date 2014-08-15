package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ModifySpecificRecruit extends Activity
{

  private static String requestURL = "http://***.***.***.***:8080/***/***";
  private Button backBtn, modifyBtn,delRecruitBtn;

  private String recruitJob, recruitNumbers, recruitSalary, recruitQualifications,jobDesc;
  private EditText appRecruitJob, appRecruitNumbers, appRecruitSalary, appRecruitQualifications, appJobDesc;
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_specific_recruit);
        initView();

        backBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ModifySpecificRecruit.this, ViewSpecificRecruit.class);
          startActivity(myIntent);
          ModifySpecificRecruit.this.finish();
          }
        });
        
        modifyBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
           Intent mineIntent = new Intent();         
           mineIntent.putExtra("recruitJob", recruitJob);
           mineIntent.putExtra("recruitNumbers",recruitNumbers);
           mineIntent.putExtra("recruitSalary",recruitSalary);
           mineIntent.putExtra("recruitQualifications",recruitQualifications);
           mineIntent.putExtra("jobDesc",jobDesc);
           mineIntent = new Intent(ModifySpecificRecruit.this, ManageRecruit.class);
           startActivity(mineIntent);
           ModifySpecificRecruit.this.finish();
           Toast.makeText(ModifySpecificRecruit.this, "修改成功", 1).show();
          }
        });
        
        delRecruitBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) {               
           Intent intent = getIntent();
           String subcompanyId = intent.getStringExtra("SubCompanyId");
           Intent mineIntent = new Intent(); 
           mineIntent.putExtra("subcompanyId", subcompanyId);
           mineIntent = new Intent(ModifySpecificRecruit.this, ManageSubCompany.class);
           startActivity(mineIntent);
           ModifySpecificRecruit.this.finish();
           Toast.makeText(ModifySpecificRecruit.this, "删除成功", 1).show();
          }
        });
    }
    
    /**
     * 初始化数据
     */
  private void initView() {

        modifyBtn = (Button) this.findViewById(R.id.main_top_modify);
        backBtn = (Button) this.findViewById(R.id.main_top_back);
        delRecruitBtn = (Button) this.findViewById(R.id.main_top_minus);
        
        appRecruitJob             = (EditText)findViewById(R.id.app_recruit_job);
        appRecruitNumbers         = (EditText)findViewById(R.id.app_recruit_numbers);
        appRecruitSalary          = (EditText)findViewById(R.id.app_recruit_salary);
        appRecruitQualifications  = (EditText)findViewById(R.id.app_recruit_qualifications);
        appJobDesc                = (EditText)findViewById(R.id.app_job_desc);
        
        recruitJob            = appRecruitJob.getText().toString();
        recruitNumbers        = appRecruitNumbers.getText().toString();
        recruitSalary         = appRecruitSalary.getText().toString();
        recruitQualifications = appRecruitQualifications.getText().toString();
        jobDesc               = appJobDesc.getText().toString();
  }
  
}
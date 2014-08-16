package cn.phonecms.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AddRecruit extends Activity{


  private static String requestURL = "http://***.***.***.***:8080/***/***";
  private Button backBtn,addBtn;
 
  private String recruitJob, recruitNumbers, recruitSalary, recruitQualifications,jobDesc;
  private EditText appRecruitJob, appRecruitNumbers, appRecruitSalary, appRecruitQualifications, appJobDesc;
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recruit);
        initView();
        
        backBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
            Intent myIntent = new Intent();
            myIntent = new Intent(AddRecruit.this, ManageRecruit.class);
            startActivity(myIntent);
            AddRecruit.this.finish();
          }
        });
        
        addBtn.setOnClickListener(new OnClickListener(){
          public void onClick(View v) { 
            Intent mineIntent = new Intent();         
            mineIntent.putExtra("recruitJob", recruitJob);
            mineIntent.putExtra("recruitNumbers",recruitNumbers);
            mineIntent.putExtra("recruitSalary",recruitSalary);
            mineIntent.putExtra("recruitQualifications",recruitQualifications);
            mineIntent.putExtra("jobDesc",jobDesc);
            mineIntent = new Intent(AddRecruit.this, ManageRecruit.class);
            startActivity(mineIntent);
            AddRecruit.this.finish();
            Toast.makeText(AddRecruit.this, "添加成功", 1).show();
          }
        });
    } 
  
    private void initView() {
  
      addBtn  = (Button) this.findViewById(R.id.main_top_add);
      backBtn = (Button) this.findViewById(R.id.main_top_back);
      
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
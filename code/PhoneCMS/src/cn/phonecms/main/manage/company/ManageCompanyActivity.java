package cn.phonecms.main.manage.company;

import java.util.ArrayList;

import cn.phonecms.adapter.Adapter_main;
import cn.phonecms.main.BaseActivity;
import cn.phonecms.main.CompanyLoginSuccessActivity;
import cn.phonecms.main.ImageActivity;
import cn.phonecms.main.R;
import cn.phonecms.main.manage.product.AddProductActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class ManageCompanyActivity extends BaseActivity{
  
  private Button backBtn, addCompanyImgBtn, addCompanyDescBtn, confirmBtn;
  private ListView list_content;  
  private ArrayList<String> datas = new ArrayList<String>();
  private ArrayList<ImageActivity> upLoads = new ArrayList<ImageActivity>();
  BaseAdapter adapter;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);   
    setContentView(R.layout.activity_manage_company);
    
    initView();
    registerListener();   
  }
  private void initView() {
    backBtn = (Button)findViewById(R.id.main_top_back);
    addCompanyImgBtn = (Button) this.findViewById(R.id.app_addImage_btn); 
    addCompanyDescBtn = (Button) this.findViewById(R.id.app_addDesc_btn); 
    confirmBtn  = (Button)this.findViewById(R.id.main_top_confirm); 
    list_content = (ListView) findViewById(R.id.list_content);
    adapter = new Adapter_main(this, datas);
    list_content.setAdapter(adapter);
  }
  
  private void registerListener() {
    
    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageCompanyActivity.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageCompanyActivity.this.finish();
      }
    });  
    
    addCompanyImgBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) {               

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
      }
    });
    
    addCompanyDescBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) {               

      }
    });
    
    confirmBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) {               
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageCompanyActivity.this, ModifySpecificCompanyActivity.class);
        startActivity(myIntent);
        ManageCompanyActivity.this.finish();
        Toast.makeText(ManageCompanyActivity.this, "添加成功", 1).show();
      }
    });
    
    list_content.setOnItemLongClickListener(new OnItemLongClickListener() {

      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view,int position, long id) {
        
        datas.remove(position);
        adapter.notifyDataSetChanged();
        
        return false;
      }
    });
  }
  
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    
    //从图片库
    if(requestCode == 1 && resultCode == RESULT_OK){
      Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            
      datas.add(picturePath);
            
            adapter.notifyDataSetChanged();
    }
  }
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
  
}

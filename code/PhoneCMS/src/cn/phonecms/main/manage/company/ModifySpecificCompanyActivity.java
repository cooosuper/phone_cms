package cn.phonecms.main.manage.company;

import cn.phonecms.main.BaseActivity;
import cn.phonecms.main.R;
import cn.phonecms.main.SelectPicActivity;
import cn.phonecms.main.R.id;
import cn.phonecms.main.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ModifySpecificCompanyActivity extends BaseActivity implements OnClickListener
{
  private static final String TAG = "uploadImage";
  
  /*** 去上传文件  */
  protected static final int TO_UPLOAD_FILE = 1;  
  /*** 上传文件响应  */
  protected static final int UPLOAD_FILE_DONE = 2;  
  /*** 选择文件  */
  public static final int TO_SELECT_PHOTO = 3;

  private Button addImageButton,addDescButton,backBtn, modifyBtn,delCompanyButton;
  private ImageView imageView;
  private String picPath = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_specific_company);
        initView();
        
        backBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
          Intent myIntent = new Intent();
          myIntent = new Intent(ModifySpecificCompanyActivity.this, ManageCompanyActivity.class);
          startActivity(myIntent);
          ModifySpecificCompanyActivity.this.finish();
          }
        });
        
        modifyBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
           Intent mineIntent = new Intent();         
           mineIntent = new Intent(ModifySpecificCompanyActivity.this, ManageCompanyActivity.class);
           startActivity(mineIntent);
           ModifySpecificCompanyActivity.this.finish();
           Toast.makeText(ModifySpecificCompanyActivity.this, "修改成功", 1).show();
          }
        });
        
        delCompanyButton.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
           Intent mineIntent = new Intent();         
           mineIntent = new Intent(ModifySpecificCompanyActivity.this, ManageCompanyActivity.class);
           startActivity(mineIntent);
           ModifySpecificCompanyActivity.this.finish();
           Toast.makeText(ModifySpecificCompanyActivity.this, "删除成功", 1).show();
          }
        });
      
        Intent intent = getIntent();
        String productId = intent.getStringExtra("ProductId");
    }
    
    /*** 初始化数据  */
  private void initView() {
        addImageButton = (Button) this.findViewById(R.id.app_addImage_btn);
        addDescButton = (Button) this.findViewById(R.id.app_addDesc_btn);
        delCompanyButton = (Button) this.findViewById(R.id.main_top_minus);
        addImageButton.setOnClickListener(this);
        addDescButton.setOnClickListener(this);
        modifyBtn = (Button) this.findViewById(R.id.main_top_modify);
        backBtn = (Button) this.findViewById(R.id.main_top_back);
        imageView = (ImageView) this.findViewById(R.id.app_image_btn);        
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
    case R.id.app_addImage_btn:
      Intent intent = new Intent(this,SelectPicActivity.class);
      startActivityForResult(intent, TO_SELECT_PHOTO);
      break;
    default:
      break;
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode==Activity.RESULT_OK && requestCode == TO_SELECT_PHOTO)
    {
      picPath = data.getStringExtra(SelectPicActivity.KEY_PHOTO_PATH);
      Log.i(TAG, "最终选择的图片="+picPath);
      Bitmap bm = BitmapFactory.decodeFile(picPath);
      imageView.setImageBitmap(bm);
    }
    super.onActivityResult(requestCode, resultCode, data);
  }  
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
}
package cn.phonecms.main.manage.product;


import cn.phonecms.adapter.CategoryAdapter;
import cn.phonecms.main.BaseActivity;
import cn.phonecms.main.CompanyLoginSuccessActivity;
import cn.phonecms.main.R;
import cn.phonecms.main.R.id;
import cn.phonecms.main.R.layout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class ManageProductActivity extends BaseActivity{

  private Button backBtn, addProductBtn;
  private ListView catergory_listview;


  private String[] mImageIds = {"http://imgstatic.baidu.com/img/image/shouye/fanbingbing.jpg","http://imgstatic.baidu.com/img/image/shouye/liuyifei.jpg","http://imgstatic.baidu.com/img/image/shouye/wanglihong.jpg","http://imgstatic.baidu.com/img/image/shouye/gaoyuanyuan.jpg",
      "http://imgstatic.baidu.com/img/image/shouye/yaodi.jpg","http://imgstatic.baidu.com/img/image/shouye/zhonghanliang.jpg","http://imgstatic.baidu.com/img/image/shouye/xiezhen.jpg","http://imgstatic.baidu.com/img/image/shouye/yiping3.jpg"
       };
  //给照片添加文字显示(Title)
  private String[] mTitleValues = { "家电产品", "图书产品", "衣服产品", "笔记本产品", "数码产品",
      "家具产品", "手机产品", "护肤产品" };
  
  private String[] mContentValues={"家电/生活电器", "电子书/图书","男装/女装", "笔记本/笔记本配件", "摄影摄像/数码配件", 
      "家具/灯具", "手机通讯/运营商", "面部护理/口腔护理/..."};
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_manage_product);
   
    backBtn = (Button)findViewById(R.id.main_top_back);
    addProductBtn = (Button)findViewById(R.id.main_top_plus);
    catergory_listview = (ListView) findViewById(R.id.app_config_list_main);  
    catergory_listview.setAdapter(new CategoryAdapter(this, mImageIds, mTitleValues, mContentValues));
    catergory_listview.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterview, View view, int parent,long id) {
        Toast.makeText(ManageProductActivity.this, "你点击了地"+id+"项", 1).show();       
        Intent myIntent = new Intent();
        myIntent.putExtra("ActivityId", id);
        myIntent = new Intent(ManageProductActivity.this, ModifySpecificProductActivity.class);
        startActivity(myIntent);
        ManageProductActivity.this.finish();
        
      }
    });

    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageProductActivity.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageProductActivity.this.finish();
      }
    });
    

    //添加Product事件
    addProductBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
       // do add related coding
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageProductActivity.this, AddProductActivity.class);
        startActivity(myIntent);
        ManageProductActivity.this.finish();
      }
    });
        
  }
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
  
}

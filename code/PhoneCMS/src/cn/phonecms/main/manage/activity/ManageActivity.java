package cn.phonecms.main.manage.activity;


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
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ManageActivity extends BaseActivity{

  private Button backBtn, addActivityBtn;
  private GridView gridview;
  
//适配显示的图片数组
  private String[] mImageIds = {"http://imgstatic.baidu.com/img/image/shouye/fanbingbing.jpg","http://imgstatic.baidu.com/img/image/shouye/liuyifei.jpg","http://imgstatic.baidu.com/img/image/shouye/wanglihong.jpg","http://imgstatic.baidu.com/img/image/shouye/gaoyuanyuan.jpg",
      "http://imgstatic.baidu.com/img/image/shouye/yaodi.jpg","http://imgstatic.baidu.com/img/image/shouye/zhonghanliang.jpg","http://imgstatic.baidu.com/img/image/shouye/xiezhen.jpg","http://imgstatic.baidu.com/img/image/shouye/yiping3.jpg"
       };
  //给照片添加文字显示(Title)
  private String[] mTitleValues = { "家电活动", "图书活动", "衣服活动", "笔记本活动", "数码活动",
      "家具活动", "手机活动", "护肤活动" };
  
  private String[] mContentValues={"家电/生活电器", "电子书/图书","男装/女装", "笔记本/笔记本配件", "摄影摄像/数码配件", 
      "家具/灯具", "手机通讯/运营商", "面部护理/口腔护理/..."};
  
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_manage_activity);
   
    backBtn = (Button)findViewById(R.id.main_top_back);
    addActivityBtn = (Button)findViewById(R.id.main_top_plus);
    gridview=(GridView)this.findViewById(R.id.app_config_list_main);
    gridview.setAdapter(new CategoryAdapter(this, mImageIds, mTitleValues, mContentValues));
    gridview.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterview, View view, int parent,
          long id) {
        Toast.makeText(ManageActivity.this, "你点击了地"+id+"项", 1).show();
        
        Intent myIntent = new Intent();
        myIntent.putExtra("ActivityId", id);
        myIntent = new Intent(ManageActivity.this, ModifySpecificActivity.class);
        startActivity(myIntent);
        ManageActivity.this.finish();
        
      }
    });

    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageActivity.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageActivity.this.finish();
      }
    });
    
    //添加Activity事件
    addActivityBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
       // do add related coding
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageActivity.this, AddActivity.class);
        startActivity(myIntent);
        ManageActivity.this.finish();
      }
    });        
  }

  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }

}

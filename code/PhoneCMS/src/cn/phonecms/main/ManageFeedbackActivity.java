package cn.phonecms.main;

import cn.phonecms.adapter.CategoryAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ManageFeedbackActivity extends BaseActivity{

  private Button backBtn;
  private ListView catergory_listview;
  
//适配显示的图片数组
  private String[] mImageIds = {"http://imgstatic.baidu.com/img/image/shouye/fanbingbing.jpg","http://imgstatic.baidu.com/img/image/shouye/liuyifei.jpg","http://imgstatic.baidu.com/img/image/shouye/wanglihong.jpg","http://imgstatic.baidu.com/img/image/shouye/gaoyuanyuan.jpg",
      "http://imgstatic.baidu.com/img/image/shouye/yaodi.jpg","http://imgstatic.baidu.com/img/image/shouye/zhonghanliang.jpg","http://imgstatic.baidu.com/img/image/shouye/xiezhen.jpg","http://imgstatic.baidu.com/img/image/shouye/yiping3.jpg"
       };
  //给照片添加文字显示(Title)
  private String[] mTitleValues = { "家电意见反馈", "图书意见反馈", "衣服意见反馈", "笔记本意见反馈", "数码意见反馈",
      "家具意见反馈", "手机意见反馈", "护肤意见反馈" };
  
  private String[] mContentValues={"家电/生活电器/厨房电器", "电子书/图书/小说","男装/女装/童装", "笔记本/笔记本配件/产品外设", "摄影摄像/数码配件", 
      "家具/灯具/生活用品", "手机通讯/运营商/手机配件", "面部护理/口腔护理/..."};
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);   
    setContentView(R.layout.activity_manage_feedback);
   
    backBtn             = (Button)findViewById(R.id.main_top_back);
    catergory_listview  = (ListView)this.findViewById(R.id.app_config_list_main);
    catergory_listview.setAdapter(new CategoryAdapter(this, mImageIds, mTitleValues, mContentValues));
    catergory_listview.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterview, View view, int parent,long id) {
        Toast.makeText(ManageFeedbackActivity.this, "你点击了地"+id+"项", 1).show();     
        Intent myIntent = new Intent();
        myIntent.putExtra("CommentId", id);
        myIntent = new Intent(ManageFeedbackActivity.this, ModifySpecificFeedbackActivity.class);                                                          
        startActivity(myIntent);
        ManageFeedbackActivity.this.finish();
        
      }
    });

    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageFeedbackActivity.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageFeedbackActivity.this.finish();
      }
    });      
  }
 
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
  
}

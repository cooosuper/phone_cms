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

public class ManageCommentActivity extends BaseActivity{

  private Button backBtn;
  private ListView catergory_listview;
  
//适配显示的图片数组
  private String[] mImageIds = {"http://imgstatic.baidu.com/img/image/shouye/fanbingbing.jpg","http://imgstatic.baidu.com/img/image/shouye/liuyifei.jpg","http://imgstatic.baidu.com/img/image/shouye/wanglihong.jpg","http://imgstatic.baidu.com/img/image/shouye/gaoyuanyuan.jpg",
      "http://imgstatic.baidu.com/img/image/shouye/yaodi.jpg","http://imgstatic.baidu.com/img/image/shouye/zhonghanliang.jpg","http://imgstatic.baidu.com/img/image/shouye/xiezhen.jpg","http://imgstatic.baidu.com/img/image/shouye/yiping3.jpg"
       };
  //给照片添加文字显示(Title)
  private String[] mTitleValues = { "家电评论", "图书评论", "衣服评论", "笔记本评论", "数码评论",
      "家具评论", "手机评论", "护肤评论" };
  
  private String[] mContentValues={"家电/生活电器/厨房电器", "电子书/图书/小说","男装/女装/童装", "笔记本/笔记本配件/产品外设", "摄影摄像/数码配件", 
      "家具/灯具/生活用品", "手机通讯/运营商/手机配件", "面部护理/口腔护理/..."};
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);   
    setContentView(R.layout.activity_manage_comment);
   
    backBtn             = (Button)findViewById(R.id.main_top_back);
    catergory_listview  = (ListView)this.findViewById(R.id.app_config_list_main);
    catergory_listview.setAdapter(new CategoryAdapter(this, mImageIds, mTitleValues, mContentValues));
    catergory_listview.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterview, View view, int parent,long id) {
        Toast.makeText(ManageCommentActivity.this, "你点击了地"+id+"项", 1).show();     
        Intent myIntent = new Intent();
        myIntent.putExtra("CommentId", id);
        myIntent = new Intent(ManageCommentActivity.this, ModifySpecificCommentActivity.class);                                                          
        startActivity(myIntent);
        ManageCommentActivity.this.finish();
        
      }
    });

    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageCommentActivity.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageCommentActivity.this.finish();
      }
    });      
  }
 
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
  
}

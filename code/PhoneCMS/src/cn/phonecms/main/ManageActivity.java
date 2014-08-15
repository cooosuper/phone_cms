package cn.phonecms.main;



import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.ImageLoader.ImageListener;

import cn.phonecms.main.cache.BitmapCache;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ManageActivity extends BaseActivity{

  private Button backBtn, addActivityBtn;
  private ListView catergory_listview;
  private LayoutInflater layoutInflater;
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_manage_activity);
   
    backBtn = (Button)findViewById(R.id.main_top_back);
    addActivityBtn = (Button)findViewById(R.id.main_top_plus);
    catergory_listview=(ListView)this.findViewById(R.id.app_config_list_main);
    catergory_listview.setAdapter(new CatergorAdapter(this));
    catergory_listview.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterview, View view, int parent,
          long id) {
        Toast.makeText(ManageActivity.this, "你点击了地"+id+"项", 1).show();
        
        Intent myIntent = new Intent();
        myIntent.putExtra("ActivityId", id);
        myIntent = new Intent(ManageActivity.this, ViewSpecificActivity.class);
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
  
  private class CatergorAdapter extends BaseAdapter{
    
    private Context ctx;
    private RequestQueue mQueue;
    private ImageLoader mImageLoader;
    
    public CatergorAdapter(Context ctx) {
      this.ctx = ctx;
      mQueue = Volley.newRequestQueue(ctx);
      mImageLoader = new ImageLoader(mQueue, new BitmapCache());
    }

    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return mImageIds.length;
    }

    @Override
    public Object getItem(int position) {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public long getItemId(int position) {
      // TODO Auto-generated method stub
      return 0;
    }

    @SuppressWarnings("null")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_category_item, null);
      ImageView imageView  = (ImageView) convertView.findViewById(R.id.catergory_image);
      TextView catergoryItemTitle = (TextView)convertView.findViewById(R.id.catergoryitem_title);
      TextView catergoryItemContent = (TextView)convertView.findViewById(R.id.catergoryitem_content);
      
      ImageListener listener = ImageLoader.getImageListener(imageView, android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);
          mImageLoader.get(mImageIds[position], listener);
          catergoryItemTitle.setText(mTitleValues[position]);
          catergoryItemContent.setText(mContentValues[position]);
      return convertView;
    
    }
    
    
    
  }
  
//适配显示的图片数组
  private String[] mImageIds = {"http://imgstatic.baidu.com/img/image/shouye/fanbingbing.jpg","http://imgstatic.baidu.com/img/image/shouye/liuyifei.jpg","http://imgstatic.baidu.com/img/image/shouye/wanglihong.jpg","http://imgstatic.baidu.com/img/image/shouye/gaoyuanyuan.jpg",
      "http://imgstatic.baidu.com/img/image/shouye/yaodi.jpg","http://imgstatic.baidu.com/img/image/shouye/zhonghanliang.jpg","http://imgstatic.baidu.com/img/image/shouye/xiezhen.jpg","http://imgstatic.baidu.com/img/image/shouye/yiping3.jpg"
       };
  //给照片添加文字显示(Title)
  private String[] mTitleValues = { "家电活动", "图书活动", "衣服活动", "笔记本活动", "数码活动",
      "家具活动", "手机活动", "护肤活动" };
  
  private String[] mContentValues={"家电/生活电器/厨房电器", "电子书/图书/小说","男装/女装/童装", "笔记本/笔记本配件/产品外设", "摄影摄像/数码配件", 
      "家具/灯具/生活用品", "手机通讯/运营商/手机配件", "面部护理/口腔护理/..."};

  
  public static class ViewHolder {
    ImageView image;
    TextView title;
    TextView content;
  }
  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }

}

package cn.phonecms.main;







import cn.phonecms.main.adapter.CatergorAdapter;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ManageProduct extends BaseActivity{

  private Button backBtn, addProductBtn;
  private ListView catergory_listview;
  private LayoutInflater layoutInflater;
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_manage_product);
   
    backBtn = (Button)findViewById(R.id.main_top_back);
    addProductBtn = (Button)findViewById(R.id.main_top_plus);
    catergory_listview=(ListView)this.findViewById(R.id.app_config_list_main);   
    catergory_listview.setAdapter(new CatergorAdapter(this));
    catergory_listview.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterview, View view, int parent,
          long id) {
        Toast.makeText(ManageProduct.this, "你点击了地"+id+"项", 1).show();
        
        Intent myIntent = new Intent();
        myIntent.putExtra("ActivityId", id);
        myIntent = new Intent(ManageProduct.this, ViewSpecificProduct.class);
        startActivity(myIntent);
        ManageProduct.this.finish();
        
      }
    });

    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageProduct.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageProduct.this.finish();
      }
    });
    

    //添加Product事件
    addProductBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
       // do add related coding
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageProduct.this, AddProduct.class);
        startActivity(myIntent);
        ManageProduct.this.finish();
      }
    });
        
  }
  
//  public class CatergorAdapter extends BaseAdapter{
//
//    private Context ctx;
//    private RequestQueue mQueue;
//    private ImageLoader mImageLoader;
//    
//    public CatergorAdapter(Context ctx) {
//      this.ctx = ctx;
//      mQueue = Volley.newRequestQueue(ctx);
//      mImageLoader = new ImageLoader(mQueue, new BitmapCache());
//    }
//
//    @Override
//    public int getCount() {
//      // TODO Auto-generated method stub
//      return mImageIds.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//      // TODO Auto-generated method stub
//      return mImageIds[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//      // TODO Auto-generated method stub
//      return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//      convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_category_item, null);
//      ImageView imageView  = (ImageView) convertView.findViewById(R.id.catergory_image);
//      TextView catergoryItemTitle = (TextView)convertView.findViewById(R.id.catergoryitem_title);
//      TextView catergoryItemContent = (TextView)convertView.findViewById(R.id.catergoryitem_content);
//      
//      ImageListener listener = ImageLoader.getImageListener(imageView, android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);
//          mImageLoader.get(mImageIds[position].toString(), listener);
//          catergoryItemTitle.setText(mTitleValues[position]);
//          catergoryItemContent.setText(mContentValues[position]);
//      return convertView;
//    }
//    
//    
//    
//  }
  
//适配显示的图片数组
  private Integer[] mImageIds = {R.drawable.catergory_appliance,R.drawable.catergory_book,R.drawable.catergory_cloth,R.drawable.catergory_deskbook,
      R.drawable.catergory_digtcamer,R.drawable.catergory_furnitrue,R.drawable.catergory_mobile,R.drawable.catergory_skincare
       };
  //给照片添加文字显示(Title)
  private String[] mTitleValues = { "家电产品", "图书产品", "衣服产品", "笔记本产品", "数码产品",
      "家具产品", "手机产品", "护肤产品" };
  
  private String[] mContentValues={"家电/生活电器/厨房电器", "电子书/图书/小说","男装/女装/童装", "笔记本/笔记本配件/产品外设", "摄影摄像/数码配件", 
      "家具/灯具/生活用品", "手机通讯/运营商/手机配件", "面部护理/口腔护理/..."};

  
  public void onStart() {
    super.onStart();
    this.bindMainTab();
  }
  
}

package cn.phonecms.main;



import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
import android.view.KeyEvent;

public class ManageCompany extends BaseActivity{

  private Button backBtn, addCompanyBtn;
  private ListView catergory_listview;
  private LayoutInflater layoutInflater;
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.activity_manage_company);
   
    backBtn = (Button)findViewById(R.id.main_top_back);
    addCompanyBtn = (Button)findViewById(R.id.main_top_plus);
    catergory_listview=(ListView)this.findViewById(R.id.app_config_list_main);
    catergory_listview.setAdapter(new CatergorAdapter());
    catergory_listview.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterview, View view, int parent,
          long id) {
        Toast.makeText(ManageCompany.this, "你点击了地"+id+"项", 1).show();
        
        Intent myIntent = new Intent();
        myIntent.putExtra("ActivityId", id);
        myIntent = new Intent(ManageCompany.this, ModifySpecificCompany.class);
        startActivity(myIntent);
        ManageCompany.this.finish();
        
      }
    });

    //返回按钮事件
    backBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageCompany.this, CompanyLoginSuccessActivity.class);
        startActivity(myIntent);
        ManageCompany.this.finish();
      }
    });
    

    //添加Company事件
    addCompanyBtn.setOnClickListener(new OnClickListener() { 
      public void onClick(View v) { 
       // do add related coding
        Intent myIntent = new Intent();
        myIntent = new Intent(ManageCompany.this, AddCompany.class);
        startActivity(myIntent);
        ManageCompany.this.finish();
      }
    });
        
  }
  
  private class CatergorAdapter extends BaseAdapter{

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

      ViewHolder holder=new ViewHolder();
      layoutInflater=LayoutInflater.from(ManageCompany.this);
      
      //组装数据
      if(convertView==null){
        convertView=layoutInflater.inflate(R.layout.activity_category_item, null);
        holder.image=(ImageView) convertView.findViewById(R.id.catergory_image);
        holder.title=(TextView) convertView.findViewById(R.id.catergoryitem_title);
        holder.content=(TextView) convertView.findViewById(R.id.catergoryitem_content);
        //使用tag存储数据
        convertView.setTag(holder);
      }else{
        holder=(ViewHolder) convertView.getTag();
      }
      holder.image.setImageResource(mImageIds[position]);
      holder.title.setText(mTitleValues[position]);
      holder.content.setText(mContentValues[position]);
    //  holder.title.setText(array[position]);
      
      return convertView;
    
    }
    
    
    
  }
  
//适配显示的图片数组
  private Integer[] mImageIds = {R.drawable.catergory_appliance,R.drawable.catergory_book,R.drawable.catergory_cloth,R.drawable.catergory_deskbook,
      R.drawable.catergory_digtcamer,R.drawable.catergory_furnitrue,R.drawable.catergory_mobile,R.drawable.catergory_skincare
       };
  //给照片添加文字显示(Title)
  private String[] mTitleValues = { "家电公司", "图书公司", "衣服公司", "笔记本公司", "数码公司",
      "家具公司", "手机公司", "护肤公司" };
  
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

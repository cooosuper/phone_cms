package cn.phonecms.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.phonecms.main.R;
import cn.phonecms.main.cache.BitmapCache;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.ImageLoader.ImageListener;

public class CatergorAdapter extends BaseAdapter{

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
    return mImageIds[position];
  }

  @Override
  public long getItemId(int position) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_category_item, null);
    ImageView imageView  = (ImageView) convertView.findViewById(R.id.catergory_image);
    TextView catergoryItemTitle = (TextView)convertView.findViewById(R.id.catergoryitem_title);
    TextView catergoryItemContent = (TextView)convertView.findViewById(R.id.catergoryitem_content);
    
    ImageListener listener = ImageLoader.getImageListener(imageView, android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);
        mImageLoader.get(mImageIds[position].toString(), listener);
        catergoryItemTitle.setText(mTitleValues[position]);
        catergoryItemContent.setText(mContentValues[position]);
    return convertView;
  }
  
  
  
}
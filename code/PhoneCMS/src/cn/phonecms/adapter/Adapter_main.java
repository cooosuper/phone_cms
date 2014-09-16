package cn.phonecms.adapter;

import java.util.ArrayList;

import cn.phonecms.main.R;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/************************************************************
 *  内容摘要  ：
 *
 *  作者  ：adminstrator
 *  创建时间  ：2013-7-23 上午10:38:09 
 *  当前版本号：v1.0
 *  历史记录  :
 *    日期  : 2013-7-23 上午10:38:09  修改人：adminstrator
 *    描述  :
 ************************************************************/
public class Adapter_main extends BaseAdapter{
  private Context context;
  private ArrayList<String> datas;

  public Adapter_main(Context context, ArrayList<String> datas) {
    this.context = context;
    this.datas = datas;
  }

  /**
   *  函数名称 : getCount
   *  功能描述 :  
   *  参数说明：
   *    @return
   *  返回值：
   *    
   *  修改记录：
   *  日期：2013-7-23 上午10:38:23 修改人：adminstrator
   *  描述  ：
   *          
   */
  @Override
  public int getCount() {
    return datas.size();
  }

  /**
   *  函数名称 : getItem
   *  功能描述 :  
   *  参数说明：
   *    @param position
   *    @return
   *  返回值：
   *    
   *  修改记录：
   *  日期：2013-7-23 上午10:38:23 修改人：adminstrator
   *  描述  ：
   *          
   */
  @Override
  public Object getItem(int position) {
    return datas.get(position);
  }

  /**
   *  函数名称 : getItemId
   *  功能描述 :  
   *  参数说明：
   *    @param position
   *    @return
   *  返回值：
   *    
   *  修改记录：
   *  日期：2013-7-23 上午10:38:23 修改人：adminstrator
   *  描述  ：
   *          
   */
  @Override
  public long getItemId(int position) {
    return position;
  }

  /**
   *  函数名称 : getView
   *  功能描述 :  
   *  参数说明：
   *    @param position
   *    @param convertView
   *    @param parent
   *    @return
   *  返回值：
   *    
   *  修改记录：
   *  日期：2013-7-23 上午10:38:23 修改人：adminstrator
   *  描述  ：
   *          
   */
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    
    LayoutInflater inflater = null;
    Viewholder holder = null;
    
    if (convertView == null) {
      inflater = LayoutInflater.from(context);
      
      convertView = inflater.inflate(R.layout.adapter_main, null);
      
      holder = new Viewholder();
      
      holder.img_upload = (ImageView) convertView.findViewById(R.id.img_icon);
      
      convertView.setTag(holder);
      
    }else {
      holder = (Viewholder) convertView.getTag();
    }
    
    Drawable drawable = BitmapDrawable.createFromPath(datas.get(position).toString());
    holder.img_upload.setBackgroundDrawable(drawable);
    
    return convertView;
  }

  class Viewholder{
    private ImageView img_upload;
  }
}

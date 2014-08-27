package cn.phonecms.main;

import cn.phonecms.main.manage.activity.ManageActivity;
import cn.phonecms.main.manage.comment.ManageCommentActivity;
import cn.phonecms.main.manage.company.ManageCompanyActivity;
import cn.phonecms.main.manage.feedback.ManageFeedbackActivity;
import cn.phonecms.main.manage.product.ManageProductActivity;
import cn.phonecms.main.manage.recruit.ManageRecruitActivity;
import cn.phonecms.main.manage.subcompany.ManageSubCompanyActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.view.View;
import android.widget.PopupWindow;
import android.view.Gravity;

public class BaseActivity extends Activity {
  
  private Button bTabCompany,bTabProduct,bTabActivity,bTabMore,commentManage,subcompanyManage,recruitManage, feedbackManage;
  private PopupWindow popupWindow;
  
  
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  
  protected void initPopuptWindow() {

   View popupWindow_view = getLayoutInflater().inflate(R.layout.pop, null, false);
   
   popupWindow      = new PopupWindow(popupWindow_view, 250, 500, true);
   popupWindow.setBackgroundDrawable(new BitmapDrawable());
   commentManage    = (Button) popupWindow_view.findViewById(R.id.pop_tab_comment);
   subcompanyManage = (Button) popupWindow_view.findViewById(R.id.pop_tab_subcompany);
   recruitManage    = (Button) popupWindow_view.findViewById(R.id.pop_tab_recruit);
   feedbackManage   = (Button) popupWindow_view.findViewById(R.id.pop_tab_feedback);

   feedbackManage.setOnClickListener(new OnClickListener() {
     @Override
     public void onClick(View v) {

     forward(ManageFeedbackActivity.class);
     System.out.println("意见反馈管理操作");

     popupWindow.dismiss();
     }
   });
   
   
   commentManage.setOnClickListener(new OnClickListener() {
     @Override
     public void onClick(View v) {

     forward(ManageCommentActivity.class);
     System.out.println("评论管理操作");

     popupWindow.dismiss();
     }
   });
   
   subcompanyManage.setOnClickListener(new OnClickListener() {
     @Override
     public void onClick(View v) {

     forward(ManageSubCompanyActivity.class);
     System.out.println("分店管理操作");

     popupWindow.dismiss();
     }
   });

   recruitManage.setOnClickListener(new OnClickListener() {
     @Override
     public void onClick(View v) {

     forward(ManageRecruitActivity.class);
     System.out.println("招聘管理操作");

     popupWindow.dismiss();
     }
   });
   
   // 分店管理
   subcompanyManage.setOnClickListener(new OnClickListener() {
     @Override
     public void onClick(View v) {
       
       forward(ManageSubCompanyActivity.class);
       System.out.println("分店管理操作");
       popupWindow.dismiss();
     }
   });
   // 招聘管理
   recruitManage.setOnClickListener(new OnClickListener() {
     @Override
     public void onClick(View v) {
       forward(ManageRecruitActivity.class);
       System.out.println("招聘操作");
       popupWindow.dismiss();
     }
   });

 }
  
  /**** 获取PopupWindow实例  */
  private void getPopupWindow() {

    if (null != popupWindow) {
      popupWindow.dismiss();
      return;
      } else {
      initPopuptWindow();
      }
  }
    
  public void forward (Class<?> classObj) {
    Intent intent = new Intent();
    intent.setClass(this, classObj);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    this.startActivity(intent);
    this.finish();
  }
   
  public void bindMainTab () {
    bTabCompany  = (Button) findViewById(R.id.main_tab_company);
    bTabProduct  = (Button) findViewById(R.id.main_tab_product);
    bTabActivity = (Button) findViewById(R.id.main_tab_activity);
    bTabMore     = (Button) findViewById(R.id.main_tab_more);
    if (bTabCompany != null && bTabProduct != null && bTabActivity != null) {
      OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
          switch (v.getId()) {
            case R.id.main_tab_company:
              forward(ManageCompanyActivity.class);
              break;
            case R.id.main_tab_product:
              forward(ManageProductActivity.class);
              break;
            case R.id.main_tab_activity:
              forward(ManageActivity.class);
              break;
            case R.id.main_tab_more:
              getPopupWindow();
              popupWindow.setFocusable(true);  
              popupWindow.setOutsideTouchable(true);  
              int[] location = new int[2];  
              v.getLocationOnScreen(location);  
              popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1]-popupWindow.getHeight());  
              break;
          }
        }
      };
      bTabCompany.setOnClickListener(mOnClickListener);
      bTabProduct.setOnClickListener(mOnClickListener);
      bTabActivity.setOnClickListener(mOnClickListener);
      bTabMore.setOnClickListener(mOnClickListener);
    }
  }
  
  
}

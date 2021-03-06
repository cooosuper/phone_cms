package cn.phonecms.main.manage.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import cn.phonecms.main.R;
import cn.phonecms.main.SelectPicActivity;
import cn.phonecms.main.R.id;
import cn.phonecms.main.R.layout;
import cn.phonecms.network.UploadUtil;
import cn.phonecms.network.UploadUtil.OnUploadProcessListener;

public class ModifySpecificActivity extends Activity implements OnClickListener,OnUploadProcessListener
{
	private static final String TAG = "uploadImage";
	
	/**
	 * 去上传文件
	 */
	protected static final int TO_UPLOAD_FILE = 1;  
	/**
	 * 上传文件响应
	 */
	protected static final int UPLOAD_FILE_DONE = 2;  //
	/**
	 * 选择文件
	 */
	public static final int TO_SELECT_PHOTO = 3;
	/**
	 * 上传初始化
	 */
	private static final int UPLOAD_INIT_PROCESS = 4;
	/**
	 * 上传中
	 */
	private static final int UPLOAD_IN_PROCESS = 5;

	private static String requestURL = "http://***.***.***.***:8080/***/***";
	private Button selectButton,uploadButton,backActivityBtn, modifyBtn, delActivityBtn;
	private ImageView imageView;
	private TextView uploadImageResult;
	private ProgressBar progressBar;
  private String picPath = null;
  private ProgressDialog progressDialog;
	
  private String activityName, activityStartTime, activityEndTime, activityDesc;
  private EditText appActivityName, appActivityStarttime, appActivityendtime, appActivitydesc;
  private int activityImage;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_specific_activity);
        initView();
        
        backActivityBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
          Toast.makeText(ModifySpecificActivity.this, "**********功", 1).show();
          Intent myIntent = new Intent();
          myIntent = new Intent(ModifySpecificActivity.this, ManageActivity.class);
          startActivity(myIntent);
          ModifySpecificActivity.this.finish();
          }
        });
        
        modifyBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
           Intent mineIntent = new Intent();         
           mineIntent.putExtra("activityName", activityName);
           mineIntent.putExtra("activityStartTime",activityStartTime);
           mineIntent.putExtra("activityEndTime",activityEndTime);
           mineIntent.putExtra("activityDesc",activityDesc);
           mineIntent.putExtra("activityImage",activityImage);   
           mineIntent = new Intent(ModifySpecificActivity.this, ManageActivity.class);
           startActivity(mineIntent);
           ModifySpecificActivity.this.finish();
           Toast.makeText(ModifySpecificActivity.this, "修改活动成功", 1).show();
          }
        });
      
        
        delActivityBtn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
            Intent intent = getIntent();
            String activityId = intent.getStringExtra("ActivityId");
            Intent mineIntent = new Intent();         
            mineIntent.putExtra("activityId", activityId);  
            mineIntent = new Intent(ModifySpecificActivity.this, ManageActivity.class);
            startActivity(mineIntent);
            ModifySpecificActivity.this.finish();
            Toast.makeText(ModifySpecificActivity.this, "删除成功", 1).show();
           }
         });
        

    }
    
    /**
     * 初始化数据
     */
	private void initView() {
        selectButton = (Button) this.findViewById(R.id.app_selectImage_btn);
        uploadButton = (Button) this.findViewById(R.id.app_uploadImage_btn);
        selectButton.setOnClickListener(this);
        uploadButton.setOnClickListener(this);
        modifyBtn = (Button) this.findViewById(R.id.main_top_modify);
        backActivityBtn = (Button) this.findViewById(R.id.main_activity_top_back);
        delActivityBtn = (Button) this.findViewById(R.id.main_top_minus);
        imageView = (ImageView) this.findViewById(R.id.app_image_btn);
        uploadImageResult = (TextView) findViewById(R.id.uploadImageResult);
        progressDialog = new ProgressDialog(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        
        appActivityName = (EditText)findViewById(R.id.app_activity_name);
        appActivityStarttime = (EditText)findViewById(R.id.app_activity_start_time);
        appActivityendtime = (EditText)findViewById(R.id.app_activity_end_time);
        appActivitydesc = (EditText)findViewById(R.id.app_activity_desc);
        
        activityName = appActivityName.getText().toString();
        activityStartTime = appActivityStarttime.getText().toString();
        activityEndTime =  appActivityendtime.getText().toString();
        activityDesc = appActivitydesc.getText().toString();
        activityImage = imageView.getId();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.app_selectImage_btn:
			Intent intent = new Intent(this,SelectPicActivity.class);
			startActivityForResult(intent, TO_SELECT_PHOTO);
			break;
		case R.id.app_uploadImage_btn:
			if(picPath!=null)
			{
				handler.sendEmptyMessage(TO_UPLOAD_FILE);
			}else{
				Toast.makeText(this, "上传的文件路径出错", Toast.LENGTH_LONG).show();
			}
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode==Activity.RESULT_OK && requestCode == TO_SELECT_PHOTO)
		{
			picPath = data.getStringExtra(SelectPicActivity.KEY_PHOTO_PATH);
			Log.i(TAG, "最终选择的图片="+picPath);
			Bitmap bm = BitmapFactory.decodeFile(picPath);
			imageView.setImageBitmap(bm);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	

	/**
	 * 上传服务器响应回调
	 */
	@Override
	public void onUploadDone(int responseCode, String message) {
		progressDialog.dismiss();
		Message msg = Message.obtain();
		msg.what = UPLOAD_FILE_DONE;
		msg.arg1 = responseCode;
		msg.obj = message;
		handler.sendMessage(msg);
	}
	
	private void toUploadFile()
	{
		uploadImageResult.setText("正在上传中...");
		progressDialog.setMessage("正在上传文件...");
		progressDialog.show();
		String fileKey = "pic";
		UploadUtil uploadUtil = UploadUtil.getInstance();;
		uploadUtil.setOnUploadProcessListener(this);  //设置监听器监听上传状态
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("orderId", "11111");
		uploadUtil.uploadFile( picPath,fileKey, requestURL,params);
	}
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case TO_UPLOAD_FILE:
				toUploadFile();
				break;
			
			case UPLOAD_INIT_PROCESS:
				progressBar.setMax(msg.arg1);
				break;
			case UPLOAD_IN_PROCESS:
				progressBar.setProgress(msg.arg1);
				break;
			case UPLOAD_FILE_DONE:
				String result = "响应码："+msg.arg1+"\n响应信息："+msg.obj+"\n耗时："+UploadUtil.getRequestTime()+"秒";
				uploadImageResult.setText(result);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
		
	};

	@Override
	public void onUploadProcess(int uploadSize) {
		Message msg = Message.obtain();
		msg.what = UPLOAD_IN_PROCESS;
		msg.arg1 = uploadSize;
		handler.sendMessage(msg );
	}

	@Override
	public void initUpload(int fileSize) {
		Message msg = Message.obtain();
		msg.what = UPLOAD_INIT_PROCESS;
		msg.arg1 = fileSize;
		handler.sendMessage(msg );
	}
	
}
package com.liuyexuyu.hbpamobile;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

import com.liuyexuyu.data.AppKeys;
import com.liuyexuyu.model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Login extends Activity implements OnClickListener{
	private Button btnLogin;
	private Button btnSignup;
	private EditText etUserName;
	private EditText etPwd;
	private TextView tvResetPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//初始化Bmob SDK
		Bmob.initialize(this, AppKeys.Application);
		setContentView(R.layout.layout_login);
		
		etUserName=(EditText)findViewById(R.id.et_login_username);
		etPwd=(EditText)findViewById(R.id.et_login_pwd);
		tvResetPwd=(TextView)findViewById(R.id.tv_login_resetpwb);
		btnLogin=(Button)findViewById(R.id.btn_login_login);
		btnSignup=(Button)findViewById(R.id.btn_login_signup);
		btnLogin.setOnClickListener(this);
		btnSignup.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login_login:
			login();
			break;
		case R.id.btn_login_signup:
			Intent  toSignup=new Intent(this,Activity_Signup.class);
			startActivity(toSignup);
            break;
		default:
			toast(this,"按钮异常！");
			break;
		}
		
	}

	private void toast(Context context, String string) {
		// TODO Auto-generated method stub
		Toast.makeText(context, string, Toast.LENGTH_LONG).show();
	}

	private void login() {
		final User mUser=new User();
		mUser.setUsername(""+etUserName.getText().toString());
		mUser.setPassword(""+etPwd.getText().toString());
		if (mUser.getUsername()==""||mUser.getPassword()=="") {
			toast(this,"亲，用户名或密码不能为空！");
            return ;
		}
		else {
			User bu2 = new User();
			bu2.setUsername(etUserName.getText().toString());
			bu2.setPassword(etPwd.getText().toString());
			bu2.login(this, new SaveListener() {
				@Override
				public void onSuccess() {
					toast(getApplication(),"亲, 登陆成功！");
					//保存用户信息
					//saveUserInfo(etUserName.getText().toString(), etPwd.getText().toString());
					//跳转到主页
					Intent toHome = new Intent(Activity_Login.this,Activity_MainUI.class);
					startActivity(toHome);
					finish();
				}
				@Override
				public void onFailure(int arg0, String msg) {
					toast(getApplication(),"亲, 用户名或密码错误！");
				}
			});
			
		}
	}

	
}

package com.liuyexuyu.hbpamobile;

import cn.bmob.v3.Bmob;

import com.liuyexuyu.data.AppKeys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


@SuppressLint("HandlerLeak") 
public class Activity_StartPage extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bmob.initialize(this, AppKeys.Application);
		setContentView(R.layout.layout_start);
		mHandler.sendEmptyMessageDelayed(GO_HOME, 3000);
	}		
	public void goHome() {
		Intent intent = new Intent(this, Activity_Login.class);
		startActivity(intent);
		this.finish();
	}

	private static final int GO_HOME = 100;
	
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;
			}
		}
	};

}

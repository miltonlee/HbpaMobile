package com.liuyexuyu.adapter;


import com.liuyexuyu.hbpamobile.Fragment_MainUI_AiShengHuo;
import com.liuyexuyu.hbpamobile.Fragment_MainUI_GeRen;
import com.liuyexuyu.hbpamobile.Fragment_MainUI_ZhangZiShi;
import com.liuyexuyu.hbpamobile.Fragment_MainUI_ZuoXueBa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
	public final static int TAB_COUNT = 4;

	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}
	
	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case 0:
			Fragment_MainUI_ZhangZiShi zhangzhishi = new Fragment_MainUI_ZhangZiShi();
			return zhangzhishi;
		case 1:
			Fragment_MainUI_AiShengHuo aishenghuo = new Fragment_MainUI_AiShengHuo();
			return aishenghuo;
		case 2:
			Fragment_MainUI_ZuoXueBa zuoxueba = new Fragment_MainUI_ZuoXueBa();
			return zuoxueba;
		case 3:
			Fragment_MainUI_GeRen geren = new Fragment_MainUI_GeRen();
			return geren;
		}
		return null;
	}

	@Override
	public int getCount() {
		return TAB_COUNT;
	}

}

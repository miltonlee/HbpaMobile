package com.liuyexuyu.hbpamobile;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity_MainUI extends FragmentActivity implements OnClickListener {
    //定义数据
	private ViewPager mViewPager;
	private TextView mTitle;
	private FragmentPagerAdapter mAdapter;
	private String[] titles=new String[]{"涨姿势","爱生活","做学霸","关于我"};	
	
	private List<Fragment> mFragments;
	private RadioButton mTabZhangzishi;
	private RadioButton mTabAishenghuo;
	private RadioButton mTabZuoxueba;
	private RadioButton mTabGeren;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mainui);		
		initViews();
		mViewPager.setCurrentItem(0);
		//mTabZhangzishi.setTextColor(R.color.mainui_tab_text);
	}
	private void initViews() {
				
		mViewPager=(ViewPager) findViewById(R.id.mainui_mainviewpager);
		
	    mTitle=(TextView) findViewById(R.id.tv_mainui_title);
		mTabZhangzishi=(RadioButton) findViewById(R.id.mainui_tab_zhangzishi);
		mTabAishenghuo=(RadioButton) findViewById(R.id.mainui_tab_aishenghuo);
		mTabZuoxueba=(RadioButton) findViewById(R.id.mainui_tab_zuoxueba);
		mTabGeren=(RadioButton) findViewById(R.id.mainui_tab_geren);
		
		mTabZhangzishi.setOnClickListener(this);
		mTabAishenghuo.setOnClickListener(this);
		mTabZuoxueba.setOnClickListener(this);
		mTabGeren.setOnClickListener(this);
	
		mFragments = new ArrayList<Fragment>();
		Fragment mTab01 = new Fragment_MainUI_ZhangZiShi();
		Fragment mTab02 = new Fragment_MainUI_AiShengHuo();
		Fragment mTab03 = new Fragment_MainUI_ZuoXueBa();
		Fragment mTab04 = new Fragment_MainUI_GeRen();
		mFragments.add(mTab01);
		mFragments.add(mTab02);
		mFragments.add(mTab03);
		mFragments.add(mTab04);
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{

			@Override
			public int getCount()
			{
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0)
			{
				return mFragments.get(arg0);
			}
		};
		mViewPager.setAdapter(mAdapter);
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				setTab(currentItem);
				mTitle.setText(titles[currentItem]);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mainui_tab_zhangzishi:
			mViewPager.setCurrentItem(0);
			mTitle.setText(titles[0]);
			break;
		case R.id.mainui_tab_aishenghuo:
			mViewPager.setCurrentItem(1);
			mTitle.setText(titles[1]);
			break;
		case R.id.mainui_tab_zuoxueba:
			mViewPager.setCurrentItem(2);
			mTitle.setText(titles[2]);
			break;
		case R.id.mainui_tab_geren:
			mViewPager.setCurrentItem(3);
			mTitle.setText(titles[3]);
			break;

		default:
			break;
		}		
		
	}
	
	private void setTab(int currentItem) {
		switch (currentItem) {
		case 0:
			mTabZhangzishi.setChecked(true);
			break;
        case 1:
        	mTabAishenghuo.setChecked(true);
			break;
		case 2:
			mTabZuoxueba.setChecked(true);	
			break;
		case 3:
			mTabGeren.setChecked(true);		
			break;
		default:
			break;
		}
		
	}

}

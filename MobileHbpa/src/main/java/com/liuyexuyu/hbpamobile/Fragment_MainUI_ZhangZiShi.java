package com.liuyexuyu.hbpamobile;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment_MainUI_ZhangZiShi extends Fragment {
	private List<ImageView> imageViewList;
	private ViewPager mViewPager;
	private final int STOP_SCOLL=20;
	private final int START_SCOLL=0;
	//private boolean isLoop = true;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what>=STOP_SCOLL) {
				return;
			}
			mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
			handler.sendMessageDelayed(handler.obtainMessage(msg.what+1), 5000);
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.mainui_tab_zhangzishi, container,
				false);
		initView(view);
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// while (isLoop) {
		// SystemClock.sleep(5000);
		// handler.sendEmptyMessage(0);
		// }
		// }
		// }).start();
	    
		return view;
	}

	private void initView(View view) {
		mViewPager = (ViewPager) view
				.findViewById(R.id.mainui_tabzhangzishi_add);
		initImg();
		mViewPager.setAdapter(new ViewPagerAdapter(imageViewList));
		int n = Integer.MAX_VALUE / 2 % imageViewList.size();
		int itemPosition = Integer.MAX_VALUE / 2 - n;
		mViewPager.setCurrentItem(itemPosition);
	}

	private void initImg() {
		imageViewList=new ArrayList<ImageView>();
		int[] imgIDs = { R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d };		
		for (int i = 0; i < imgIDs.length; i++) {
			ImageView iv = new ImageView(getActivity().getApplicationContext());
			iv.setBackgroundResource(imgIDs[i]);
			imageViewList.add(iv);
		}
	}

	@Override
	public void onPause() {		
		super.onPause();
		handler.sendEmptyMessage(STOP_SCOLL);
	}

	@Override
	public void onStart() {		
		super.onStart();
		for (int i = 0; i <=STOP_SCOLL; i++) {
			handler.removeMessages(i);
		}
		handler.sendMessageDelayed(handler.obtainMessage(0), 4000);
	}

}

class ViewPagerAdapter extends PagerAdapter {  
    private List<ImageView> mImageViewList;  
    public ViewPagerAdapter(List<ImageView> imageViewList) {  
        super();  
        this.mImageViewList = imageViewList;  
    }  
    /** 
     * 该方法将返回所包含的 Item总个数。为了实现一种循环滚动的效果，返回了基本整型的最大值，这样就会创建很多的Item, 
     * 其实这并非是真正的无限循环。 
     */  
    @Override  
    public int getCount() {  
        return Integer.MAX_VALUE;  
    }  
         /** 
     * 判断出去的view是否等于进来的view 如果为true直接复用 
     */  
    @Override  
    public boolean isViewFromObject(View arg0, Object arg1) {  
        return arg0 == arg1;  
    }  
    /** 
     * 销毁预加载以外的view对象, 会把需要销毁的对象的索引位置传进来，就是position， 
     * 因为mImageViewList只有四条数据，而position将会取到很大的值， 
     * 所以使用取余数的方法来获取每一条数据项。 
     */  
    @Override  
    public void destroyItem(ViewGroup container, int position, Object object) {  
        container.removeView(mImageViewList.get(position % mImageViewList.size()));  
    }  
    /** 
     * 创建一个view， 
     */  
    @Override  
    public Object instantiateItem(ViewGroup container, int position) {  
        container.addView(mImageViewList.get(position % mImageViewList.size()));  
        return mImageViewList.get(position % mImageViewList.size());  
    }
}  


package com.example.frameanimationguide;

import java.util.ArrayList;
import java.util.List;

import com.example.frameanimationdemo.R;
import com.example.sidebar.adapter.BaseFragmentAdapter;
import com.example.sidebar.fragment.LauncherBaseFragment;
import com.example.sidebar.fragment.PictureSharingLauncherFragment;
import com.example.sidebar.fragment.WordSharingLauncherFragment;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GuideActivity extends FragmentActivity {
	private ViewPager vPager;
	private List<LauncherBaseFragment> list = new ArrayList<LauncherBaseFragment>();
	private BaseFragmentAdapter adapter;

	private ImageView[] tips;
	private int currentSelect; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//初始化点点点控件
//		ViewGroup group = (ViewGroup)findViewById(R.id.viewGroup);
//		tips = new ImageView[3];
//		for (int i = 0; i < tips.length; i++) {
//			ImageView imageView = new ImageView(this);
//			imageView.setLayoutParams(new LayoutParams(10, 10));
//			if (i == 0) {
//				imageView.setBackgroundResource(R.drawable.page_indicator_focused);
//			} else {
//				imageView.setBackgroundResource(R.drawable.page_indicator_unfocused);
//			}
//			tips[i]=imageView;
//
//			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
//			layoutParams.leftMargin = 20;//设置点点点view的左边距
//			layoutParams.rightMargin = 20;//设置点点点view的右边距
//			group.addView(imageView,layoutParams);
//		}
		
		//获取viewpager
		vPager = (ViewPager) findViewById(R.id.viewpager_launcher);
		/**
		 * 初始化fragment  并且添加到list中
		 */
		PictureSharingLauncherFragment pictureFragment = new PictureSharingLauncherFragment();
		WordSharingLauncherFragment wordFragment = new WordSharingLauncherFragment();
		list.add(pictureFragment);
		list.add(wordFragment);

		adapter = new BaseFragmentAdapter(getSupportFragmentManager(),list);
		vPager.setAdapter(adapter);
		vPager.setOffscreenPageLimit(2);
		vPager.setCurrentItem(0);
		vPager.setOnPageChangeListener(changeListener);
	}
	
	/**
	 * 监听viewpager的移动
	 */
	OnPageChangeListener changeListener=new OnPageChangeListener() {
		@Override
		public void onPageSelected(int index) {
//			setImageBackground(index);//改变点点点的切换效果
			LauncherBaseFragment fragment=list.get(index);
			list.get(currentSelect).stopAnimation();//停止前一个页面的动画
			fragment.startAnimation();//开启当前页面的动画
			currentSelect=index;
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}
		@Override
		public void onPageScrollStateChanged(int arg0) {}
	};
	
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		list.get(0).startAnimation();
	}
	/**
	 * 改变点点点的切换效果
	 * @param selectItems
	 */
//	private void setImageBackground(int selectItems) {
//		for (int i = 0; i < tips.length; i++) {
//			if (i == selectItems) {
//				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
//			} else {
//				tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
//			}
//		}
//	}
}

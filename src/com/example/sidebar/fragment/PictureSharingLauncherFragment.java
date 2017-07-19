package com.example.sidebar.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.frameanimationdemo.R;

/**
 * 图片分享
 * @author pengtg
 */
public class PictureSharingLauncherFragment extends LauncherBaseFragment{
	private ImageView ivPicture;
	private AnimationDrawable animationDrawable;
	private boolean started;//是否开启动画
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rooView=inflater.inflate(R.layout.fragment_picture_shareing_luncher, null);
		ivPicture=(ImageView) rooView.findViewById(R.id.animationIV);
		ivPicture.setImageResource(R.drawable.animation1);
		animationDrawable = (AnimationDrawable) ivPicture.getDrawable();
		return rooView;
	}
	
	public void stopAnimation(){
		//动画开启标示符设置成false   
		started=false;
		animationDrawable.stop();
	}
	
	
	public void startAnimation(){
		started=true;
		new Handler().postDelayed(new Runnable() {//延时0.5秒之后开启动画
			@Override
			public void run(){
				if(started)
					animationDrawable.start();
			}
		},500);
	}
}

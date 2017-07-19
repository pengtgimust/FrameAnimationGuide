package com.example.sidebar.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.frameanimationdemo.R;

/**
 * 图片分享
 * @author pengtg
 */
public class WordSharingLauncherFragment extends LauncherBaseFragment{
	private ImageView ivWord,ivExperience;
	private AnimationDrawable animationDrawable;
	private boolean started;//是否开启动画
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rooView=inflater.inflate(R.layout.fragment_word_shareing_luncher, null);
		ivWord=(ImageView) rooView.findViewById(R.id.animationIV2);
		ivExperience=(ImageView) rooView.findViewById(R.id.imgView_immediate_experience);
		ivExperience.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getContext(), "开始使用", Toast.LENGTH_SHORT).show();
			}
		});
		ivWord.setImageResource(R.drawable.animation2);
		animationDrawable = (AnimationDrawable) ivWord.getDrawable();
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
		},10);
	}
}

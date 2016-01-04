package com.laohuai.appdemo.customui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MyMainActivity extends Activity {

	private FragmentManager fragManager ;
	private FragmentTransaction fragTran;
	private Fragment frag1 ;
	
	private Fragment frag2 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m_main);
		fragManager = getFragmentManager();
		frag1 = new FragmentOne();
		frag2 = new FragmentTwo();
		repleaceFragment(frag2);
	}
	
	//�л�Fragment
	private void repleaceFragment(Fragment fragment){
		fragTran = fragManager.beginTransaction();
		fragTran.replace(R.id.layout, fragment);
		fragTran.commit();
	}
}

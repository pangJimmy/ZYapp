package com.laohuai.appdemo.customui;

import java.util.ArrayList;

import com.jingchen.pulltorefresh.PullToRefreshLayout;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentTwo extends Fragment {
	
	private Context context ;
	private View rootView ;
	private ListView listView;
	private PullToRefreshLayout ptrl;//����
	@Override
	public void onCreate(Bundle savedInstanceState) {
		context = getActivity();
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_two, null);
		ptrl = (PullToRefreshLayout) rootView.findViewById(R.id.refresh_view);
		ptrl.setOnPullListener(new PullToRefreshLayout.OnPullListener() {
			
			public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
				new AsyncTask<Void, Void, Void>(){

					@Override
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						listaa.add("33333");
						return null;
					}
					
					protected void onPostExecute(Void result) {
						ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
					};
					
				}.execute();
			}
			
			public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
				new Handler().post(new Runnable() {
					
					public void run() {
						ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
						
					}
				});
				
			}
		});
		listView = (ListView) ptrl.getPullableView();
		initList();
		return rootView;
	}

	ArrayList<String>  listaa = new ArrayList<String>();
	ArrayAdapter<String> adapter ;
	private void initList() {
//		listaa.add("aa");
		adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listaa);
		listView.setAdapter(adapter);
	}
}

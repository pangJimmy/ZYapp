package com.laohuai.appdemo.customui;

import java.util.ArrayList;

import com.laohuai.appdemo.customui.ui.MyListView;
import com.laohuai.appdemo.customui.ui.MyListView.OnRefreshListener;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentOne extends Fragment {

	private Context context ;
	private View rootView ;
	
	private MyListView mList ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		context = getActivity();
		super.onCreate(savedInstanceState);
	}
	
	ArrayAdapter<String> adapter;
	ArrayList<String> listaa;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_one, null);
		listaa = new ArrayList<String>();
		listaa.add("111");
		adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listaa);
		mList = (MyListView) rootView.findViewById(R.id.listView_1);
		mList.setAdapter(adapter);
		mList.setonRefreshListener(new OnRefreshListener() {
			
			public void onRefresh() {
				new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						listaa.add("aa");
						return null;
					}
					
					@Override
					protected void onPostExecute(Void result) {
						adapter.notifyDataSetChanged();
						mList.onRefreshComplete();
					}
					
				}.execute();
				
			}
		});
		return rootView;
	}
}

package com.laohuai.appdemo.customui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	List<String> items;
	Context context;

	public MyAdapter(Context context, List<String> items) {
		this.context = context;
		this.items = items;
	}

	public int getCount() {
		return items.size();
	}

	public Object getItem(int position) {
		return items.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(
				R.layout.list_item_layout, null);
		TextView tv = (TextView) view.findViewById(R.id.tv);
		tv.setText(items.get(position));
		return view;
	}

}

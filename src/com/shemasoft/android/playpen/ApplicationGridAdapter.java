package com.shemasoft.android.playpen;

import java.util.List;

import com.shemasoft.android.playpen.R.id;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ApplicationGridAdapter extends BaseAdapter {

	private Context context;
	private List<ApplicationInfo> packages;

	public ApplicationGridAdapter(Context context) {
		this.context = context;
		packages = context.getPackageManager().getInstalledApplications(
				PackageManager.GET_META_DATA);

	}

	public int getCount() {
		return packages.size();
	}

	public Object getItem(int position) {
		return packages.get(position);
	}

	public long getItemId(int position) {
		return packages.get(position).uid;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {

		ApplicationInfo currentItem = packages.get(position);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.application_cell, null);


		} else {
			gridView = (View) convertView;
		}
		// set value into textview
		TextView textView = (TextView) gridView
				.findViewById(R.id.grid_app_label);
		// TODO: research better item
		textView.setText(currentItem.nonLocalizedLabel);

		// set image based on selected text
		ImageView imageView = (ImageView) gridView
				.findViewById(R.id.grid_app_icon);
		imageView.setImageDrawable(currentItem.loadIcon(context.getPackageManager()));


		return gridView;
	}
}

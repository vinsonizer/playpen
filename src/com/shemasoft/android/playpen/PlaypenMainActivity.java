package com.shemasoft.android.playpen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

public class PlaypenMainActivity extends Activity {

	private static final String TAG = "PlaypenMainActivity";
	private GridView appGridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_playpen_main);

		appGridView = (GridView) findViewById(R.id.app_grid);
		appGridView.setAdapter(new ApplicationGridAdapter(this));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.playpen_main, menu);
		return true;
	}

}

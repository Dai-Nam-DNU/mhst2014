package edu.dnu.androidopac;

import edu.dnu.androidopac.MainActivity;
import edu.dnu.androidopac.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import edu.dnu.androidopac.log.LogConfig;
import edu.dnu.androidopac.search.SearchFormActivity;

public class MainActivity extends Activity {
	static final String TAG = LogConfig.getLogTag(MainActivity.class);
	// whether DEBUG level logging is enabled (whether globally, or explicitly
	// for this log tag)
	static final boolean DEBUG = LogConfig.isDebug(TAG);
	// whether VERBOSE level logging is enabled
	static final boolean VERBOSE = LogConfig.VERBOSE;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnSearch=(Button)findViewById(R.id.btnSearch);
		btnSearch.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				Intent myIntent=new Intent(MainActivity.this, SearchFormActivity.class);
				startActivity(myIntent);
			}
		});
		Button btnCredits =(Button) findViewById(R.id.btnCredits);
		btnCredits.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Credits.class);
				MainActivity.this.startActivity(intent);
			}
		})   ; 
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		boolean result = super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, Constants.PREFERENCES, 1, R.string.menu_preferences).setIcon(android.R.drawable.ic_menu_preferences);
		//getMenuInflater().inflate(R.menu.activity_main, menu);
		return result;		
	}
	public boolean onSearchRequested() {
		startActivity(new Intent(this, SearchFormActivity.class));
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case Constants.SEARCH:
			startActivity(new Intent(this, SearchFormActivity.class));
			break;
		case Constants.PREFERENCES:
			startActivity(new Intent(this, EditPreferences.class));
			break;		
		}
		return true;
	}
	
}
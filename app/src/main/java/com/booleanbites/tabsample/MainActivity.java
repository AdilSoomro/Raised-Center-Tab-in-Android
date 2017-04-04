package com.booleanbites.tabsample;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.booleanbites.tabsample.fragments.HomeFragment;
import com.booleanbites.tabsample.fragments.SearchFragment;
import com.booleanbites.tabsample.legacy.AwesomeActivity;
import com.booleanbites.tabsample.legacy.CameraActivity;
import com.booleanbites.tabsample.legacy.HomeActivity;


/**
 * @author Adil Soomro | http://BooleanBites.com
 * @version 1.2
 *
 * This is `MainActivity`, it contain a `ViewPager` and `TabLayout`. The trick here is to move the
 * tab layout to bottom, and then add 5 Fragments to the ViewPager and 5 icons to tab layout.
 * The center tab ie 3rd tab will serve a fake fragment, it can be empty. We've a button on top of
 * `TabLayout` aligned center and the bottom.
 * That's button which will serve as raised center button.
 *          ____
 * ________|   |________
 * | 1 | 2 | C | 4 | 5 |
 * ---------------------
 *
 * 1, 2, 4, 5 are TabLayout component.
 * C is an ImageButton placed on top of TabLayout aligned center and bottom.
 * Keep in mind, there's a 3rd TabLayout compnent, which is hidden under the C button.
 *
 */
public class MainActivity extends AppCompatActivity {
	/** Called when the activity is first created. */
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int[] icons = {
				R.drawable.tab_home,
				R.drawable.tab_search,

				//fake center fragment, so that it creates place for raised center tab.
				R.drawable.tab_search,

				R.drawable.tab_home,
				R.drawable.tab_search
		};
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		ViewPager viewPager = (ViewPager) findViewById(R.id.main_tab_content);

		setupViewPager(viewPager);


		tabLayout.setupWithViewPager(viewPager);

		for (int i = 0; i < icons.length; i++) {
			tabLayout.getTabAt(i).setIcon(icons[i]);
		}
		tabLayout.getTabAt(0).select();
	}

	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

		adapter.insertNewFragment(new HomeFragment());
		adapter.insertNewFragment(new SearchFragment());

		//fake center fragment, so that it creates place for raised center tab.
		adapter.insertNewFragment(new SearchFragment());

		adapter.insertNewFragment(new HomeFragment());
		adapter.insertNewFragment(new SearchFragment());
		viewPager.setAdapter(adapter);
	}

	class ViewPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragmentList = new ArrayList<>();
		public ViewPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		public void insertNewFragment(Fragment fragment) {
			mFragmentList.add(fragment);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.main_activity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

			case R.id.action_settings:
				Intent settingsIntent = new Intent(this, AwesomeActivity.class);
				startActivity(settingsIntent);
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	public void openCameraActivity(View b)
	{
		Intent intent = new Intent(this, CameraActivity.class);
		startActivity(intent);
	}

}
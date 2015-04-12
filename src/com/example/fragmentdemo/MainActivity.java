package com.example.fragmentdemo;

import com.example.fragmentdemo.FragmentOne.FOnBtnClickListener;
import com.example.fragmentdemo.FragmentThree.FThreeBtnClickListener;
import com.example.fragmentdemo.FragmentTwo.FTwoBtnClickListener;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity implements FOnBtnClickListener,
		FTwoBtnClickListener, FThreeBtnClickListener {

	private FragmentOne mFragmentOne;
	private FragmentTwo mFragmentTwo;
	private FragmentThree mFragmentThree;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			mFragmentOne = new FragmentOne();
			FragmentManager fm = getFragmentManager();
			FragmentTransaction tx = fm.beginTransaction();
			tx.add(R.id.id_content, mFragmentOne, "one");
			tx.commit();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onFOneBtnClick() {
		if (mFragmentTwo == null) {
			mFragmentTwo = new FragmentTwo();
			mFragmentTwo.setTwoBtnClickListener(this);
		}
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		tx.replace(R.id.id_content, mFragmentTwo, "Two");
		tx.addToBackStack(null);
		tx.commit();
	}

	@Override
	public void onFTwoBtnClick() {
		if (mFragmentThree == null) {
			mFragmentThree = new FragmentThree();
			mFragmentThree.setFThreeBtnClickListener(this);

		}
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		tx.replace(R.id.id_content, mFragmentThree, "Three");
		tx.addToBackStack(null);
		tx.commit();

	}

	@Override
	public void onThreeClick() {
		Toast.makeText(this, "回调弹出第三个碎片", Toast.LENGTH_LONG).show();
	}

}

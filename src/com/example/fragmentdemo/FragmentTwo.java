package com.example.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTwo extends Fragment implements OnClickListener {
	/**
	 * 第二个碎片
	 */

	private Button btn;

	public interface FTwoBtnClickListener {
		void onFTwoBtnClick();
	}

	private FTwoBtnClickListener btnClickListener;

	public void setTwoBtnClickListener(FTwoBtnClickListener btnClickListener) {
		this.btnClickListener = btnClickListener;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_two, container, false);
		btn = (Button) view.findViewById(R.id.btn2);
		btn.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		if (btnClickListener != null) {
			btnClickListener.onFTwoBtnClick();
		}

		// FragmentThree fThree = new FragmentThree();
		//
		// FragmentManager fm = getFragmentManager();
		// FragmentTransaction tx = fm.beginTransaction();
		// tx.hide(this);
		// tx.add(R.id.id_content, fThree, "Three");
		// //tx.replace(R.id.id_content, fThree, "Three"); 先移除，再增加
		// tx.addToBackStack(null);
		// tx.commit();

	}

}

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

public class FragmentFour extends Fragment implements OnClickListener {



	private Button btn;

	/**
	 *设置按钮点击的回调
	 *第一个碎片
	 *
	 */
	public interface FOnBtnClickListener{
		void onFOneBtnClick();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_one, container,false);
		btn = (Button) view.findViewById(R.id.btn1);
		btn.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		if (getActivity() instanceof FOnBtnClickListener) {
			((FOnBtnClickListener)getActivity()).onFOneBtnClick();
		}
//		FragmentTwo fTwo = new FragmentTwo();
//		FragmentManager fm = getFragmentManager();
//		FragmentTransaction tx = fm.beginTransaction();
//		tx.replace(R.id.id_content, fTwo, "Two");
//		tx.addToBackStack(null);//将当前事物添加到回退栈（FragmentOne）
//		tx.commit();
	}

}

package com.example.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentThree extends Fragment implements OnClickListener {

	private Button btn;

	public interface FThreeBtnClickListener {
		void onThreeClick();
	}

	private FThreeBtnClickListener btnClickListener;

	public void setFThreeBtnClickListener(
			FThreeBtnClickListener btnClickListener) {
		this.btnClickListener = btnClickListener;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_three, container, false);
		btn = (Button) view.findViewById(R.id.btn3);
		btn.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {

		if (btnClickListener != null) {
			btnClickListener.onThreeClick();
		}

	}

}

package com.albert.ifttt;

import com.albert.ifttt.service.MainService;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
	private Button startButton = null;
	private Button stopButton = null;
	private Intent intent = null;

	 

	public PlaceholderFragment(Intent intent) {
		// TODO Auto-generated constructor stub
		this.intent = intent;
//		getActivity().startService(intent);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		startButton = (Button) rootView.findViewById(R.id.bt_start);
		stopButton = (Button) rootView.findViewById(R.id.bt_stop);
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				getActivity().startService(intent);
			}
		});

		// set stop service button click listener
		stopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				getActivity().stopService(intent);
			}
		});
		return rootView;
	}
}
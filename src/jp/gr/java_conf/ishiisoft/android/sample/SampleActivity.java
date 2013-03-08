package jp.gr.java_conf.ishiisoft.android.sample;

import jp.gr.java_conf.ishiisoft.android.widget.CountupTimer;
import jp.gr.java_conf.ishiisoft.android.widget.SwipeSelector;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * sample activity
 * MIT Licensed.
 * 
 * @author ishiisoft
 */
public class SampleActivity extends Activity {
	// swipe selector items
	private final String[] SS_TEXT = {"0.swipe left", "1.swipe left or right", "2.swipe right"};
	/**
	 * onCreate
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//
		// use swipe selector
		//
		final SwipeSelector ss = (SwipeSelector)findViewById(R.id.swipeSelector);
		// set attrubute
		ss.setText(SS_TEXT);
		ss.setGravity(Gravity.CENTER);
		ss.setTextColor(Color.WHITE);
		ss.setTextSize(15.0f);
		ss.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));

		// getCurrentItem
		Button swipeBtn = (Button)findViewById(R.id.swipeBtn);
		swipeBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				makeToast(Integer.toString(ss.getCurrentItem()));
			}
		});

		//
		// use countup timer
		//
		final CountupTimer countupTimer = (CountupTimer)findViewById(R.id.countupTimer);

		// timer start/stop
		final Button timerBtn1 = (Button)findViewById(R.id.timerBtn1);
		timerBtn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("start".equals(timerBtn1.getText())) {
					timerBtn1.setText("stop");
					countupTimer.start();
				} else {
					timerBtn1.setText("start");
					countupTimer.stop();
				}
			}
		});

		// getMillisecText
		Button timerBtn2 = (Button)findViewById(R.id.timerBtn2);
		timerBtn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				makeToast(countupTimer.getMillisecText());
			}
		});

		// getMillisec
		Button timerBtn3 = (Button)findViewById(R.id.timerBtn3);
		timerBtn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				makeToast(Long.toString(countupTimer.getMillisec()));
			}
		});

		// restart
		Button timerBtn4 = (Button)findViewById(R.id.timerBtn4);
		timerBtn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("stop".equals(timerBtn1.getText())) {
					return;
				}
				timerBtn1.setText("stop");
				
				countupTimer.restart();
			}
		});
	}

	/**
	 * make toast
	 * @param str
	 */
	private void makeToast(String str) {
		Toast.makeText(SampleActivity.this, str, Toast.LENGTH_LONG).show();
	}
}

package jp.gr.java_conf.ishiisoft.android.widget;

import java.text.DecimalFormat;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * CountupTimer class
 * countup timer with millisecond views TextView
 * MIT Licensed.
 * 
 * @author ishiisoft
 */
public class CountupTimer extends TextView {
	/** handler */
	private CountupTimerHandler handler = new CountupTimerHandler();
	/** start time */
	private long start;
	/** end time */
	private long end;
	/** second decimal format */
	private DecimalFormat secDf = new DecimalFormat("0");
	/** second and millisecond separator */
	private String separator = ".";
	
	/**
	 * constructor
	 * @param context
	 */
	public CountupTimer(Context context) {
		super(context);
		init();
	}
	
	/**
	 * constructor
	 * @param context
	 * @param attrs
	 */
	public CountupTimer(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	/**
	 * initialize
	 */
	public void init() {
		// set zero
		StringBuilder sb = new StringBuilder();
		sb.append(secDf.format(0));
		sb.append(separator);
		sb.append(0);
		this.setText(sb.toString());
	}
	
	/**
	 * timer start
	 */
	public void start() {
		start = System.currentTimeMillis();
		handler.start();
	}
	
	public void restart() {
		start = System.currentTimeMillis() - end + start;
		handler.start();
	}
	
	/**
	 * timer stop
	 */
	public void stop() {
		end = System.currentTimeMillis();
		handler.stop();
	}
	
	/**
	 * timer update
	 */
	public void update() {
		end = System.currentTimeMillis();
		long time = end - start;
		StringBuilder sb = new StringBuilder();
		sb.append(secDf.format(time / 1000));
		sb.append(separator);
		sb.append(time % 1000 / 100);
		this.setText(sb.toString());
	}
	
	/**
	 * get timer text
	 * @return timer text
	 */
	public String getMillisecText() {
		return getText().toString();
	}
	
	/**
	 * get timer millisecond
	 * @return timer millisecond
	 */
	public long getMillisec() {
		return end - start;
	}
	
	/**
	 * set millisecond decimalformat
	 * @param secDf
	 */
	public void setSecFormat(DecimalFormat secDf) {
		this.secDf = secDf;
	}
	
	/**
	 * set second and millisecond separator
	 * @param separator
	 */
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	/**
	 * CountupTimerHandler class
	 *
	 */
	private class CountupTimerHandler extends Handler {
		/** is update */
		private boolean isUpdate = false;
		
		/**
		 * start
		 */
		public void start() {
			isUpdate = true;
			handleMessage(new Message());
		}
		
		/**
		 * stop
		 */
		public void stop() {
			isUpdate = false;
		}
		
		/**
		 * handle message
		 * @param msg
		 */
		@Override
		public void handleMessage(Message msg) {
			this.removeMessages(0);
			if (isUpdate) {
				CountupTimer.this.update();
				sendMessageDelayed(obtainMessage(0), 100);
			}
		}
	}
}

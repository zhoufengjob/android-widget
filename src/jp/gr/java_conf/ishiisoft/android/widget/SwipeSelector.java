package jp.gr.java_conf.ishiisoft.android.widget;

import jp.gr.java_conf.ishiisoft.android.adapter.SwipeSelectorAdapter;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * SwipeSelector class
 * select item with swipe
 * MIT Licensed.
 * 
 * @author ishiisoft
 */
public class SwipeSelector extends LinearLayout {
	/** adapter */
	private SwipeSelectorAdapter adapter = null;
	/** view pager */
	private ViewPager viewPager = null;
	/** left text view */
	private TextView leftTv = null;
	/** right text view */
	private TextView rightTv = null;
	
	/**
	 * constructor
	 * @param context
	 */
	public SwipeSelector(Context context) {
		super(context);
		
		// widget
		leftTv = new TextView(context);
		viewPager = new ViewPager(context);
		rightTv = new TextView(context);
		
		// initalize
		init(context);
	}
	
	/**
	 * constructor
	 * @param context
	 * @param attrs
	 */
	public SwipeSelector(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		// set widget
		leftTv = new TextView(context, attrs);
		viewPager = new ViewPager(context, attrs);
		rightTv = new TextView(context, attrs);
		
		init(context);
	}

	/**
	 * init 
	 * @param context
	 */
	private void init(Context context) {
		// set horizontal
		setOrientation(HORIZONTAL);
		
		// create left text view
		LayoutParams leftLp = new LayoutParams(0, LayoutParams.WRAP_CONTENT);
		leftLp.gravity = Gravity.CENTER;
		leftLp.weight = 1;
		leftTv.setGravity(Gravity.CENTER);
		leftTv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int pos = viewPager.getCurrentItem();
				if (pos > 0) {
					viewPager.setCurrentItem(pos - 1);
				}
			}
		});
		
		// create right text view
		LayoutParams rightLp = new LayoutParams(0, LayoutParams.WRAP_CONTENT);
		rightLp.gravity = Gravity.CENTER;
		rightLp.weight = 1;
		rightTv.setGravity(Gravity.CENTER);
		rightTv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int pos = viewPager.getCurrentItem();
				if (pos < adapter.getCount()) {
					viewPager.setCurrentItem(pos + 1);
				}
			}
		});
		
		// set center text
		LayoutParams centerLp = new LayoutParams(0, LayoutParams.WRAP_CONTENT);
		centerLp.weight = 8;
	
		// add left text view
		addView(leftTv, leftLp);
		
		// add center view pager
		adapter = new SwipeSelectorAdapter(context, leftTv, viewPager, rightTv);
		viewPager.setAdapter(adapter);
		addView(viewPager, centerLp);
		
		// set right text view
		addView(rightTv, rightLp);
	}
	
	/**
	 * set text
	 * @param textList
	 */
	public void setText(String[] textList) {
		adapter.setText(textList);
	}
	
	/**
	 * get current item
	 * @return selected item index
	 */
	public int getCurrentItem() {
		return viewPager.getCurrentItem();
	}
	
	/**
	 * get view pager
	 * @return view pager
	 */
	public ViewPager getViewPager() {
		return viewPager;
	}
	
	/**
	 * get left text view
	 * @return text view
	 */
	public TextView getLeftTextView() {
		return leftTv;
	}
	
	/**
	 * set right text view
	 * @return text view
	 */
	public TextView getRightTextView() {
		return rightTv;
	}
	
	/**
	 * set left arrow
	 * @param arrow
	 */
	public void setLeftArrow(String arrow) {
		adapter.setLeftArrow(arrow);
	}
	
	/**
	 * set right arrow
	 * @param arrow
	 */
	public void setRightArrow(String arrow) {
		adapter.setRightArrow(arrow);
	}
	
	/**
	 * setGravity
	 * @param graivty
	 */
	public void setGravity(int gravity) {
		adapter.setGravity(gravity);
	}
	
	/**
	 * setColor
	 * @param color
	 */
	public void setTextColor(int color) {
		adapter.setTextColor(color);
		leftTv.setTextColor(color);
		rightTv.setTextColor(color);
	}
	
	/**
	 * setTextSize
	 * @param size
	 */
	public void setTextSize(float size) {
		adapter.setTextSize(size);
		leftTv.setTextSize(size);
		rightTv.setTextSize(size);
	}
	
	/**
	 * setTypeFace
	 * @param typeface
	 */
	public void setTypeface(Typeface typeface) {
		adapter.setTypeface(typeface);
		leftTv.setTypeface(typeface);
		rightTv.setTypeface(typeface);
	}
}

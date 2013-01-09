package jp.gr.java_conf.ishiisoft.android.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * swipe selector adapter class
 * uses SwipeSelector class
 * 
 * @author ishiisoft
 */
public class SwipeSelectorAdapter extends PagerAdapter {
	/** context */
	private Context context = null;
	/** left text view */
	private TextView leftTv = null;
	/** center view pager */
	private ViewPager centerVp = null;
	/** right text view */
	private TextView rightTv = null;
	/** text list */
	private String[] textList = null;
	/** right arrow */
	private String rightArrow = ">";
	/** left arrow */
	private String leftArrow = "<";
	/** gravity */
	private int gravity = -1;
	/** color */
	private int color = 0;
	/** size */
	private float size = -1.0f;
	/** Typeface */
	private Typeface typeface = null;
	
	/**
	 * constructor
	 * @param context
	 * @param left
	 * @param center
	 * @param right
	 */
	public SwipeSelectorAdapter(Context context, TextView left, ViewPager center, TextView right) {
		this.context = context;
		this.leftTv = left;
		this.rightTv = right;
		this.centerVp = center;
	}
	
	/**
	 * create page
	 * @param container
	 * @param position
	 */
   	@Override
   	public Object instantiateItem(ViewGroup container, int position) {
		// center text
		TextView centerText = new TextView(context);
		centerText.setText(textList[position]);
		centerText.setWidth(10);
		if (gravity >= 0) centerText.setGravity(gravity);
		if (color < 0) centerText.setTextColor(color);
		if (size >= 0) centerText.setTextSize(size);
		if (typeface != null) centerText.setTypeface(typeface);
		centerVp.addView(centerText, 0);
		
		return centerText;
	}
   	
   	/**
   	 * set text
   	 * @param textList
   	 */
   	public void setText(String[] textList) {
   		this.textList = textList;
   	}

   	/**
   	 * destroy item
   	 * @param container
   	 * @param position
   	 * @param object
   	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager)container).removeView((View)object);
	}
 
	/**
	 * get count
	 */
	@Override
	public int getCount() {
    	return textList.length;
	}
 
	/**
	 * is view from object
	 * @param view
	 * @param object
	 */
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}
	
	/**
	 * finish update
	 * called on swipe
	 * @param arg0
	 */
	@Override
	public void finishUpdate(View arg0) {
		int position = centerVp.getCurrentItem();
   		// set left text
   		String text = position == 0 ? "" : leftArrow;
   		leftTv.setText(text);
   			
		// set right text
		text = position + 1 == this.getCount() ? "" : rightArrow;
		rightTv.setText(text);
	}
	
	/**
	 * set left arrow
	 * @param arrow
	 */
	public void setLeftArrow(String arrow) {
		leftArrow = arrow;
	}
	
	/**
	 * set right arrow
	 * @param arrow
	 */
	public void setRightArrow(String arrow) {
		rightArrow = arrow;
	}

	/**
	 * setGravity
	 * @param gravity
	 */
	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	/**
	 * setColor
	 * @param color
	 */
	public void setTextColor(int color) {
		this.color = color;
	}

	/**
	 * setSize
	 * @param size
	 */
	public void setTextSize(float size) {
		this.size = size;
	}

	/**
	 * setTypeface
	 * @param typeface
	 */
	public void setTypeface(Typeface typeface) {
		this.typeface = typeface;
	}
}

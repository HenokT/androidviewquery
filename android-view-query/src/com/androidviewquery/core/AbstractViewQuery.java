package com.androidviewquery.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * This is the base class for all view query classes that provide a fluent api
 * for operating a given view
 *
 * @param <V>
 * @param <Q>
 */
public abstract class AbstractViewQuery<V extends View, Q extends AbstractViewQuery<V, Q>> {
	private V view;

	public AbstractViewQuery(V view) {
		this.view = view;
	}

	public V getView() {
		return view;
	}

	public Context getContext() {
		return getView().getContext();
	}

	@SuppressWarnings("unchecked")
	protected Q self() {
		return (Q) this;
	}

	public Q background(int color) {
		getView().setBackgroundColor(color);
		return self();
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@SuppressWarnings("deprecation")
	public Q background(Drawable drawable) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			getView().setBackground(drawable);
		} else {
			getView().setBackgroundDrawable(drawable);
		}
		return self();
	}

	public Q backgroundRes(int resId) {
		getView().setBackgroundResource(resId);
		return self();
	}

	/**
	 * Sets the opacity of the view. Value must be between 0 and 1. Method has
	 * no effect if API level is < 11
	 * 
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public Q alpha(float alpha) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getView().setAlpha(alpha);
		}
		return self();
	}

	public Q enabled(boolean enabled) {
		getView().setEnabled(enabled);
		return self();
	}

	/**
	 * Sets the visibility state of this view
	 * 
	 * @param visibility
	 *            One of VISIBLE, INVISIBLE, or GONE.
	 * @return
	 */
	public Q visibility(int visibility) {
		getView().setVisibility(visibility);
		return self();
	}

	/**
	 * Sets the visibility state of this view if the specified condition is true
	 * 
	 * @param visibility
	 *            One of {@link View#VISIBLE}, {@link View#INVISIBLE}, or
	 *            {@link View#GONE}.
	 * @param condition
	 * @return
	 */
	public Q visibilityIf(int visibility, boolean condition) {
		if (condition) {
			visibility(visibility);
		}
		return self();
	}

	/**
	 * Same as {@link #visibilityIf(View.VISIBLE, boolean)}
	 * 
	 * @param condition
	 * @return
	 */
	public Q visibleIf(boolean condition) {
		return visibilityIf(View.VISIBLE, condition);
	}

	/**
	 * Same as {@link #visibilityIf(View.INVISIBLE, boolean)}
	 * 
	 * @param condition
	 * @return
	 */
	public Q invisibleIf(boolean condition) {
		return visibilityIf(View.INVISIBLE, condition);
	}

	/**
	 * Same as {@link #visibilityIf(View.GONE, boolean)}
	 * 
	 * @param condition
	 * @return
	 */
	public Q goneIf(boolean condition) {
		return visibilityIf(View.GONE, condition);
	}

	public boolean isVisibility(int visiblity) {
		return getView().getVisibility() == visiblity;
	}

	public boolean isVisible() {
		return isVisibility(View.VISIBLE);
	}

	public boolean isInvisible() {
		return isVisibility(View.INVISIBLE);
	}

	public boolean isGone() {
		return isVisibility(View.GONE);
	}

	private Q sizePixels(int width, int height, boolean setWidth,
			boolean setHeight) {
		LayoutParams lp = getView().getLayoutParams();
		if (setWidth) {
			lp.width = width;
		}
		if (setHeight) {
			lp.height = height;
		}
		if (setWidth || setHeight) {
			// no need to set reset LayoutParams if neither width nor
			// height is changed
			getView().setLayoutParams(lp);
		}
		return self();
	}

	public Q sizePixels(int width, int height) {
		return sizePixels(width, height, true, true);
	}

	public Q widthPixels(int width) {
		return sizePixels(width, 0, true, false);
	}

	public Q heightPixels(int height) {
		return sizePixels(0, height, false, true);
	}

	public Q widthDips(int width) {
		return sizeDips(width, 0, true, false);
	}

	public Q heightDips(int height) {
		return sizeDips(0, height, false, true);
	}

	public Q sizeDips(int width, int height) {
		return sizeDips(width, height, true, true);
	}

	private Q sizeDips(int width, int height, boolean setWidth,
			boolean setHeight) {
		// height or width value < 0 means it is one of
		// LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT or
		// LayoutParams.FILL_PAREN. If this is the case, we don't need to
		// convert to pixels.
		int widthPixels = width <= 0 ? width : dip2pixel(getContext(), width);
		int heightPixels = height <= 0 ? height : dip2pixel(getContext(),
				height);
		return sizePixels(widthPixels, heightPixels, setWidth, setHeight);
	}

	private static int dip2pixel(Context context, float value) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				value, context.getResources().getDisplayMetrics());
	}
}

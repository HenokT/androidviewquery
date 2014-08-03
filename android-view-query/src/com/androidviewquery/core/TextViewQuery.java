package com.androidviewquery.core;

import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Provides fluent api for operating on a given {@link TextView}
 *
 */
public class TextViewQuery extends ViewQuery<TextView, TextViewQuery> {

	public TextViewQuery(TextView view) {
		super(view);
	}

	public TextViewQuery text(CharSequence text) {
		getView().setText(text);
		return self();
	}

	public TextViewQuery text(int resId) {
		getView().setText(resId);
		return self();
	}

	/**
	 * Sets the text of the associated {@link TextView} to a localized formatted
	 * string from the application's package's default string table.
	 * 
	 * @param resId
	 * @param formatArgs
	 * @return
	 */
	public TextViewQuery text(int resId, Object... formatArgs) {
		getView().setText(getContext().getString(resId, formatArgs));
		return self();
	}

	public TextViewQuery textColor(int color) {
		getView().setTextColor(color);
		return self();
	}

	/**
	 * Size must be given in scaled-pixel(sp) unit.
	 */
	public TextViewQuery textSize(int size) {
		getView().setTextSize(size);
		return self();
	}

	public TextViewQuery typeface(Typeface typeface) {
		getView().setTypeface(typeface);
		return self();
	}

	public TextViewQuery typeface(Typeface typeface, int style) {
		getView().setTypeface(typeface, style);
		return self();
	}
}

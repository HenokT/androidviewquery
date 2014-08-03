package com.androidviewquery.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A factory for {@link ViewQuery} objects that operate on descendants of the
 * root {@link View} associated with this factory
 * 
 */
public class ViewQueryFactory {
	private View rootView;

	public ViewQueryFactory(View rootView) {
		this.rootView = rootView;
	}

	private View findViewById(int id) {
		return rootView.findViewById(id);
	}

	/**
	 * Returns a new {@link TextViewQuery} object that operates on the
	 * {@link TextView} with the given id. The {@link TextView} must be a
	 * descendant of the root view associated with this factory
	 * 
	 * @param id
	 * @return
	 */
	public TextViewQuery withTextView(int id) {
		return with((TextView) findViewById(id));
	}

	public TextViewQuery with(TextView view) {
		return new TextViewQuery(view);
	}

	/**
	 * Returns a new {@link ImageViewQuery} object that operates on the
	 * {@link ImageView} with the given id. The {@link ImageView} must be a
	 * descendant of the root view associated with this factory
	 * 
	 * @param id
	 * @return
	 */
	public ImageViewQuery withImageView(int id) {
		return with((ImageView) findViewById(id));
	}

	public ImageViewQuery with(ImageView view) {
		return new ImageViewQuery(view);
	}

	// public static void main(String[] args) {
	// ViewQueryFactory vqf = new ViewQueryFactory(null);
	// TextViewQuery tvq = vqf.withTextView(0).text("Sample Title")
	// .textColor(0).background(0).goneIf(true);
	// CharSequence text = tvq.getView().getText();
	// vqf.with(new ImageView(null)).image((Drawable) null);
	// }
}
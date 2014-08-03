package com.androidviewquery.core;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Provides fluent api for operating on a given {@link TextView}
 *
 */
public class ImageViewQuery extends ViewQuery<ImageView, ImageViewQuery> {

	public ImageViewQuery(ImageView view) {
		super(view);
	}

	public ImageViewQuery image(int resId) {
		getView().setImageResource(resId);
		return self();
	}

	public ImageViewQuery image(Bitmap bitmap) {
		getView().setImageBitmap(bitmap);
		return self();
	}

	public ImageViewQuery image(Drawable drawable) {
		getView().setImageDrawable(drawable);
		return self();
	}

	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public ImageViewQuery imageAlpha(int alpha) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			getView().setImageAlpha(alpha);
		} else {
			getView().setAlpha(alpha);
		}
		return self();
	}
}

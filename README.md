androidviewquery
================

An android library inspired by AndroidQuery but with focus only on View manipulation using type safe ViewQuery objects.

**Example:**

```
private void updateView(View rootView, Data data) {
		ViewQueryFactory vqf = new ViewQueryFactory(rootView);

		vqf.withView(R.id.container).background(R.color.black)
				.sizeDips(240, LayoutParams.WRAP_CONTENT);
		vqf.withTextView(R.id.title).text(data.getTitle())
				.background(R.color.blue).textColor(R.color.white)
				.goneIf(data.size() == 0);
		vqf.withImageView(R.id.icon).image(R.drawable.icon).imageAlpha(5)
				.visibleIf(data.size() > 0);

	}
```
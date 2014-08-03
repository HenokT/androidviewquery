androidviewquery
================

An android library inspired by AndroidQuery but with focus only on View manipulation using type safe ViewQuery objects.

**Example:**

```
View rootView = inflater.inflate(R.layout.home, null);
ViewQueryFactory vqf = new ViewQueryFactory(rootView);
vqf.withTextView(R.id.title).text("Sample Title")
				.background(R.color.black)
				.textColor(R.color.white).goneIf(!mDataLoaded);
```
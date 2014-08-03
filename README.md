androidviewquery
================

An android library inspired by AndroidQuery but with focus only on View manipulation using type safe ViewQuery objects.

**Example:**

```
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	View rootView = findViewById(R.id.continer);

	ViewQuery vq = new ViewQuery(rootView);
	vq.backgroundRes(android.R.color.background_light);

	vq.withTextView(R.id.title).text("Contacts").textColor(Color.BLACK)
			.textSize(20);
	vq.withImageView(R.id.icon).image(R.drawable.icon_placeholder)
			.sizeDips(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	vq.withTextView(R.id.name).text("John Smith")
			.textColorRes(android.R.color.black).textSize(16);
}
```
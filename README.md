androidviewquery
================

An android library inspired by AndroidQuery but with focus only on View manipulation using type safe ViewQuery objects.

**Before ViewQuery:**

```
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	View container = findViewById(R.id.continer);
	container.setBackgroundResource(android.R.color.background_light);

	TextView title = (TextView) container.findViewById(R.id.title);
	title.setText("Contacts");
	title.setTextColor(Color.BLACK);
	title.setTextSize(20);

	ImageView icon = (ImageView) container.findViewById(R.id.icon);
	icon.setImageResource(R.drawable.icon_placeholder);
	LayoutParams lp = icon.getLayoutParams();
	lp.width = LayoutParams.WRAP_CONTENT;
	lp.height = LayoutParams.WRAP_CONTENT;
	icon.setLayoutParams(lp);

	TextView name = (TextView) container.findViewById(R.id.name);
	name.setText("Title");
	name.setTextColor(getResources().getColor(android.R.color.black));
	name.setTextSize(16);
}
```

**With ViewQuery:**

```
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	View container = findViewById(R.id.continer);
	ViewQuery vq = new ViewQuery(container);
	vq.backgroundRes(android.R.color.background_light);

	vq.withTextView(R.id.title).text("Contacts").textColor(Color.BLACK)
			.textSize(20);
	vq.withImageView(R.id.icon).image(R.drawable.icon_placeholder)
			.sizeDips(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	vq.withTextView(R.id.name).text("John Smith")
			.textColorRes(android.R.color.black).textSize(16);
}
```
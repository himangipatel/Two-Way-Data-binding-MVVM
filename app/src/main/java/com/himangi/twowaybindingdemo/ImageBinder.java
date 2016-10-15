package com.himangi.twowaybindingdemo;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by himangi.
 */

public class ImageBinder {

    private ImageBinder() {
        //NO-OP
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, Drawable url) {
        //Context context = imageView.getContext();

        imageView.setImageDrawable(url);

        //if u want to load web URL then use below code
//        Picasso picasso =  Picasso.with(view.getContext());
//        picasso.setIndicatorsEnabled(true);
//        picasso.load(url)
//                .error(R.drawable.ic_img_placeholder)
//                .placeholder(R.drawable.ic_img_placeholder)
//                .into(view);

    }

}

package com.himangi.twowaybindingdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by ailocaladmin on 29/03/16.
 */
public class Data extends BaseObservable {

    public final ObservableBoolean fieldsEnabled = new ObservableBoolean();
    public ObservableField<String> firstName = new ObservableField<>();
//    public Drawable photoLocalURL ;
    public ObservableField<Drawable> photo1LocalURL = new ObservableField<>();
    public ObservableField<String> photo2LocalURL = new ObservableField<>();
    // Basic EditText boilerplate

    public ObservableField<String> blurable = new ObservableField<>();

    public ObservableField<String> basic = new ObservableField<>();

    private Context mContext;

    public Data(Context context) {
        mContext = context;
    }


    public void onBlurableFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            Toast.makeText(v.getContext(), "Field blurred", Toast.LENGTH_SHORT).show();
    }

    // CheckBox change listener
    public void onCheckedChanged(View v) {
        fieldsEnabled.set(((CheckBox) v).isChecked());
        if (!((CheckBox) v).isChecked()){
            photo1LocalURL.set(mContext.getResources().getDrawable(R.drawable.baby2));
            photo2LocalURL.set("http://images.all-free-download.com/images/graphiclarge/baby_with_a_laptop_204935.jpg");
        }else {
            photo1LocalURL.set(mContext.getResources().getDrawable(R.drawable.baby1));
            photo2LocalURL.set("http://images.all-free-download.com/images/graphiclarge/baby_elf_201045.jpg");
        }

    }

}

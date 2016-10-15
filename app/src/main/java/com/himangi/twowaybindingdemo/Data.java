package com.himangi.twowaybindingdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
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
    public ObservableField<Drawable> photoLocalURL = new ObservableField<>();

    // Basic EditText boilerplate
    private String basic;

    private Context mContext;

    public Data(Context context) {
        mContext = context;
    }

    @Bindable
    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic=basic;
//        notifyPropertyChanged(com.example.ailocaladmin.twowaybindingdemo.BR.basic);
    }

    // Blurable EditText Boilerplate
    private String blurable;

    @Bindable
    public String getBlurable() {
        return blurable;
    }

    public void setBlurable(String blurable) {
        this.blurable = blurable;
//        notifyPropertyChanged(com.example.ailocaladmin.twowaybindingdemo.BR.blurable);
    }


    public void onBlurableFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            Toast.makeText(v.getContext(), "Field blurred", Toast.LENGTH_SHORT).show();
    }

    // CheckBox change listener
    public void onCheckedChanged(View v) {
        fieldsEnabled.set(((CheckBox) v).isChecked());
        if (!((CheckBox) v).isChecked()){
            photoLocalURL.set(mContext.getResources().getDrawable(R.drawable.baby2));
        }else {
            photoLocalURL.set(mContext.getResources().getDrawable(R.drawable.baby1));
        }

    }

}

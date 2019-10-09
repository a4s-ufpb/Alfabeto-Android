package com.napoleao.alphabeto.config;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;

public class AlphaTextView extends AppCompatTextView {
    private Context context;
    private String fontFamily;
    private String fontCase;


    //@RequiresApi(api = Build.VERSION_CODES.M)
    public AlphaTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    public AlphaTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    public AlphaTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {
        this.fontFamily = AppConfig.getInstance(this.context).getCurrentLetterType();
        this.fontCase = AppConfig.getInstance(this.context).getCurrentLetterCase();
        Log.i("AlphaTextView","fontFamily charged: "+this.fontFamily);
        Log.i("AlphaTextView","fontCase charged: "+this.fontCase);

        switch (this.fontFamily) {
            case AppConfig.CURSIVA: {
                Typeface tf = Typeface.createFromAsset(this.context.getAssets(), "fonts/Maria_lucia.ttf");
                this.setTypeface(tf);
                //this.setTextAppearance(R.style.styleCursive);
                break;
            }

            case AppConfig.BASTAO: {
                Typeface tf = Typeface.create("sans-serif", Typeface.NORMAL);
                this.setTypeface(tf);
                //this.setTextAppearance(R.style.styleBastao);
                break;
            }

        }

        switch (this.fontCase){
            case AppConfig.UPPER:{
                this.setAllCaps(true);
                break;
            }

            case AppConfig.LOWER:{
                this.setAllCaps(false);
                break;
            }
        }
    }
}
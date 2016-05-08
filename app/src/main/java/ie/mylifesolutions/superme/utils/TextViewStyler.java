package ie.mylifesolutions.superme.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

/**
 * Created by Dean on 5/8/2016.
 */
public class TextViewStyler {


    private static int shadowDX = 5;
    private static int shadowDY = 5;
    private static int shadowRadius = 10;
    private static int shadowColorDark = Color.BLACK;
    private static int shadowColorLight = Color.GRAY;
    private static float textSizeIncrease = 1.5f;


    public static int TEXT_COLOR_GREEN = Color.GREEN;
    public static int TEXT_COLOR_BLUE = Color.BLUE;

    public static void populateTextView(TextView targetView, String text, int textColor, String[] standOutPhrases, int textColorStandOut, Typeface type){
        SpannableString textSpan = new SpannableString(text);
        textSpan.setSpan(new ForegroundColorSpan(textColor), 0, text.length(), 0);
        textSpan.setSpan(new ShadowSpan(shadowRadius, shadowDX, shadowDY, shadowColorLight), 0, text.length(), 0);

        if(standOutPhrases != null){
            for(String phrase : standOutPhrases){
                int start = text.indexOf(phrase);
                int end = start + phrase.length();
                if(start != -1){
                    textSpan.setSpan(new ShadowSpan(shadowRadius, shadowDX, shadowDY, shadowColorDark), start, end, 0);
                    textSpan.setSpan(new RelativeSizeSpan(textSizeIncrease), start, end, 0);
                    textSpan.setSpan(new ForegroundColorSpan(textColorStandOut), start, end, 0);
                }
            }
        }

        targetView.setText(textSpan, TextView.BufferType.SPANNABLE);
        targetView.setTypeface(type);
    }
}

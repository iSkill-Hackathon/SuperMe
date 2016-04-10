package ie.mylifesolutions.superme.parents;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ie.mylifesolutions.superme.R;
import ie.mylifesolutions.superme.utils.ShadowSpan;

public class ParentsFragment extends Fragment {

    private int shadowDX = 5;
    private int shadowDY = 5;
    private int shadowRadius = 10;
    private int shadowColorDark = Color.BLACK;
    private int shadowColorLight = Color.GRAY;

    private float textSizeIncrease = 1.5f;

    private int textColorGreen = Color.GREEN;
    private int textColorBlue = Color.BLUE;

    private String[] phrases = {"\"SuperMe\"", "SuperMe", "SuperMiss", "SuperTools", "www.mylifesolutions.ie", "www.kidscape.org.uk"};

    public ParentsFragment() {
        // Required empty public constructor
    }

    public static ParentsFragment newInstance() {
        return new ParentsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_parents, container, false);
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/design.graffiti.comicsansms.ttf");

        List<TextView> textViews = new ArrayList<>();
        textViews.add((TextView) view.findViewById(R.id.parents_text_1));
        textViews.add((TextView) view.findViewById(R.id.parents_text_2));
        textViews.add((TextView) view.findViewById(R.id.parents_text_3));
        textViews.add((TextView) view.findViewById(R.id.parents_text_4));
        textViews.add((TextView) view.findViewById(R.id.parents_text_5));

        for(TextView textView : textViews){
            populateTextView(textView, textView.getText().toString(), textColorBlue, phrases, textColorGreen, type);
        }

        return view;
    }

    private void populateTextView(TextView targetView, String text, int textColor, String[] standOutPhrases, int textColorStandOut, Typeface type){
        SpannableString textSpan = new SpannableString(text);
        textSpan.setSpan(new ForegroundColorSpan(textColor), 0, text.length(), 0);
        textSpan.setSpan(new ShadowSpan(shadowRadius, shadowDX, shadowDY, shadowColorLight), 0, text.length(), 0);

        if(standOutPhrases != null){
            for(String phrase : standOutPhrases){
                int start = text.indexOf(phrase);
                int end = start + phrase.length();
                if(start != -1){
                    textSpan.setSpan(new ForegroundColorSpan(textColorStandOut), start, end, 0);
                    textSpan.setSpan(new ShadowSpan(shadowRadius, shadowDX, shadowDY, shadowColorDark), start, end, 0);
                    textSpan.setSpan(new RelativeSizeSpan(textSizeIncrease), start, end, 0);
                }
            }

        }

        targetView.setText(textSpan, TextView.BufferType.SPANNABLE);
        targetView.setTypeface(type);
    }

}

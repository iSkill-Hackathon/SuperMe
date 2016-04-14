package ie.mylifesolutions.superme.info;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ie.mylifesolutions.superme.R;
import ie.mylifesolutions.superme.credits.CreditsFragment;
import ie.mylifesolutions.superme.utils.ShadowSpan;

public class InfoFragment extends Fragment {

    private int shadowDX = 5;
    private int shadowDY = 5;
    private int shadowRadius = 10;
    private int shadowColorDark = Color.BLACK;
    private int shadowColorLight = Color.GRAY;

    private float textSizeIncrease = 1.5f;

    private int textColorGreen = Color.GREEN;
    private int textColorBlue = Color.BLUE;

    private String[] phrases = {"\"SUPER ME\"", "STAND TALL, HAVE GOOD EYE CONTACT AND NEVER HURT THE PERSON BACK."};

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/design.graffiti.comicsansms.ttf");


        initButton((Button) view.findViewById(R.id.button_credits), textColorBlue, type);


        List<TextView> textViews = new ArrayList<>();
        textViews.add((TextView) view.findViewById(R.id.info_text_1));
        textViews.add((TextView) view.findViewById(R.id.info_text_2));
        textViews.add((TextView) view.findViewById(R.id.info_text_3));
        textViews.add((TextView) view.findViewById(R.id.info_text_4));
        textViews.add((TextView) view.findViewById(R.id.info_text_5));
        textViews.add((TextView) view.findViewById(R.id.info_text_6));

        for(TextView textView : textViews){
            populateTextView(textView, textView.getText().toString(), textColorBlue, phrases, textColorGreen, type);
        }

        return view;
    }

    private void initButton(Button button, int textColor, Typeface type){
        String text = button.getText().toString();
        SpannableString textSpan = new SpannableString(text);
        textSpan.setSpan(new ForegroundColorSpan(textColor), 0, text.length(), 0);
        textSpan.setSpan(new ShadowSpan(shadowRadius, shadowDX, shadowDY, shadowColorLight), 0, text.length(), 0);

        button.setText(textSpan, TextView.BufferType.SPANNABLE);
        button.setTypeface(type);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, CreditsFragment.newInstance()).addToBackStack("credits").commit();
            }
        });

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


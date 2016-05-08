package ie.mylifesolutions.superme.parents;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ie.mylifesolutions.superme.R;
import ie.mylifesolutions.superme.utils.ShadowSpan;
import ie.mylifesolutions.superme.utils.TextViewStyler;

public class ParentsFragment extends Fragment {

    private String[] phrases = {"\"SuperMe\"", "SuperMe", "SuperMiss", "SuperTools"};

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
        textViews.add((TextView) view.findViewById(R.id.parents_text_7));


        for(TextView textView : textViews){
            TextViewStyler.populateTextView(textView, textView.getText().toString(), TextViewStyler.TEXT_COLOR_BLUE, phrases, TextViewStyler.TEXT_COLOR_GREEN, type);
        }

        ((TextView) view.findViewById(R.id.parents_text_6)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) view.findViewById(R.id.parents_text_6)).setText(Html.fromHtml(getResources().getString(R.string.parents_screen_text_6)));

        ((TextView) view.findViewById(R.id.parents_text_8)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) view.findViewById(R.id.parents_text_8)).setText(Html.fromHtml(getResources().getString(R.string.parents_screen_text_8)));

        return view;
    }

}
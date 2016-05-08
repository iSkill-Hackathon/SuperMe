package ie.mylifesolutions.superme.credits;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ie.mylifesolutions.superme.R;
import ie.mylifesolutions.superme.utils.ShadowSpan;
import ie.mylifesolutions.superme.utils.TextViewStyler;


public class CreditsFragment extends Fragment {


    private String[] phrases = {"\"SUPER ME\""};


    public CreditsFragment() {
        // Required empty public constructor
    }


    public static CreditsFragment newInstance() {
        return new CreditsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/design.graffiti.comicsansms.ttf");

        List<TextView> textViews = new ArrayList<>();
        textViews.add((TextView)view.findViewById(R.id.credits_copyright_text));
        textViews.add((TextView)view.findViewById(R.id.credits_creative_brilliance));
        textViews.add((TextView)view.findViewById(R.id.credits_technology_brilliance));
        textViews.add((TextView)view.findViewById(R.id.credits_text_1));

        for(TextView textView : textViews){
            TextViewStyler.populateTextView(textView, textView.getText().toString(), TextViewStyler.TEXT_COLOR_BLUE, phrases, TextViewStyler.TEXT_COLOR_GREEN, type);
        }


        return view;
    }
}
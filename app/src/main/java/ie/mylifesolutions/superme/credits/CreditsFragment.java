package ie.mylifesolutions.superme.credits;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ie.mylifesolutions.superme.R;


public class CreditsFragment extends Fragment {


    public CreditsFragment() {
        // Required empty public constructor
    }


    public static CreditsFragment newInstance() {
        return new CreditsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_credits, container, false);
    }

}

package ie.mylifesolutions.superme.parents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ie.mylifesolutions.superme.R;

public class ParentsFragment extends Fragment {

    public ParentsFragment() {
        // Required empty public constructor
    }

    public static ParentsFragment newInstance() {
        return new ParentsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_parents, container, false);
    }

}

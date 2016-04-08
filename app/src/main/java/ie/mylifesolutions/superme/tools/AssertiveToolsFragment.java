package ie.mylifesolutions.superme.tools;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ie.mylifesolutions.superme.R;


public class AssertiveToolsFragment extends Fragment {


    public AssertiveToolsFragment() {
        // Required empty public constructor
    }

    public static AssertiveToolsFragment newInstance() {
        return new AssertiveToolsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_assertive_tools, container, false);
    }

}

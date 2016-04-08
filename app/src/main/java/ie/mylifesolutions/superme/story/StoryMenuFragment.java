package ie.mylifesolutions.superme.story;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import ie.mylifesolutions.superme.R;


public class StoryMenuFragment extends Fragment implements View.OnClickListener{
    private final String SELECTED_STORY = "selected_story";
    private SharedPreferences sharedpreferences;
    private ArrayList<ImageButton> buttons =  new ArrayList<>();

    public static StoryMenuFragment newInstance() {
        StoryMenuFragment fragment = new StoryMenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_story_menu, container, false);
        buttons.add((ImageButton) view.findViewById(R.id.viral_button));
        buttons.add((ImageButton) view.findViewById(R.id.scorpies_button));
        buttons.add((ImageButton) view.findViewById(R.id.bull_basher_button));
        buttons.add((ImageButton) view.findViewById(R.id.mad_mocker_button));

        for(ImageButton b: buttons){
            b.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        sharedpreferences = this.getActivity().getSharedPreferences(SELECTED_STORY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
       

        switch (view.getId()){
            case R.id.viral_button:   editor.putString(SELECTED_STORY, "viral");
                editor.commit();
                break;
            case R.id.scorpies_button:    editor.putString(SELECTED_STORY, "scorpies");
                editor.commit();
                break;
            case R.id.bull_basher_button:    editor.putString(SELECTED_STORY, "bull_basher");
                editor.commit();
                break;
            case R.id.mad_mocker_button:    editor.putString(SELECTED_STORY, "mad_mocker");
                editor.commit();
                break;
        }

        Intent intent = new Intent(getContext(),Stories.class);
        startActivity(intent);
    }
}

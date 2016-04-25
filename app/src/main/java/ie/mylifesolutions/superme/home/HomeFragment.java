package ie.mylifesolutions.superme.home;


import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ie.mylifesolutions.superme.R;


public class HomeFragment extends Fragment {

    Dialog builder;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView superMeButton = (ImageView) view.findViewById(R.id.super_me_character);
        ImageView bullBasherButton = (ImageView) view.findViewById(R.id.bull_basher_home_button);
        ImageView madMockerButton = (ImageView) view.findViewById(R.id.mad_mocker_home_button);
        ImageView scorpiesButton = (ImageView) view.findViewById(R.id.scorpies_home_button);
        ImageView viralButton = (ImageView) view.findViewById(R.id.viral_home_button);

        bullBasherButton.setOnClickListener(buttonListener);
        bullBasherButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.expand_large));
        madMockerButton.setOnClickListener(buttonListener);
        madMockerButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.wobble));
        scorpiesButton.setOnClickListener(buttonListener);
        scorpiesButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.expand_small));
        viralButton.setOnClickListener(buttonListener);
        viralButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.expand_small));
        superMeButton.setOnClickListener(buttonListener);
        superMeButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.superme));

        return view;
    }



    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();

            switch (id){
                case R.id.bull_basher_home_button :
                    showImage(R.drawable.bull_basher_info_popup);
                    break;
                case R.id.mad_mocker_home_button:
                    showImage(R.drawable.mad_mocker_info_popup);
                    break;
                case R.id.scorpies_home_button :
                    showImage(R.drawable.scorpies_info_popup);
                    break;
                case R.id.viral_home_button:
                    showImage(R.drawable.viral_info_popup);
                    break;
                case R.id.super_me_character:
                    showImage(R.drawable.superme_info_popup);
                    break;
            }
        }
    };
    public void showImage(int id) {
        builder = new Dialog(getContext()){
            @Override
            public boolean onTouchEvent(MotionEvent event){
                this.dismiss();
                return true;
            }
        };
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), id));
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.show();
    }
}

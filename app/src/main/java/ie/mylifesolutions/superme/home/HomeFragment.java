package ie.mylifesolutions.superme.home;


import android.app.Dialog;
import android.app.PendingIntent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ie.mylifesolutions.superme.R;


public class HomeFragment extends Fragment {
    AnimationDrawable animationDrawable01;
    AnimationDrawable animationDrawable02;
    AnimationDrawable animationDrawable03;
    AnimationDrawable animationDrawable04;
    AnimationDrawable animationDrawable05;

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

        ImageView storyImage = (ImageView) view.findViewById(R.id.home_page_bg);
        ImageButton bullBasherButton = (ImageButton) view.findViewById(R.id.bull_basher_home_button);
        ImageButton madMockerButton = (ImageButton) view.findViewById(R.id.mad_mocker_home_button);
        ImageButton scorpiesButton = (ImageButton) view.findViewById(R.id.scorpies_home_button);
        ImageButton viralButton = (ImageButton) view.findViewById(R.id.viral_home_button);
        Button superMeButton = (Button) view.findViewById(R.id.superme_home_button);

        storyImage.setBackgroundResource(R.drawable.home_page);
        bullBasherButton.setBackgroundResource(R.drawable.bull_basher);
        madMockerButton.setBackgroundResource(R.drawable.mad_mocker);
        scorpiesButton.setBackgroundResource(R.drawable.scorpies);
        viralButton.setBackgroundResource(R.drawable.viral);

        AnimationDrawable animationDrawable01 = (AnimationDrawable) storyImage.getBackground();
        AnimationDrawable animationDrawable02 = (AnimationDrawable) bullBasherButton.getBackground();
        AnimationDrawable animationDrawable03 = (AnimationDrawable) madMockerButton.getBackground();
        AnimationDrawable animationDrawable04 = (AnimationDrawable) scorpiesButton.getBackground();
        AnimationDrawable animationDrawable05 = (AnimationDrawable) viralButton.getBackground();
        animationDrawable01.start();
        animationDrawable02.start();
        animationDrawable03.start();
        animationDrawable04.start();
        animationDrawable05.start();

        bullBasherButton.setOnClickListener(buttonListener);
        madMockerButton.setOnClickListener(buttonListener);
        scorpiesButton.setOnClickListener(buttonListener);
        viralButton.setOnClickListener(buttonListener);
        superMeButton.setOnClickListener(buttonListener);


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
                case R.id.superme_home_button:
                    showImage(R.drawable.superme_info_popup);
                    break;
            }
        }
    };
    public void showImage(int id) {
        Dialog builder = new Dialog(getContext()){
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
        builder.show();
    }

}

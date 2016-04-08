package ie.mylifesolutions.superme.story;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import ie.mylifesolutions.superme.R;

public class Stories extends AppCompatActivity {
    private SharedPreferences sharedpreferences;
    private final String STORY_CHOICE = "story";
    private int[] viralImages = {R.drawable.viral_slide_1a,R.drawable.viral_slide_2a,R.drawable.viral_slide_3a,R.drawable.viral_slide_4a,R.drawable.viral_slide_5a,R.drawable.viral_slide_6a};
    private int[] scopieImages = {R.drawable.scorpie_slide_1a,R.drawable.scorpie_slide_2a,R.drawable.scorpie_slide_3a,R.drawable.scorpie_slide_4a,R.drawable.scorpie_slide_5a, R.drawable.scorpie_slide_6a};
    private int[] choosenStoryImages;
    AnimationDrawable animationDrawable;
    String choosenStory;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        getPreferences();
        setupAnimations();


    }

    private void getPreferences(){
        sharedpreferences = getSharedPreferences(STORY_CHOICE, Context.MODE_PRIVATE);
        choosenStory = sharedpreferences.getString(STORY_CHOICE, null);
    }

    private void setupAnimations(){
        ImageView storyImage = (ImageView) findViewById(R.id.storyView);
        switch(choosenStory){
            case "viralStory": storyImage.setBackgroundResource(viralImages[count]);
                animationDrawable = (AnimationDrawable) storyImage.getBackground(); break;
            case "scorpiesStory": storyImage.setBackgroundResource(R.drawable.scorpie_slide_1a);
                animationDrawable = (AnimationDrawable) storyImage.getBackground();break;
            case "bull_basherStory": storyImage.setBackgroundResource(R.drawable.bull_basher_slide_1);
                animationDrawable = (AnimationDrawable) storyImage.getBackground();break;
            case "mad_mockerStory": storyImage.setBackgroundResource(R.drawable.mad_mocker_slide_1a);
                animationDrawable = (AnimationDrawable) storyImage.getBackground();break;
            default:storyImage.setBackgroundResource(R.drawable.viral_slide_1a);
                animationDrawable = (AnimationDrawable) storyImage.getBackground();

        }
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            animationDrawable.start();
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void onClickMe(View view){
        Log.i("Click", "Button Work");
        count++;
        ImageView storyImage = (ImageView) findViewById(R.id.storyView);
        storyImage.setBackgroundResource(viralImages[count]);
        animationDrawable = (AnimationDrawable) storyImage.getBackground();
        animationDrawable.start();
    }




}

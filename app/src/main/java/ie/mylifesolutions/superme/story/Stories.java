package ie.mylifesolutions.superme.story;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import ie.mylifesolutions.superme.R;

public class Stories extends AppCompatActivity {
    private SharedPreferences sharedpreferences;
    private final String SELECTED_STORY = "selected_story";
    private final String TAG ="stories_fragment";
    private int[] viralImages = {R.drawable.viral_slide_1a,R.drawable.viral_slide_2a,R.drawable.viral_slide_3a,R.drawable.viral_slide_4a,R.drawable.viral_slide_5a,R.drawable.viral_slide_6a};
    private int[] scorpieImages = {R.drawable.scorpie_slide_1a,R.drawable.scorpie_slide_2a,R.drawable.scorpie_slide_3a,R.drawable.scorpie_slide_4a,R.drawable.scorpie_slide_5a, R.drawable.scorpie_slide_6a};
    private int[] bullBasherImages = {R.drawable.bull_basher_slide_1,R.drawable.bull_basher_slide_2a,R.drawable.bull_basher_slide_3,R.drawable.bull_basher_slide_4a,R.drawable.bull_basher_slide_5a,R.drawable.bull_basher_slide_6};
    private int[] madMockerImages = {R.drawable.mad_mocker_slide_1a,R.drawable.mad_mocker_slide_2a,R.drawable.mad_mocker_slide_3a,R.drawable.mad_mocker_slide_4a,R.drawable.mad_mocker_slide_5a,R.drawable.mad_mocker_slide_6a};
    private int[] chosenStoryImages;
    AnimationDrawable animationDrawable;
    String chosenStory = "";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        getPreferences();
        setupAnimations();
    }

    private void getPreferences(){
        sharedpreferences = getSharedPreferences(SELECTED_STORY, Context.MODE_PRIVATE);
        chosenStory = sharedpreferences.getString(SELECTED_STORY, null);
        Log.i(TAG, "Chosen Story = " + chosenStory);
    }

    private void setupAnimations(){
        ImageView storyImage = (ImageView) findViewById(R.id.storyView);
        switch(chosenStory){
            case "viral": chosenStoryImages = viralImages; break;
            case "scorpies": chosenStoryImages = scorpieImages; break;
            case "bull_basher": chosenStoryImages = bullBasherImages; break;
            case "mad_mocker": chosenStoryImages = madMockerImages; break;
            default:
                Toast.makeText(this,"Error: No Story Chosen",Toast.LENGTH_SHORT).show();

        }

        storyImage.setBackgroundResource(chosenStoryImages[count]);
        animationDrawable = (AnimationDrawable) storyImage.getBackground();
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            animationDrawable.start();
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void onClickForward(View view){
        //Log.i("Click", "Button Work");

        if(count < chosenStoryImages.length - 1){
            count++;
            Log.i(TAG,"Up " + count);
            ImageView storyImage = (ImageView) findViewById(R.id.storyView);
            storyImage.setBackgroundResource(chosenStoryImages[count]);
            animationDrawable = (AnimationDrawable) storyImage.getBackground();
            animationDrawable.start();
        }

    }

    public void onClickBack(View view){
        //Log.i("Click", "Button Work");
        if(count > 0){
            count--;
            Log.i(TAG,"Down " + count);

            ImageView storyImage = (ImageView) findViewById(R.id.storyView);
            storyImage.setBackgroundResource(chosenStoryImages[count]);
            animationDrawable = (AnimationDrawable) storyImage.getBackground();
            animationDrawable.start();
        }


    }




}

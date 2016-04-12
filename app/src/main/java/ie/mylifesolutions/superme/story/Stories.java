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
    private final String TAG ="stories";
    private int[] viralImages = {R.drawable.v_slide_1,R.drawable.v_slide_2,R.drawable.v_slide_3,R.drawable.v_slide_4,R.drawable.v_slide_5,R.drawable.v_slide_6};
    private int[] scorpieImages = {R.drawable.sc_slide_1,R.drawable.sc_slide_2,R.drawable.sc_slide_3,R.drawable.sc_slide_4,R.drawable.sc_slide_5, R.drawable.sc_slide_6};
    private int[] bullBasherImages = {R.drawable.bb_slide_1,R.drawable.bb_slide_2,R.drawable.bb_slide_3,R.drawable.bb_slide_4,R.drawable.bb_slide_5,R.drawable.bb_slide_6};
    private int[] madMockerImages = {R.drawable.mm_slide_1,R.drawable.mm_slide_2,R.drawable.mm_slide_3,R.drawable.mm_slide_4,R.drawable.mm_slide_5,R.drawable.mm_slide_6};
    private int[] chosenStoryImages;
    private AnimationDrawable animationDrawable;
    private String chosenStory = "";
    private int slideCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getPreferences();
        setupStory();

        setContentView(R.layout.activity_stories);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        initializeAnimation();
    }

    /**
     * Get the string of chosen story.
     */
    private void getPreferences(){
        sharedpreferences = getSharedPreferences(SELECTED_STORY, Context.MODE_PRIVATE);
        chosenStory = sharedpreferences.getString(SELECTED_STORY, null);
        Log.i(TAG, "Chosen Story = " + chosenStory);
    }

    /**
     * Assign array of image ids to chosenStoryImages[] depending on which story the user has chosen
     * also set activity theme to specific story.
     */
    private void setupStory(){

        switch(chosenStory){
            case "viral":       chosenStoryImages = viralImages;
                                setTheme(R.style.ViralTheme); break;
            case "scorpies":    chosenStoryImages = scorpieImages;
                                setTheme(R.style.ScorpiesTheme);break;
            case "bull_basher": chosenStoryImages = bullBasherImages;
                                setTheme(R.style.BullBasherTheme);break;
            case "mad_mocker":  chosenStoryImages = madMockerImages;
                                setTheme(R.style.MadMockerTheme);break;
            default:
                Toast.makeText(this,"Error: No Story Chosen",Toast.LENGTH_SHORT).show();

        }


    }

    private void initializeAnimation(){
        ImageView storyImage = (ImageView) findViewById(R.id.storyView);
        storyImage.setBackgroundResource(chosenStoryImages[slideCount]);
        animationDrawable = (AnimationDrawable) storyImage.getBackground();
        animationDrawable.start();
    }

    /**
     * Start animation as soon as the user taps the screen
     * @param event
     * @return
     */
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            animationDrawable.start();
            return true;
        }
        return super.onTouchEvent(event);
    }

    /**
     * Switch to the next slide when user clicks the button
     * @param view
     */
    public void onClickForward(View view){
        //Log.i("Click", "Button Work");

        if(slideCount < chosenStoryImages.length - 1){
            slideCount++;
            //Log.i(TAG,"Up " + slideCount);

            ImageView storyImage = (ImageView) findViewById(R.id.storyView);
            storyImage.setBackgroundResource(chosenStoryImages[slideCount]);
            animationDrawable = (AnimationDrawable) storyImage.getBackground();
            animationDrawable.start();
        } else {
            finish();
        }
    }

    /**
     * Switch to the previous slide when the user clicks the button
     * @param view
     */
    public void onClickBack(View view){
        //Log.i("Click", "Button Work");
        if(slideCount > 0){
            slideCount--;
            //Log.i(TAG,"Down " + slideCount);

            ImageView storyImage = (ImageView) findViewById(R.id.storyView);
            storyImage.setBackgroundResource(chosenStoryImages[slideCount]);
            animationDrawable = (AnimationDrawable) storyImage.getBackground();
            animationDrawable.start();
        } else {
            finish();
        }
    }
}

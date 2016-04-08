package ie.mylifesolutions.superme.story;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ie.mylifesolutions.superme.R;


public class StoryMenu extends AppCompatActivity {
    private final String STORY_CHOICE = "story";
    private SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_menu);

    }

    public void onClickStoryButton(View view){
        Log.i("Button","" +view.getId());
        sharedpreferences = getSharedPreferences(STORY_CHOICE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();

        switch (view.getId()){
            case 2131492946:  Intent viralStory = new Intent(this,Stories.class);
                editor.putString(STORY_CHOICE, "viralStory");
                editor.commit();
                startActivity(viralStory);break;
            case 2131492947: Intent scorpiesStory = new Intent(this,Stories.class);
                editor.putString(STORY_CHOICE, "scorpiesStory");
                editor.commit();
                startActivity(scorpiesStory);break;
            case 2131492948:    Intent bull_basherStory = new Intent(this,Stories.class);
                editor.putString(STORY_CHOICE, "bull_basherStory");
                editor.commit();
                startActivity(bull_basherStory); break;
            case 2131492949: Intent mad_mockerStory = new Intent(this,Stories.class);
                editor.putString(STORY_CHOICE, "mad_mockerStory");
                editor.commit();
                startActivity(mad_mockerStory);break;
        }
    }
}

package ie.mylifesolutions.superme;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ie.mylifesolutions.superme.contact.ContactFragment;
import ie.mylifesolutions.superme.credits.CreditsFragment;
import ie.mylifesolutions.superme.home.HomeFragment;
import ie.mylifesolutions.superme.info.InfoFragment;
import ie.mylifesolutions.superme.menu.MenuDrawerItem;
import ie.mylifesolutions.superme.menu.DrawerListAdapter;
import ie.mylifesolutions.superme.parents.ParentsFragment;
import ie.mylifesolutions.superme.story.StoryMenuFragment;
import ie.mylifesolutions.superme.tools.AssertiveToolsFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "mainactivity";
    private List<MenuDrawerItem> mMenuItems = new ArrayList<>();
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout mDrawerPane;
    private TextView titleTextView;

    private int[] icon_ids = {R.drawable.icon_home, R.drawable.icon_stories, R.drawable.icon_assertive_tools, R.drawable.icon_contact, R.drawable.icon_info, R.drawable.icon_parents};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.tool_eye_contact);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            if(titleTextView == null){
                LayoutInflater inflater = LayoutInflater.from(this);
                View titleView = inflater.inflate(R.layout.titleview, null);
                titleTextView = (TextView) titleView.findViewById(R.id.title);
                titleTextView.setTypeface(Typeface.createFromAsset(this.getAssets(), "fonts/design.graffiti.comicsansms.ttf"));
                titleTextView.setTextColor(Color.WHITE);

                getSupportActionBar().setCustomView(titleView);
            }
        }
        String[] menuItems = getResources().getStringArray(R.array.menu_items);

        for(int i = 0; i < menuItems.length; ++i){
            mMenuItems.add(new MenuDrawerItem(menuItems[i], icon_ids[i]));
        }

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mDrawerList = (ListView) findViewById(R.id.drawerList);
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        DrawerListAdapter listAdapter = new DrawerListAdapter(this, mMenuItems);
        mDrawerList.setAdapter(listAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d(TAG, "onDrawerClosed: " + getTitle());

                invalidateOptionsMenu();
            }
        };

        /*
        Changing the font of the title bar
         */

        /*
        Check to see if there was already a fragment displayed and redisplay it if so,
        this simple solves the issue of orientation changes causing the app to reset to home screen.
         */
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainContent);
        if(fragment == null){
            changeFragment(HomeFragment.newInstance());
            titleTextView.setText("Home");
        }else{
            changeFragment(fragment);
            titleTextView.setText(parseStringFromFragment(fragment));
        }

    }
    /*
    Method to change to the fragment that the user selected from the menu
     */
    private void selectItemFromDrawer(int position) {
        mDrawerList.setItemChecked(position, true);
        String selectedText = mMenuItems.get(position).getTitle();
        titleTextView.setText(selectedText);

        /*
        Check to see if the Credits fragment is being displayed,
        to clear back stack in-case of a jump from to different fragment.
         */
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainContent);
        if(fragment instanceof CreditsFragment){
            getSupportFragmentManager().popBackStack();
        }

        changeFragment(parseFragmentFromString(selectedText));

        // Close the drawer
        mDrawerLayout.closeDrawer(mDrawerPane);
    }
    /*
    Just a method to return the desired fragment based on the fragment's name.
     */
    private Fragment parseFragmentFromString(String fragmentName){
        switch (fragmentName){
            case "Home" :
                return HomeFragment.newInstance();
            case "Contact" :
                return ContactFragment.newInstance();
            case "Assertive Tools" :
                return AssertiveToolsFragment.newInstance();
            case "Info" :
                return InfoFragment.newInstance();
            case "Stories":
                return StoryMenuFragment.newInstance();
            case "Parents":
                return ParentsFragment.newInstance();
        }
        return null;
    }
    /*
    Just a method to return the string associated with the fragment.
    Bit of a quick fix but just to keep the title available upon orientation changes.
     */
    private String parseStringFromFragment(Fragment fragment){
       if(fragment instanceof AssertiveToolsFragment){
           return "Assertive Tools";
       }else if(fragment instanceof ContactFragment){
           return "Contact";
       }else if(fragment instanceof InfoFragment){
           return "Info";
       }else if(fragment instanceof StoryMenuFragment){
           return "Stories";
       }else if(fragment instanceof ParentsFragment){
           return "Parents";
       }else{
           return "Home";
       }

    }
    /*
    Method to display a fragment in the main screen of the app
     */
    private void changeFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainContent, fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

}

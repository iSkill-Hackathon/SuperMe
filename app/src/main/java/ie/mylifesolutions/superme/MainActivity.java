package ie.mylifesolutions.superme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import ie.mylifesolutions.superme.contact.ContactFragment;
import ie.mylifesolutions.superme.info.InfoFragment;
import ie.mylifesolutions.superme.menu.MenuDrawerItem;
import ie.mylifesolutions.superme.menu.DrawerListAdapter;
import ie.mylifesolutions.superme.tools.AssertiveToolsFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "mainactivity";
    private List<MenuDrawerItem> mMenuItems = new ArrayList<>();
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout mDrawerPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        String[] menuItems = getResources().getStringArray(R.array.menu_items);

        for(String menuItem : menuItems){
            mMenuItems.add(new MenuDrawerItem(menuItem, 0));
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

    }

    private void selectItemFromDrawer(int position) {
        mDrawerList.setItemChecked(position, true);
        String selectedText = mMenuItems.get(position).getTitle();
        setTitle(selectedText);

        switch (selectedText){
            case "Contact" :
                    changeFragment(ContactFragment.newInstance());
                break;
            case "Assertive Tools" :
                    changeFragment(AssertiveToolsFragment.newInstance());
                break;
            case "Info" :
                    changeFragment(InfoFragment.newInstance());
                break;
        }

        // Close the drawer
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    private void changeFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainContent, fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }




}

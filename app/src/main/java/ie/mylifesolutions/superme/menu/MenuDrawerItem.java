package ie.mylifesolutions.superme.menu;

/**
 * Created by Dean on 08/04/2016.
 */
public class MenuDrawerItem {
    private String mTitle;
    private int mIcon;

    public MenuDrawerItem(String title, int icon){
        mIcon = icon;
        mTitle = title;
    }

    public String getTitle(){
        return mTitle;
    }
    public int getIcon(){
        return mIcon;
    }
}

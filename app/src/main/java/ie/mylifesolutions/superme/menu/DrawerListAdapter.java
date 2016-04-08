package ie.mylifesolutions.superme.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ie.mylifesolutions.superme.R;

/**
 * Created by Dean on 08/04/2016.
 */
public class DrawerListAdapter extends BaseAdapter {

    Context mContext;
    List<MenuDrawerItem> mMenuItems;

    public DrawerListAdapter(Context context, List<MenuDrawerItem> menuItems) {
        mContext = context;
        mMenuItems = menuItems;
    }

    @Override
    public int getCount() {
        return mMenuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mMenuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item, null);
        }
        else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.title);
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);

        titleView.setText( mMenuItems.get(position).getTitle() );
        iconView.setImageResource(mMenuItems.get(position).getIcon());

        return view;
    }
}

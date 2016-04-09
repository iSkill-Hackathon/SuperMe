package ie.mylifesolutions.superme.tools;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import ie.mylifesolutions.superme.R;


public class AssertiveToolsFragment extends Fragment {

    private ImageView eyeContact;
    private ImageView brokenRecord;
    private ImageView funnies;
    private ImageView slider;
    private ImageView stopShield;

    public AssertiveToolsFragment() {
        // Required empty public constructor
    }

    public static AssertiveToolsFragment newInstance() {
        return new AssertiveToolsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_assertive_tools, container, false);

        eyeContact = (ImageView) view.findViewById(R.id.tool_eye_contact);
        brokenRecord = (ImageView) view.findViewById(R.id.tool_broken_record);
        funnies = (ImageView) view.findViewById(R.id.tool_funnies);
        slider = (ImageView) view.findViewById(R.id.tool_slider);
        stopShield = (ImageView) view.findViewById(R.id.tool_stop_shield);

        eyeContact.setOnClickListener(toolListener);
        brokenRecord.setOnClickListener(toolListener);
        funnies.setOnClickListener(toolListener);
        slider.setOnClickListener(toolListener);
        stopShield.setOnClickListener(toolListener);

        return view;
    }

    View.OnClickListener toolListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();

            switch (id){
                case R.id.tool_broken_record :
                    showImage(R.drawable.tools_info_broken_record);
                    break;
                case R.id.tool_eye_contact :
                    showImage(R.drawable.tools_info_eye_contact);
                    break;
                case R.id.tool_funnies :
                    showImage(R.drawable.tools_info_funnies);
                    break;
                case R.id.tool_slider:
                    showImage(R.drawable.tools_info_slider);
                    break;
                case R.id.tool_stop_shield :
                    showImage(R.drawable.tools_info_stop_shield);
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

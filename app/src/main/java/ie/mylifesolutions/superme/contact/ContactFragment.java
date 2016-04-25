package ie.mylifesolutions.superme.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import ie.mylifesolutions.superme.R;


public class ContactFragment extends Fragment {

    private EditText mSubject;
    private EditText mMessage;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        mSubject = (EditText) view.findViewById(R.id.subjectText);
        mMessage = (EditText) view.findViewById(R.id.messageText);

        ImageButton sendButton = (ImageButton) view.findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendContact(v);
            }
        });

        return view;
    }

    public void sendContact(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "info@mylifesolutions.ie");
        intent.putExtra(Intent.EXTRA_SUBJECT, mSubject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, mMessage.getText().toString());
        try {
            startActivity(Intent.createChooser(intent, "Send Email"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}

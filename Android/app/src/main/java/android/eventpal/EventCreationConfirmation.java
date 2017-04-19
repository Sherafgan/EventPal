package android.eventpal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class EventCreationConfirmation extends Fragment implements View.OnClickListener {


    private static final String ARG_NAME = "eventName";
    private static final String ARG_TITLE = "eventTitle";
    private static final String ARG_AUTHOR = "eventAuthor";
    private static final String ARG_LOCATION = "eventLocation";

    private String mEventName;
    private String mEventTitle;
    private String mEventAuthor;
    private String mEventLocation;

    private TextView tvName,tvTitle,tvLocation,tvAuthor;
    private Button bConfirm,bCancel;

    private OnFragmentInteractionListener mListener;

    public EventCreationConfirmation() {
        // Required empty public constructor
    }


    public static EventCreationConfirmation newInstance(String param1, String param2,String param3,
                                                        String param4) {
        EventCreationConfirmation fragment = new EventCreationConfirmation();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        args.putString(ARG_TITLE, param2);
        args.putString(ARG_AUTHOR, param3);
        args.putString(ARG_LOCATION, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mEventName = getArguments().getString(ARG_NAME);
            mEventName= getArguments().getString(ARG_TITLE);
            mEventAuthor =getArguments().getString(ARG_AUTHOR);
            mEventTitle=getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_event_creation_confirmation, container, false);
        tvAuthor=(TextView)v.findViewById(R.id.tvEventAuthorConfirmation);
        tvLocation=(TextView)v.findViewById(R.id.tvEventLocationConfirmation);
        tvName=(TextView)v.findViewById(R.id.tvEventNameConfirmation);
        tvTitle=(TextView)v.findViewById(R.id.tvEventDescriptionConfirmation);
        bCancel=(Button)v.findViewById(R.id.bEdit);
        bConfirm=(Button)v.findViewById(R.id.bConfirm);
        bCancel.setOnClickListener(this);
        bConfirm.setOnClickListener(this);
        setTextFields();
        return  v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bConfirm){
           sendToServer();
        }else {
            //TODO: load back the form
        }
    }



    private void setTextFields(){
        tvTitle.setText(mEventTitle);
        tvName.setText(mEventName);
        tvLocation.setText(mEventLocation);
        tvAuthor.setText(mEventAuthor);

    }

    private void sendToServer( ){

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

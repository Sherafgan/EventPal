package android.eventpal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EventCreationForm extends Fragment implements View.OnClickListener {
    private static final String ARG_NAME = "eventName";
    private static final String ARG_TITLE = "eventTitle";
    private static final String ARG_AUTHOR = "eventAuthor";
    private static final String ARG_LOCATION = "eventLocation";


    private String mEventName;
    private String mEventTitle;
    private String mEventAuthor;
    private String mEventLocation;

    private EditText etName,etTitle,etLocation,etAuthor;
    private Button bValidate;



    private OnFragmentInteractionListener mListener;

    public EventCreationForm() {
        // Required empty public constructor
    }


    public static EventCreationForm newInstance(String param1, String param2,String param3,
                                                String param4) {
        EventCreationForm fragment = new EventCreationForm();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        args.putString(ARG_TITLE, param2);
        args.putString(ARG_AUTHOR, param3);
        args.putString(ARG_LOCATION, param4);
        fragment.setArguments(args);
        return fragment;
    }

    public static EventCreationForm newInstance(){

        return new EventCreationForm();
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
        View v =inflater.inflate(R.layout.fragment_event_creation_form, container, false);
        etAuthor=(EditText)v.findViewById(R.id.etEventAuthor);
        etLocation=(EditText)v.findViewById(R.id.etEventLocation);
        etName=(EditText)v.findViewById(R.id.etEventName);
        etTitle=(EditText)v.findViewById(R.id.etEventDescription);
        bValidate=(Button)v.findViewById(R.id.bNext);
        bValidate.setOnClickListener(this);

        return v;
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
        if (v.getId()==R.id.bNext){
            if (validateFields()){
//                TODO:send info to the next fragment
            }
        }
    }

    private boolean validateFields(){
        return false;
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

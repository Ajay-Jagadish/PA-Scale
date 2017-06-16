package app.quiz.thecreator.com.samplequiz.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.quiz.thecreator.com.samplequiz.R;

/**
 * Created by User2 on 12-06-2017.
 */

public class SelfCareFragment extends Fragment {

    Button btnYes,btnNo;
    public static SelfCareFragment newInstance() {
        return new SelfCareFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_selfcare, container, false);
        btnNo=(Button)view.findViewById(R.id.btn_no);
        btnYes=(Button)view.findViewById(R.id.btn_yes);


        return view;
    }
}

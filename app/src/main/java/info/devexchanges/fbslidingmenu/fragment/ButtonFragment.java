package info.devexchanges.fbslidingmenu.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.devexchanges.fbslidingmenu.DetinationActivity;
import info.devexchanges.fbslidingmenu.R;

/**
 * Created by IT-NHThai on 7/9/2016.
 */
public class ButtonFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        View btnGo = view.findViewById(R.id.btn_go);

        //go to other activity when button clicked
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetinationActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

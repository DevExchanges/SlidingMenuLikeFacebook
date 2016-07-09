package info.devexchanges.fbslidingmenu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import info.devexchanges.fbslidingmenu.R;

/**
 * Created by IT-NHThai on 7/9/2016.
 */
public class CheckBoxFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_box, container, false);
        CheckBox checkBox = (CheckBox)view.findViewById(R.id.check);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(getActivity(), "CheckBox is checked!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "CheckBox is unchecked!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}

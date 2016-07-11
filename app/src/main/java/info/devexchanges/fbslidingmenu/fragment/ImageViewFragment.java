package info.devexchanges.fbslidingmenu.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import info.devexchanges.fbslidingmenu.R;

/**
 * Created by IT-NHThai on 7/9/2016.
 */
public class ImageViewFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_image, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.logo);

        imageView.setImageResource(R.drawable.logo);

        //go to my site on click the logo
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.devexchanges.info/"));
                startActivity(browserIntent);
            }
        });

        return view;
    }
}

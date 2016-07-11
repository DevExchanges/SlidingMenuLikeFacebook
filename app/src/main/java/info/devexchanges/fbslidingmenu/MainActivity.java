package info.devexchanges.fbslidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import cn.tovi.CustomMenu;
import info.devexchanges.fbslidingmenu.fragment.ButtonFragment;
import info.devexchanges.fbslidingmenu.fragment.CheckBoxFragment;
import info.devexchanges.fbslidingmenu.fragment.ImageViewFragment;
import info.devexchanges.fbslidingmenu.fragment.MainFragment;
import info.devexchanges.fbslidingmenu.fragment.RadioGroupFragment;
import info.devexchanges.fbslidingmenu.fragment.SeekBarFragment;
import info.devexchanges.fbslidingmenu.fragment.SwitchFragment;
import info.devexchanges.fbslidingmenu.fragment.TextViewFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CustomMenu slidingMenu;
    private ListView slidingListView;
    private View rightMenuView;

    private List<String> strings;
    private Fragment currentFragment;

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        slidingMenu = new CustomMenu(this);

        //Setting Content Layout
        slidingMenu.setContentView(R.layout.activity_main);
        slidingMenu.setRightShadow(R.drawable.shadow_right);

        //Setting the right menu
        rightMenuView = getLayoutInflater().inflate(R.layout.layout_right_menu, slidingMenu, false);
        slidingListView = (ListView) rightMenuView.findViewById(R.id.list);
        slidingMenu.setRightMenu(rightMenuView);

        //set content view for activity after all
        setContentView(slidingMenu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting data for right listview
        setMenuListViewAdapter();

        //handling right listview click listener
        slidingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 2) {
                    replaceFragment(new TextViewFragment());
                } else if (position ==1) {
                    replaceFragment(new ButtonFragment());
                } else if (position == 0) {
                    replaceFragment(new MainFragment());
                } else if (position == 3) {
                    replaceFragment(new ImageViewFragment());
                } else if (position == 4) {
                    replaceFragment(new SwitchFragment());
                } else if (position == 5) {
                    replaceFragment(new CheckBoxFragment());
                } else if (position == 6) {
                    replaceFragment(new RadioGroupFragment());
                } else {
                    replaceFragment(new SeekBarFragment());
                }
                toggleSlidingMenu();
            }
        });

        //replace main fragment when first create activity
        MainFragment fragment = new MainFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_view, fragment);
        ft.commit();
        currentFragment = fragment;
    }

    private void setMenuListViewAdapter() {
        strings = Arrays.asList(getResources().getStringArray(R.array.right_menu));
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        slidingListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu) {
            toggleSlidingMenu();
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleSlidingMenu() {
        if (slidingMenu.getState() == CustomMenu.State.CLOSE_MENU) {
            slidingMenu.openRightMenuIfPossible();
        } else if (slidingMenu.getState() == CustomMenu.State.RIGHT_MENU_OPENS) {
            slidingMenu.closeMenu();
        } else {
            Log.e(TAG, "CustomMenu State:" + slidingMenu.getState());
        }
    }

    private void replaceFragment(Fragment fragment) {
        if (!fragment.getClass().getSimpleName().equals(currentFragment.getClass().getSimpleName())) {
            // Replace fragment main when activity start
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_view, fragment);
            ft.addToBackStack("fragment");
            ft.commit();
            currentFragment = fragment;
        }
    }
}

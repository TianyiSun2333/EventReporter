package com.laioffer.eventreporter;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.laioffer.eventreporter.commentactivity.CommentFragment;

public class MainActivity extends AppCompatActivity implements EventFragment.OnItemSelectListener{

    private EventFragment mListFragment;
    private CommentFragment mGridFragment;

    // implement interface OnItemSelectListener
    // the bridge between main activity and fragment
    @Override
    public void onItemSelected(int position){
        // make main activity a listener, it has a function of this click
        // trigger the function call from event fragment to the comment fragment
        mGridFragment.onItemSelected(position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add list view
        mListFragment = new EventFragment();
        // fragment must stick to the view of activity
        // add: if we rotate the tablet, the fragment will be recreated just like activity
        // so every time after we rotate, 2 new fragment will be created, 2 old fragment will be
        // stored in the memory, finally the memory will run out of space
        // replace = remove + add
        // remove

        // two ways to add fragment to activity
        // 1. ListView(event_fragment.xml) rendered by fragment
        //    activity_main.xml add <fragment> rather than <ListView>
        // like hardcode, not module

        // 2. activity_main.xml add whatever view: fragment container
        //    add the fragment object in that view
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.event_container, mListFragment).commit();


        // add GridView
        if (isTablet()) {
            mGridFragment = new CommentFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.comment_container, mGridFragment).commit();
        }
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }

    // check isTablet by check the width of device
/*    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }*/
//xml boolean value depends on screen size

    // UI is ready
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    // user can see activity
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    // not visible or partially visible when open system dialog
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }
}

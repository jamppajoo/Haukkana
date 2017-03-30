package kide.haukkana;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jammu on 22.3.2017.
 */

public class Tab3ShopInfo extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3shopinfo, container, false);
        Log.d("TAB3APLAAPLAA", "Maked");
        return rootView;
    }
}

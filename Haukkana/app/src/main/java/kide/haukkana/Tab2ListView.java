package kide.haukkana;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Debug;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jammu on 22.3.2017.
 */

public class Tab2ListView extends Fragment  {

    ArrayList<Integer> storeID = new ArrayList<>();
    ArrayList<String> storeName = new ArrayList<>();
    ArrayList<Double> storeLan = new ArrayList<>();
    ArrayList<Double> storeLng = new ArrayList<>();
    ArrayList<Integer> storeInfo = new ArrayList<>();
    ArrayList<String> storeDistance = new ArrayList<>();
    ListView listView;
    Context context;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab2listview, container, false);

        testDataGet();


        //Show listView
        listView = (ListView) rootView.findViewById(R.id.listView);
        //Set adapter to listview and send ArrayList to it
        listView.setAdapter(new ImageAdapter(getActivity().getApplicationContext(),storeName, storeDistance));

        //If listview item is clicked, start new activity and send temp messages to it
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

                Intent intent1 = new Intent(getActivity().getApplicationContext(), ShopinfoActivity.class);
                intent1.putExtra("shopID", ""+ position);
                startActivity(intent1);
            }
        });

        return rootView;
    }
    @Deprecated
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    public void testDataGet(){
        BackEndCommunication BC = new BackEndCommunication();

        storeInfo = BC.storeID;
        storeLng = BC.storeLng;
        storeLan = BC.storeLan;
        storeName = BC.storeName;
        if(storeDistance.size() <= 0)
            for (int i = 0; i < storeName.size(); i++)
                storeDistance.add("Location Error");

    }
}

//ImageAdapter gets Arraylists from Tab2ListView class and shows them
class ImageAdapter extends BaseAdapter {

    private Context context;
    private final ArrayList<String> storeName;
    private final ArrayList<String> storeInfo;

    public ImageAdapter(Context context, ArrayList<String> storeName, ArrayList<String> storeInfo)
    {

        this.context = context;
        this.storeName = storeName;
        this.storeInfo = storeInfo;
        BackEndCommunication BD = new BackEndCommunication();



    }

    //Does magic with listview and combines it with listitem, which has two textviews: itemTextView
    //and subItemTextViews
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linearLayout;

        if(convertView ==null)
        {
            //Get listitem.xml file
            linearLayout = new View(context);
            linearLayout = inflater.inflate(R.layout.listitem, null);

            //Assing messages to it, like "Prisma Limingantulli" and "2.2km away"
            TextView finalStoreName = (TextView) linearLayout.findViewById(R.id.itemTextView);
            TextView finalStoreInfo = (TextView) linearLayout.findViewById(R.id.subItemTextView);

            finalStoreName.setText(storeName.get(position));
            finalStoreInfo.setText(storeInfo.get(position));


        }
        else
            linearLayout = (View) convertView;
        return linearLayout;
//return new View(context);
    }

    @Override
    public int getCount() {
        return storeName.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}

package kide.haukkana;

import android.app.Activity;
import android.content.Context;
import android.os.Debug;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jammu on 22.3.2017.
 */

public class Tab2ListView extends Fragment  {

    ArrayList<String> storeName = new ArrayList<>();
    ArrayList<String> storeInfo = new ArrayList<>();
    //ArrayAdapter<String> adapter;
    ListView listView;
    Context context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab2listview, container, false);


        storeName.add("Prisma Linnanmaa");
        storeInfo.add("2.2km Away");
        storeName.add("S-Market Kaketsu");
        storeInfo.add("1.0km Away");
        storeName.add("Prisma Limingantulli");
        storeInfo.add("19.2km Away");
        Log.d("Tab2ListView ","A");



        listView = (ListView) rootView.findViewById(R.id.listView);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, (List<String>) listView);
        //listView.setAdapter(adapter);


        listView.setAdapter(new ImageAdapter(getActivity().getApplicationContext(),storeName,storeInfo));
        /*ImageAdapter IA = new ImageAdapter(getContext(),storeName,storeInfo);

        listView.setAdapter(IA);
*/
        return rootView;
    }
    @Deprecated
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }
}

class ImageAdapter extends BaseAdapter {

    private Context context;
    private final ArrayList messages;
    private final ArrayList dates;

    public ImageAdapter(Context context, ArrayList messages, ArrayList dates)
    {

        this.context = context;
        this.messages = messages;
        this.dates = dates;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("ASD","ASD");

        View linearLayout;

        if(convertView ==null)
        {
            linearLayout = new View(context);
            linearLayout = inflater.inflate(R.layout.listitem, null);

            TextView message = (TextView) linearLayout.findViewById(R.id.itemTextView);
            TextView date = (TextView) linearLayout.findViewById(R.id.subItemTextView);

            message.setText(messages.get(position).toString());
            date.setText(dates.get(position).toString());
        }
        else
            linearLayout = (View) convertView;
        return linearLayout;
//return new View(context);
    }

    @Override
    public int getCount() {
        return messages.size();
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



package kide.haukkana;

import android.content.Context;
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jammu on 22.3.2017.
 */

public class Tab2ListView extends Fragment {

    ArrayList<String> storeName = new ArrayList<>();
    ArrayList<String> storeInfo = new ArrayList<>();
    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab2listview, container, false);

        storeName.add("Prisma");
        storeInfo.add("Linnanmaa");
        Log.d("ASD","ASD");

/*
        listView = (ListView) container.findViewById(R.id.listView);

        listView.setAdapter(new ImageAdapter(getActivity(),storeName,storeInfo));

*/
        return rootView;
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

package kide.haukkana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShopinfoActivity extends AppCompatActivity {

    ArrayList<ArrayList<String>> storeOffers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopinfo);
        int shopID ;
        String shopName;
        double shopLan, shopLng;

        ArrayList<String> storeOffer = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.shopOffersListView);


        BackEndCommunication BC = new BackEndCommunication();
        shopID = Integer.parseInt(getIntent().getStringExtra("shopID"));
        shopName = BC.returnStoreName(shopID);



        TextView storeName = (TextView) findViewById(R.id.shopName);
        storeName.setText(shopName);

        ShopOffers SO = new ShopOffers();
        storeOffer = SO.returnOffersArraylist(shopID);

        Log.e("ASD", " Shop ID: " + shopID);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, storeOffer);
        listView.setAdapter(arrayAdapter);


    }

}

package kide.haukkana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShopinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopinfo);
        int shopID ;
        String shopName;
        double shopLan, shopLng;

        BackEndCommunication BC = new BackEndCommunication();
        shopID = Integer.parseInt(getIntent().getStringExtra("shopID"));
        shopName = BC.returnStoreName(shopID);
        shopLan = BC.returnStoreLangitude(shopID);
        shopLng = BC.returnStoreLongitude(shopID);

        TextView storeID = (TextView) findViewById(R.id.shopID);
        TextView storeName = (TextView) findViewById(R.id.shopName);
        TextView storeLan = (TextView) findViewById(R.id.shopLan);
        TextView storeLng = (TextView) findViewById(R.id.shopLng);

        storeID.setText("Store ID : " + shopID);
        storeName.setText("Store Name: " + shopName);
        storeLan.setText("Store Langitude: " + shopLan);
        storeLng.setText("Store Longitude: " + shopLng);
    }

}

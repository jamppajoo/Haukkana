package kide.haukkana;

import android.util.Log;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Jammu on 24.4.2017.
 */

public class ShopOffers {

    ArrayList<Integer> shopID = new ArrayList<>();
    ArrayList<ArrayList<String>> offers = new ArrayList<>();

    public ShopOffers(){
        BackEndCommunication BC = new BackEndCommunication();
        shopID = BC.returnAllIDs();

        for(int i = 0; i < shopID.size(); i++)
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(i + ": HK blöö 2.50€");
            temp.add(i + ": Olovi III 12päkki 12€");
            temp.add(i + ": Cameli aski 6€");
            offers.add(temp);
        }

        /*ArrayList<String> temp = new ArrayList<>();
        temp.add("1. HK blöö 2.50€");
        temp.add("1. Olovi III 12päkki 12€");
        temp.add("1. Cameli aski 6€");
        offers.add(temp);
        temp.clear();
        temp.add("2. HK blöö 2.50€");
        temp.add("2. Olovi III 12päkki 12€");
        temp.add("2. Cameli aski 6€");
        offers.add(temp);
        temp.clear();
        temp.add("3. HK blöö 2.50€");
        temp.add("3. Olovi III 12päkki 12€");
        temp.add("3. Cameli aski 6€");
        offers.add(temp);
        temp.clear();
        temp.add("4. HK blöö 2.50€");
        temp.add("4. Olovi III 12päkki 12€");
        temp.add("4. Cameli aski 6€");
        offers.add(temp);
        temp.clear();
        temp.add("5. HK blöö 2.50€");
        temp.add("5. Olovi III 12päkki 12€");
        temp.add("5. Cameli aski 6€");
        offers.add(temp);
        offers.clear();
        Log.e("ASD", " offers size" + offers.get(0));*/
    }

    public ArrayList<String> returnOffersArraylist(int ID){
        return offers.get(ID);
    }
}

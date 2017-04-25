package kide.haukkana;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by Jammu on 24.4.2017.
 */

public class ShopOffers {

    ArrayList<Integer> shopID = new ArrayList<>();
    ArrayList<String> randomOffers = new ArrayList<>();
    ArrayList<ArrayList<String>> offers = new ArrayList<>();

    public ShopOffers(){
        BackEndCommunication BC = new BackEndCommunication();
        shopID = BC.returnAllIDs();

        randomOffers.add("Karjala 100-pack : 104,99€ -> 94.99€ ");
        randomOffers.add("Turun sinappi : 1,49€ -> 0,99€ ");
        randomOffers.add("Naudan Jauheliha 17% : 3,79€ -> 2,89€ pkt ");
        randomOffers.add("Peruna : 1,09€ -> 0,89€ kg ");
        randomOffers.add("Fazer suklaalevyt : 4,99€ -> 3,99€ 2kpl ");
        randomOffers.add("Saarioinen pizza : 1,80€ -> 1,00€ ");
        randomOffers.add("Marli Sima : 3,19€ -> 2,49€ ");
        randomOffers.add("Estrella sipsit : 2,49€ -> 1,99€ ");
        randomOffers.add("Kivennäisvedet 1,5L : 1,50€ -> 1,00€ ");
        randomOffers.add("Sandels 100-pack : 104,99€ -> 94.99€ ");
        randomOffers.add("Felix Ketsuppi : 1,49€ -> 0,99€ ");
        randomOffers.add("Nauta-sika Jauheliha : 3,79€ -> 2,89€ pkt ");
        randomOffers.add("Sipuli : 1,09€ -> 0,89€ kg ");
        randomOffers.add("Marabou suklaalevyt : 4,99€ -> 3,99€ 2kpl ");
        randomOffers.add("Atria pizza : 1,80€ -> 1,00€ ");
        randomOffers.add("Spring Sima : 3,19€ -> 2,49€ ");
        randomOffers.add("Taffel sipsit : 2,49€ -> 1,99€ ");
        randomOffers.add("Virvoitusjuomat 1,5L : 1,50€ -> 1,00€ ");

        for(int i = 0; i < shopID.size(); i++)
        {

            ArrayList<String> temp = new ArrayList<>();
            Random rand = new Random();
            int n;
            for(int k = 0; k < 10; k++)
            {
                n = rand.nextInt(randomOffers.size()-1);
                temp.add(randomOffers.get(n));

            }
            LinkedHashSet<String> temp2 = new LinkedHashSet<>(temp);
            ArrayList<String> finalTemp = new ArrayList<>(temp2);
            offers.add(finalTemp);
        }
    }

    public ArrayList<String> returnOffersArraylist(int ID){
        return offers.get(ID);
    }
}

package kide.haukkana;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jammu on 3.4.2017.
 */

public class BackEndCommunication {

    ArrayList<Integer> storeID = new ArrayList<>();
    ArrayList<String> storeName = new ArrayList<>();
    ArrayList<Double> storeLan = new ArrayList<>();
    ArrayList<Double> storeLng = new ArrayList<>();

    public BackEndCommunication(){
        //Make communication to back end

        storeID.add(0);
        storeName.add("Prisma Limingantulli");
        storeLan.add(64.994249);
        storeLng.add(25.461760);
        storeID.add(1);
        storeName.add("Oulu");
        storeLan.add(65.012360);
        storeLng.add(25.468160);
        storeID.add(2);
        storeName.add("Jammun kämppä :D");
        storeLan.add(64.997768);
        storeLng.add(25.517576);


    }

    public ArrayList<Integer>  returnAllIDs(){

        //Return all Store ID:s

        return storeID;
    }
    public ArrayList<String>  returnAllNames(){

        //Return all Store ID:s

        return storeName;
    }
    public ArrayList<Double>  returnAllLongitudes(){

        //Return all Store longitudes

        return storeLng;
    }
    public ArrayList<Double>  returnAllLatitudes(){

        return storeLan;
    }

    public ArrayList<Float> returnNearestStores(float lan, float lon){

        //return nearest store ID:s depending on given location

        ArrayList<Float> Stores = new ArrayList<>();
        return Stores;
    }
    public String returnStoreName(int ID){


        return storeName.get(ID);
    }
    public Double returnStoreLangitude(int ID){

        //return store langitude with given ID
        return storeLan.get(ID);
    }
    public Double returnStoreLongitude(int ID){

        //return store longitude with given ID
        return storeLng.get(ID);
    }
}

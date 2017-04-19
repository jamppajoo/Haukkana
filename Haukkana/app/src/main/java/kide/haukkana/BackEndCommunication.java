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
    ArrayList<Integer> storeTypeID = new ArrayList<>();
    ArrayList<Double> storeDistance = new ArrayList<>();


    public BackEndCommunication(){
        //Make communication to back end

        storeID.add(0);
        storeName.add("Prisma Limingantulli");
        storeLan.add(64.994249);
        storeLng.add(25.461760);
        storeTypeID.add(1);

        storeID.add(1);
        storeName.add("K- Market Linnanherkku");
        storeLan.add(65.012881);
        storeLng.add(25.476882);
        storeTypeID.add(2);

        storeID.add(2);
        storeName.add("Prisma Raksila");
        storeLan.add(65.010456);
        storeLng.add(25.490556);
        storeTypeID.add(1);

        storeID.add(3);
        storeName.add("K- Citymarket Raksila");
        storeLan.add(65.010075);
        storeLng.add(25.492165);
        storeTypeID.add(2);

        storeID.add(4);
        storeName.add("Lidl Keskusta");
        storeLan.add(65.008294);
        storeLng.add(25.468723);
        storeTypeID.add(3);

        storeID.add(5);
        storeName.add("Lidl Tuira");
        storeLan.add(65.026718);
        storeLng.add(25.469227);
        storeTypeID.add(3);

        storeID.add(6);
        storeName.add("K-Supermarket Joutsensilta");
        storeLan.add(64.999145);
        storeLng.add(25.475278);
        storeTypeID.add(2);

        storeID.add(7);
        storeName.add("S-Market Tuira");
        storeLan.add(65.02506);
        storeLng.add(25.475128);
        storeTypeID.add(1);


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
    public Double returnStoreDistance(int ID){
        return  storeDistance.get(ID);
    }
}

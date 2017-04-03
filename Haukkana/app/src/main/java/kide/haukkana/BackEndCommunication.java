package kide.haukkana;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jammu on 3.4.2017.
 */

public class BackEndCommunication {
    public BackEndCommunication(){
        //Make communication to back end
    }

    public ArrayList<Float>  returnAllIDs(){

        //Return all Store ID:s
        ArrayList<Float> Stores = new ArrayList<>();

        return Stores;
    }
    public ArrayList<Float> returnNearestStores(float lan, float lon){

        //return nearest store ID:s depending on given location

        ArrayList<Float> Stores = new ArrayList<>();
        return Stores;
    }
    public String returnStoreName(int ID){

        return "Prisma Limingantulli";
    }
    public float returnStoreLangitude(int ID){

        //return store langitude with given ID
        float langitude = 0;
        return langitude;
    }
    public float returnStoreLongitude(int ID){

        //return store longitude with given ID
        float longitude = 0;
        return longitude;
    }
}

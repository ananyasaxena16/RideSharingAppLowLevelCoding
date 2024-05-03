package DB;

import Entities.Vehicles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

//Vehicle is a map of userName & Arraylist of vehicles
public class VehicleDao {
    private static HashMap<String, ArrayList<Vehicles>> vehicledao;

    public VehicleDao(){
        this.vehicledao= new HashMap<>();
    }

    public static HashMap<String, ArrayList<Vehicles>> getVehicleDao()
    {
        return vehicledao;
    }
    public void setVehicleDao(HashMap<String, ArrayList<Vehicles>> userdao)
    {
        this.vehicledao=userdao;
    }
}

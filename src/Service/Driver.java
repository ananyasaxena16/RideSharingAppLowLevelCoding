package Service;

import DB.UserDao;
import DB.VehicleDao;
import Entities.User;
import Entities.Vehicles;

import java.util.ArrayList;

public class Driver {
    private UserDao userdao;
    private VehicleDao vehicledao;

    public Driver()
    {
        userdao= new UserDao();
        vehicledao= new VehicleDao();
    }
    public void AddUser(String name, String gender, int age)
    {
        User u = new User(name, gender,age);
        userdao.getUserdao().put(u.getName(), u);
        System.out.println("Added User: " + name+" !");
    }

    public void OfferRide(String userName, String src, String dest, int noOfAvailableSeats, String vehicleName, String vehicleNo, String vehicleType) {

        if(vehicledao.getVehicleDao().get(userName)!=null)
        {
            ArrayList<Vehicles> v = vehicledao.getVehicleDao().get(userName);
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i).carName == vehicleName && v.get(i).isOffered == true) {
                    System.out.println("Can't offer a ride, its already offered!");
                    return;
                }
            }
        }

        if ( userdao.getUserdao().containsKey(userName)) {
            if (vehicledao.getVehicleDao().get(userName) == null) {
                vehicledao.getVehicleDao().put(userName, new ArrayList<>());
            }
            Vehicles nv = new Vehicles(userName, vehicleName, vehicleNo, vehicleType, true, noOfAvailableSeats, src, dest);
            vehicledao.getVehicleDao().get(userName).add(nv);
            userdao.getUserdao().get(userName).setOffered();
            System.out.println(" Ride Offered...");

        } else {
            System.out.println("No such user found! \n Please add user first");
        }
    }

    public void SelectRide(String name, String src, String dest, int noOfSeats, int SelectionStrategy, String selection) {
        if(!userdao.getUserdao().containsKey(name)){
            System.out.println("No such user found! \n Please add user first");
            return;
        }
        if (SelectionStrategy == 1) {
            System.out.println(" Entered Selection Loop");
            for (ArrayList<Vehicles> al : vehicledao.getVehicleDao().values()) {
                for (int i = 0; i < al.size(); i++) {
                    Vehicles v = al.get(i);
                    System.out.println(v.src+" "+v.dest+" "+ v.available+ v.carName);
                    if (v.src == src && v.dest == dest && v.carName == selection) {


                        userdao.getUserdao().get(name).setTaken();
                        System.out.println("Vehicle is ready for you! \n Get ready to Onboard");
                       break;

                    }
                }
            }
        } else if (SelectionStrategy == 2) {
            int maxAvailableSeats = Integer.MIN_VALUE;
            Vehicles maxV = null;
            for (ArrayList<Vehicles> al : vehicledao.getVehicleDao().values()) {
                for (int i = 0; i < al.size(); i++) {
                    Vehicles v = al.get(i);

                    if (v.src == src && v.dest == dest && v.available >= noOfSeats) {
                        if (v.available > maxAvailableSeats) {
                            maxAvailableSeats = v.available;
                            maxV = v;
                        }

                    }
                }
            }
                if (maxV != null) {
                    userdao.getUserdao().get(name).setTaken();
                    System.out.println("Vehicle is ready for you! \n Get ready to Onboard");
                } else {
                    System.out.println("Not Available!\n Try finding something else");
                }




        }else{
            System.out.println("Wrong Selection");

        }


    }
    public void rideStatus()
    {
        for(User key: userdao.getUserdao().values())
        {
            System.out.println(" NAME: "+ key.getName()+" Rides Taken: "+ key.getTaken()+" Rides Offered "+ key.getOffered());

        }

    }
}

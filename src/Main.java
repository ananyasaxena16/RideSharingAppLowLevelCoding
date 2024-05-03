import Service.Driver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Scanner scn = new Scanner(System.in);

        outer: while(true)
        {
            System.out.println("Let's get you a ride!");
            System.out.println("Choose what do you wanna do?");
            System.out.println(" 1. Add User");
            System.out.println(" 2. Offer Ride");
            System.out.println(" 3. Select Ride");
            System.out.println(" 4. Ride status");
            System.out.println(" 5. Exit");
            int choice = scn.nextInt();
            switch(choice){
                case 1 :
                    System.out.println("YOU SELECTED ADD USER");
                    System.out.println("Enter name");
                    String name = scn.next();
                    System.out.println("Enter gender");
                    String gender = scn.next();
                    System.out.println("Enter age");
                    int age = scn.nextInt();
                    driver.AddUser(name, gender, age);
                    break;
                case 2 :
                    System.out.println("YOU SELECTED OFFER RIDE");
                    System.out.println("Enter name");
                    String username = scn.next();
                    System.out.println("Enter src");
                    String src = scn.next();
                    System.out.println("Enter dest");
                    String dest = scn.next();
                    System.out.println("Enter no of available seats");
                    int availableSeats = scn.nextInt();
                    System.out.println("Enter vehicle name");
                    String vehicleName = scn.next();
                    System.out.println("Enter vehicletype");
                    String vehicleType = scn.next();
                    System.out.println("Enter vehicle number");
                    String vehicleNo = scn.next();
                    driver.OfferRide(username, src, dest, availableSeats, vehicleName, vehicleType, vehicleNo);
                    break;
                case 3 :
                    System.out.println("YOU SELECTED SELECT RIDE");
                    System.out.println("Enter name");
                    String uName = scn.next();
                    System.out.println("Enter src");
                    String source = scn.next();
                    System.out.println("Enter dest");
                    String destination = scn.next();
                    System.out.println("Enter no of seats you want");
                    int seats = scn.nextInt();

                    System.out.println("Enter selection number\n Press 1 for carname & Press 2 for maxAvailability in a car");
                    int strategy = scn.nextInt();
                    String selection= null;
                    if(strategy==1)
                    {
                        System.out.println("Enter the car name you want to select:");
                        selection = scn.next();
                    }
                    driver.SelectRide(uName, source, destination, seats, strategy, selection);
                    break;
                case 4 : System.out.println("YOU HAVE SELECTED RIDE STATUS");
                        driver.rideStatus();
                        break;
                case 5 : System.out.println("BBYE!");
                    break outer;
                default: System.out.println("YOU HAVE SELECTED INVALID OPTION. PLEASE REENTER");
                    break;
            }
        }
    }
}
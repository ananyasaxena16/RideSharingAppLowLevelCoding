package Entities;

import java.util.UUID;

public class Vehicles {
    protected String userName;
    public String carName;
    protected String carType;
    protected String carNumber;

    public boolean isOffered;

    public int available;

    public String src;
    public String dest;

    public Vehicles(String userName, String carName, String carNumber, String carType, boolean isOffered, int available, String src, String dest)
    {
        this.carName=carName;
        this.carType=carType;
        this.carNumber=carNumber;
        this.userName=userName;
        this.isOffered=false;
        this.available=available;
        this.src=src;
        this.dest=dest;
    }
}

package Entities;



public class User{
    private String name;
    private String gender;
    private int age;

    private int taken;
    private int offered;


    public User(String name, String Gender, int age)
    {
        this.age=age;
        this.gender= Gender;
        this.name=name;
        this.taken =0;
        this.offered=0;

    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public String getName()
    {
        return name;
    }
    public int age()
    {
        return age;
    }
    public String  getGender()
    {
        return gender;
    }
    public int getTaken()
    {
        return taken;
    }
    public int getOffered()
    {
        return offered;
    }
    public void setTaken()
    {
        this.taken++;
    }
    public void setOffered()
    {
        this.offered++;
    }
}

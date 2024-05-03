package DB;

import Entities.User;

import java.util.HashMap;

public class UserDao {
    private static HashMap<String, User> userdao;

    public UserDao(){
        this.userdao= new HashMap<>();
    }

    public static HashMap<String, User> getUserdao()
    {
        return userdao;
    }
    public void setUserdao(HashMap<String, User> userdao)
    {
        this.userdao=userdao;
    }
}

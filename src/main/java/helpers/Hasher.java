package helpers;

import org.mindrot.jbcrypt.BCrypt;

public class Hasher {
    public String hash(String password){
        return(BCrypt.hashpw(password, BCrypt.gensalt(12)));
    }
    public boolean match(String hashed, String password){
        boolean exp = false;
        if (BCrypt.checkpw(password, hashed))
            exp = true;
        return exp;
    }

}

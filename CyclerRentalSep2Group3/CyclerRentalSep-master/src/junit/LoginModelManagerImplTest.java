package src.junit;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import src.server.database.dao.user.UserDAOImpl;
import src.shared.transferobjects.User;

import static org.junit.jupiter.api.Assertions.*;

class LoginModelManagerImplTest {

    // Change this to your user from database
    private String email ;
    private String password ;

    @Before
    public void setUp() {
        //CHANGE THI
       email= "john@example.com";
       password ="password123";
    }

    @Test
    public void testValidLogin() {
        boolean result;

        UserDAOImpl userDAO = new UserDAOImpl();
        User user = new User(userDAO.get(email));
        if (user.getPassword().equals(password)){
            result= true;
        } else {
            result= false;
        }
        assertFalse(result);
    }

    @Test
    public void testInvalidLogin() {
        boolean result;

        String email = "PUT WRONG EMAIL";
        String password = "PUT WRONG PASS";
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = new User(userDAO.get(email));
        if (user.getPassword().equals(password)){
            result= true;
        } else {
            result= false;
        }
        assertFalse(result);
    }


}
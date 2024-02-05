package src.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.server.database.dao.user.UserDAOImpl;
import src.shared.transferobjects.User;

import static org.junit.jupiter.api.Assertions.*;

class SignupModelManagerImplTest {
    private User user;
    private String email;
    @BeforeEach
    void setUp() {
        email="tesdtEmail";
        user=new User("peter","prettre","4343","fesfsj**","user");
    }

    @Test
    void isNewUser() {
        UserDAOImpl userDAO = new UserDAOImpl();
        //CHANGE THE EMALI TO TES
        assertTrue(userDAO.get(email)==null);
    }

    @Test
    void signUpUser() {
        boolean result;
        UserDAOImpl userDAO = new UserDAOImpl();
        if(userDAO.insert(user))
            result= true;
        else
            result= false;
        assertTrue(result);

    }
}
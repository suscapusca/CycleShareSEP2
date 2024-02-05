package src.server.model.signup;


import src.shared.transferobjects.User;

public interface SignupModelManager {
     boolean isNewUser(User user);
     boolean signUpUser(User user);

}

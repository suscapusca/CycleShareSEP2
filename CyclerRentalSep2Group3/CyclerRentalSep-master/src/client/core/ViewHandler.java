package src.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.client.views.ViewController;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private Stage stageAdmin = new Stage();

    private ViewModelFactory vmf;

    //SCENES LIST
    private Scene loginScene;
    private Scene listBikesScene;
    private Scene listBikesManagerScene;
    private Scene listBookingsManagerScene;
    private Scene createBikeScene;
    private Scene editBikeScene;
    private Scene signUpScene;
    private Scene editBookingScene;
    private Scene createBookingScene;
    private Scene myBookings;


    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openLogin();
    }


    public void openLogin() {
        if (loginScene == null) {
            try {
                Parent root = loadFXML("../views/login/login.fxml");
                loginScene = new Scene(root);
                stage.setTitle("Login");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginScene);
        stage.show();
    }


    public void openSignUp() {
        if (signUpScene == null) {
            try {
                Parent root = loadFXML("../views/signup/sign-up.fxml");

                signUpScene = new Scene(root);
                stage.setTitle("SignUp");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(signUpScene);
        stage.show();
    }

    public void openListBikes() {
        if (listBikesScene == null) {
            try {
                Parent root = loadFXML("../views/bikes/listbikes/listBikes.fxml");

                listBikesScene = new Scene(root);
                stage.setTitle("List bikes");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(listBikesScene);
        stage.show();
    }

    public void openListBikesManager() {
        if (listBikesManagerScene == null) {
            try {
                Parent root = loadFXML("../views/bikes/manager/listBikesManager.fxml");

                listBikesManagerScene = new Scene(root);
                stage.setTitle("List bikes");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(listBikesManagerScene);
        stage.show();
    }

    public void openCreateBike() {
        if (createBikeScene == null) {
            try {
                Parent root = loadFXML("../views/bikes/createBike/createBike.fxml");

                createBikeScene = new Scene(root);
                stage.setTitle("Create bike");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(createBikeScene);
        stage.show();
    }

    public void openEditBike() {
        if (editBikeScene == null) {
            try {
                Parent root = loadFXML("../views/bikes/updateBike/editBike.fxml");

                editBikeScene = new Scene(root);
                stage.setTitle("Edit bike");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(editBikeScene);
        stage.show();
    }

    public void openListBookingManager() {
        if (listBookingsManagerScene == null) {
            try {
                Parent root = loadFXML("../views/bookings/manager/listBookingsManager.fxml");

                listBookingsManagerScene = new Scene(root);
                stage.setTitle("Booking list");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(listBookingsManagerScene);
        stage.show();
    }

    public void openEditBooking(){
        if (editBookingScene == null) {
            try {
                Parent root = loadFXML("../views/bookings/updateBooking/editBooking.fxml");

                editBookingScene = new Scene(root);
                stage.setTitle("Edit Booking");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(editBookingScene);
        stage.show();
    }

    public void openCreateBooking(){
        if (createBookingScene == null) {
            try {
                Parent root = loadFXML("../views/bookings/createBooking/createBooking.fxml");

                createBookingScene = new Scene(root);
                stage.setTitle("Edit Booking");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(createBookingScene);
        stage.show();
    }

    public void openMyBookings() {
        if (myBookings == null) {
            try {
                Parent root = loadFXML("../views/bookings/listbooking/listBookings.fxml");

                myBookings = new Scene(root);
                stage.setTitle("Edit Booking");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(myBookings);
        stage.show();
    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }

    private Parent loadWindow(String path) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        return root;
    }

}

package src.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.server.database.dao.bike.BikeDAO;
import src.server.database.dao.bike.BikeDAOImpl;
import src.shared.transferobjects.Bike;

import static org.junit.jupiter.api.Assertions.*;

class BikeModelManagerImplTest {
    private Bike bike;
    @BeforeEach
    void setUp() {
        bike= new Bike("trek","Mutanf",true,2022,1999);

    }

    @Test
    void insertBike() {
        BikeDAO subjectsDAO= new BikeDAOImpl();
        assertTrue(subjectsDAO.insert(bike));
    }
}
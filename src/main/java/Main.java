import dao.*;
import models.*;
import utils.HibernateUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            deleteAllData();

            // streets
            Street street1 = new Street("Sadova");
            Street street2 = new Street("Avenu");

            // houses
            House house1 = new House(street1);
            House house2 = new House(street1);
            House house3 = new House(street2);

            DAO<House> housesDAO = new HouseDAO();
            housesDAO.create(house1);
            housesDAO.create(house2);
            housesDAO.create(house3);

            // yards
            DAO<Yard> yardsDAO = new YardDAO();
            yardsDAO.create(new Yard(50, house2));
            yardsDAO.create(new Yard(10, house3));
            yardsDAO.create(new Yard(35, house1));

            // owners
            Owner owner1 = new Owner("James");
            Owner owner2 = new Owner("Mike");
            Owner owner3 = new Owner("Tom");

            DAO<OwnersAndHousesRegistration> ownersRegistrationDAO = new OwnersAndHousesRegistrationDAO();
            ownersRegistrationDAO.create(new OwnersAndHousesRegistration(house3, owner2));
            ownersRegistrationDAO.create(new OwnersAndHousesRegistration(house3, owner1));
            ownersRegistrationDAO.create(new OwnersAndHousesRegistration(house2, owner1));
            ownersRegistrationDAO.create(new OwnersAndHousesRegistration(house1, owner3));

        } catch (Exception e) {
            e.printStackTrace();
        }

        HibernateUtil.closeSessionFactory();

    }

    private static void deleteAllData() {

        DAO<Street> streetsDAO = new StreetDAO();

        List<Street> streets = streetsDAO.readAll();
        streets.forEach(streetsDAO::delete);

    }

}

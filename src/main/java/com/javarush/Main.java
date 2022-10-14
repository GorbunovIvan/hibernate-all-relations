package com.javarush;

import com.javarush.models.*;
import com.javarush.services.AutoService;
import com.javarush.services.UserService;
import com.javarush.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            deleteUsers();

            UserService userService = new UserService();

            // creating user
            User user = new User("Masha",26);
            userService.saveUser(user);

            User user2 = new User("Dima",31);
            userService.saveUser(user2);

            // creating autos and add them to user
            Auto ferrari = new Auto("Ferrari", "red");
            user.addAuto(ferrari);

            Auto ford = new Auto("Ford", "black");
            user.addAuto(ford);

            userService.updateUser(user);

            // changing name of user
            user.setName("Sasha");
            userService.updateUser(user);

            stuffAutos();

            addGasStations();

        } catch (Exception e) {
            e.printStackTrace();
        }

        HibernateSessionFactoryUtil.closeSessionFactory();

    }

    private static void stuffAutos() {

        AutoService autoService = new AutoService();

        List<Auto> autos = autoService.findAllAutos();

        for (Auto auto : autos) {

            for (int i = 0; i < 4; i++)
                auto.addWheel(new Wheel(auto));

            auto.setEngine(new Engine(200, 3, auto));

            autoService.updateAuto(auto);

        }

    }

    private static void addGasStations() {

        UserService userService = new UserService();

        List<User> users = userService.findAllUsers();
        User user1 = users.get(0);
        User user2 = users.get(1);

        GasStation gasStation1 = new GasStation("Rue Street 8");
        GasStation gasStation2 = new GasStation("District Columbia 1");
        GasStation gasStation3 = new GasStation("Gotham 32");

        user1.addGasStation(new UsersAndGasStations(user1, gasStation1));
        user1.addGasStation(new UsersAndGasStations(user1, gasStation2));

        user2.addGasStation(new UsersAndGasStations(user2, gasStation1));
        user2.addGasStation(new UsersAndGasStations(user2, gasStation3));

        userService.updateUser(user1);
        userService.updateUser(user2);

    }

    private static void deleteUsers() {

        UserService userService = new UserService();

        List<User> users = userService.findAllUsers();
        users.forEach(userService::deleteUser);

    }

}
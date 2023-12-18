package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("User4", "Lastname4", "user4@mail.ru");
        User user2 = new User("User1", "Lastname1", "user1@mail.ru");
        User user3 = new User("User2", "Lastname2", "user2@mail.ru");
        User user4 = new User("User3", "Lastname3", "user3@mail.ru");
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        carService.add(new Car("mazda", 1337, user1));
        carService.add(new Car("Range Rover", 2024, user2));
        carService.add(new Car("Lada", 666, user3));
        carService.add(new Car("Honda", 1945, user4));


        List<User> users = userService.getAll();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel());
            System.out.println();
        }

        User findUser = userService.getUserByCar("mazda", 1337);
        System.out.println("Я нашел: " + findUser.getId());

        context.close();
    }
}

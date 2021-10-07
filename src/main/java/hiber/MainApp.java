package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Oleg", "Olegov", "ole@mail.ru");
        user1.setCar(new Car("oleg'sCar", 1));
        User user2 = new User("Alesha", "Ales", "al@mail.ru");
        user2.setCar(new Car("Alesha'sCar", 2));
        User user3 = new User("Dimon", "Dim", "DimDim@mail.ru");
        user3.setCar(new Car("Dimon'sCar", 3));
        User user4 = new User("Joseph", "Josephson", "Jojo@mail.ru");
        user4.setCar(new Car("Jojo'sCar", 4));

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getCar());
            System.out.println();
        }

        User test = userService.getUser("Jojo'sCar", 4);
        System.out.println(test);

        context.close();
    }
}

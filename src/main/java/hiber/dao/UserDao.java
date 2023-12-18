package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   Long add(User user);
   List<User> listUsers();

   User getUserByCar(String model, int series);
}

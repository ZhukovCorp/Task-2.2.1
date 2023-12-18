package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    Long add(User user);
    List<User> getAll();
    User getUserByCar(String model, int series);
}

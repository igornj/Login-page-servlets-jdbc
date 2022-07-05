package br.igornj.db.dao;

import br.igornj.db.model.User;

import java.util.List;
import java.util.Optional;

public interface iUsersDAO {

    User save(User image);

    Optional<User> loginUser(String username, String password);

    List<User> findAll();

    void update(int userId, User user);

    void delete(int id);

    int newPassword(String email, String newPassword);
}

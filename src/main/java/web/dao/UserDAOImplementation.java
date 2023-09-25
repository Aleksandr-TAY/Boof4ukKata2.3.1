package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImplementation implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(String name, String surname) {
        User user = new User(name, surname);
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void updateUser(int id, String name, String surname) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(name);
            user.setSurname(surname);
        }
    }

    public List<User> getUserTable() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}

package web.hiber.dao;

import org.springframework.stereotype.Repository;
import web.hiber.model.Car;
import web.hiber.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);//(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        User userToUpdate = entityManager.find(User.class, user.getId());
        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setLastName(user.getLastName());
            entityManager.persist(userToUpdate);
        }
        else {
            throw new RuntimeException("No such user!!!"+user.getId());
        }
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
        TypedQuery<User> hql = entityManager.createQuery("select u from User u", User.class);
        return hql.getResultList();
    }
}

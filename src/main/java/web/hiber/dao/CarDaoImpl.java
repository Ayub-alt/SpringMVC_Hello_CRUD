package web.hiber.dao;

import org.springframework.stereotype.Repository;
import web.hiber.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void addCar(Car car) {
        entityManager.persist(car);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Car> listCars() {
        TypedQuery<Car> hql = entityManager.createQuery("select c from Car c", Car.class);
        return hql.getResultList();
    }
}

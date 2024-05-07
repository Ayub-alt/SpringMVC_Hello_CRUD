package web.hiber.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.hiber.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Override
    public void addCar(Car car) {

    }

    @Override
    public List<Car> listCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Van", 2221, 2000));
        cars.add(new Car("Track", 3241, 2006));
        cars.add(new Car("PickUp", 8121, 2003));
        cars.add(new Car("SuperCar", 6221, 2009));
        cars.add(new Car("Lada", 4291, 2002));
        return cars;
    }
}

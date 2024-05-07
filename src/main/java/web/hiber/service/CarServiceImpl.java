package web.hiber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.hiber.dao.CarDao;
import web.hiber.model.Car;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao carDao;

    //@Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    //@Transactional()
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

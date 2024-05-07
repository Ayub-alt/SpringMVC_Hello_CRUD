package web.hiber.dao;

import web.hiber.model.Car;

import java.util.List;

public interface CarDao {
    void addCar(Car car);
    List<Car> listCars();
}

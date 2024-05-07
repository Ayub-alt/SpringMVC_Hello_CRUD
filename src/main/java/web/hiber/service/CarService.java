package web.hiber.service;

import web.hiber.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<Car> listCars();
}

package refueling.service;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import refueling.component.FuelGetterRowMapper;
import refueling.model.Car;
import refueling.model.FuelGetter;
import refueling.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import refueling.repository.CarRepository;
import refueling.repository.FuelGetterRepository;
import refueling.repository.RequestRepository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Scope("prototype")
public class RequestService implements Runnable {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private FuelGetterRepository fuelGetterRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private FuelGetterRowMapper fuelGetterRowMapper;

    private double price;
    private int pricePercent;

    private Queue<Car> carQueue;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(int pricePercent) {
        this.pricePercent = pricePercent;
    }

    private List<FuelGetter> fuelGetterList;

    public RequestService() {
        this.carQueue = new LinkedList<>();
    }

    public void addClient(Car client) {
        carQueue.offer(client);
        //System.out.println(carQueue.size());
    }


    public void startRefueling() {
        if (carQueue.isEmpty()) {
            return;
        }
        Random rnd = new Random();
        FuelGetter nowFG;
        nowFG = fuelGetterList.get(rnd.nextInt(fuelGetterList.size()));
        Boolean isFree = false;

        for (FuelGetter checkFG : fuelGetterList) {
            if (checkFG.getState()) {
                isFree = true;
            }
        }
        if (isFree) {
            while (!nowFG.getState()) {
                nowFG = fuelGetterList.get(rnd.nextInt(fuelGetterList.size()));
            }
            Car car = carQueue.poll();
            //System.out.println(car.toString());
            nowFG.setClient(car);

            Request request = new Request(null, car, nowFG, car.toFull(), car.toFull() * this.getPrice() + this.getPrice() * this.pricePercent / 100);
            new Thread(nowFG).start();
            carRepository.save(car);
            requestRepository.save(request);

            //System.out.println(request.toString());
            //return request.toString();
        }
        //  else {// return null;}
    }

    // @Transactional
    /*public void printFuelGetters() {
        List<FuelGetter> fuelGetter = fuelGetterRepository.findAll();
        for (FuelGetter fg :
                fuelGetter) {
            fg.standartInit(fg.getName());
            System.out.println(fg.toString());
        }
    }*/

    public List<FuelGetter> getFuelGetters() {
        List<FuelGetter> fuelGetter = fuelGetterRepository.findAll();
        for (FuelGetter fg :
                fuelGetter) {
            fg.standartInit(fg.getName());
        }
        return fuelGetter;
    }

    public void setFuelGetterList() {
        this.fuelGetterList = getFuelGetters();
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                startRefueling();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

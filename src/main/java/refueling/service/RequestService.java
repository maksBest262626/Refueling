package refueling.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import refueling.component.FuelGetterRowMapper;
import refueling.model.Car;
import refueling.model.FuelGetter;
import refueling.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import refueling.repository.FuelGetterRepository;
import refueling.repository.RequestRepository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Scope("prototype")
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private FuelGetterRepository fuelGetterRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private FuelGetterRowMapper fuelGetterRowMapper;
    @Autowired
    private Car car;
    @Autowired
    private List<FuelGetter> fuelGetterList;

    public String start(){
        Random rnd = new Random();
        FuelGetter nowFG;
        nowFG = fuelGetterList.get(rnd.nextInt(fuelGetterList.size()));
        while (!nowFG.getState()) {
            nowFG = fuelGetterList.get(rnd.nextInt(fuelGetterList.size()));
        }
        Request request = new Request(null,car,nowFG,car.toFull(), car.toFull());
        nowFG.setState(false);
        return request.toString();
    }

    @Transactional
    public void  printFuelGetters() {
        List<FuelGetter> fuelGetter = fuelGetterRepository.findAll();
        for (FuelGetter fg:
             fuelGetter) {
            fg.standartInit(fg.getName());
            System.out.println(fg.toString());
        }

    }

}

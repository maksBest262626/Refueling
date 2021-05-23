package refueling.service;

import refueling.model.Car;
import refueling.model.FuelGetter;
import refueling.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Scope("prototype")
public class RequestService {

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
        Request request = new Request(car,nowFG,car.toFull());
        nowFG.setState(false);
        return request.toString();
    }
}

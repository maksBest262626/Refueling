
import refueling.component.FuelGetterRowMapper;
import refueling.config.SpringDataConfig;
import refueling.model.Car;
import refueling.model.Request;
import refueling.repository.FuelGetterRepository;
import refueling.service.RequestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.sql.SQLException;

@Configuration
@ComponentScan(basePackageClasses = {
        SpringDataConfig.class,
        RequestService.class,
        Car.class,
        FuelGetterRowMapper.class,
        FuelGetterRepository.class})
public class SampleAppliation {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SampleAppliation.class,  refueling.config.SpringDataConfig.class);


        Car client = context.getBean(Car.class);

        RequestService requestService = client.getRequestService();
        requestService.setFuelGetterList();
        requestService.setPrice(40);
        requestService.setPricePercent(10);
        new Thread(client).start();
        new Thread(requestService).start();
        System.out.println("Бензозаправочная станция отрыта! Ожидаем клиента :)");

       /* requestService = context.getBean(RequestService.class);
        requestService.setFuelGetterList();
        requestService.printFuelGetters();
        requestService.start(client);*/



    }
}

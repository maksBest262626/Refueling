
import refueling.component.FuelGetterRowMapper;
import refueling.config.DumbConfig;
import refueling.config.SpringDataConfig;
import refueling.model.Request;
import refueling.repository.DumbRepository;
import refueling.service.DumbService;
import refueling.service.RequestService;
import refueling.service.SampleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.sql.SQLException;

@Configuration
@ComponentScan(basePackageClasses = {
        DumbConfig.class,
        SpringDataConfig.class,
        DumbService.class,
       // Car.class,
        FuelGetterRowMapper.class,
        DumbRepository.class})
public class SampleAppliation {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SampleAppliation.class, refueling.config.ApplicationConfig.class, refueling.config.SpringDataConfig.class);
        //ApplicationContext context = new AnnotationConfigApplicationContext(SampleAppliation.class);
        SampleService sampleService = context.getBean(SampleService.class);
        RequestService requestService = context.getBean(RequestService.class);
        Request req = context.getBean("request",Request.class);

//        System.out.println(req.toString());
//        ApplicationConfig config = new ApplicationConfig();
//        config.getCar();
//        config.request();
//        req = context.getBean("request",Request.class);
//        System.out.println(req.toString());
//        System.out.println(requestService.start());

       /* requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());*/

        /*requestService = context.getBean(RequestService.class);
        requestService.Test();*/ // Это тест простейшего чтения из бд с помощью jdbc без спринга

       /* requestService = context.getBean(RequestService.class);
        requestService.TestWithTemplate();*/ // Это тест чтения из бд с помощью jdbcTemplate, и rowMapper
        requestService = context.getBean(RequestService.class);
        requestService.printFuelGetters();

        assert sampleService != null;
    }
}

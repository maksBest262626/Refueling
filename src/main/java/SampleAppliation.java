
import di.component.DumbComponent;
import di.config.ApplicationConfig;
import di.config.DumbConfig;
import di.model.Car;
import di.model.Request;
import di.repository.DumbRepository;
import di.service.DumbService;
import di.service.RequestService;
import di.service.SampleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = {
        DumbConfig.class,
        DumbService.class,
       // Car.class,
        DumbComponent.class,
        DumbRepository.class})
public class SampleAppliation {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SampleAppliation.class, di.config.ApplicationConfig.class);
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

        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());
        requestService = context.getBean(RequestService.class);
        System.out.println(requestService.start());

        assert sampleService != null;
    }
}

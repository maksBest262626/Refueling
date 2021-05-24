package refueling.config;

import refueling.model.Car;
import refueling.model.FuelGetter;
import refueling.model.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {
    @Bean("car")
    @Scope("prototype")
    public Car getCar() {
        Car car = new Car();
        car.Init();
        return car;
    }

    @Bean("fg1")
    public FuelGetter getfg1() {
        FuelGetter fg = new FuelGetter();
        fg.standartInit("fg1");
        return fg;
    }
    @Bean("fg2")
    public FuelGetter getfg2() {
        FuelGetter fg = new FuelGetter();
        fg.standartInit("fg2");
        return fg;
    }
    @Bean("fg3")
    public FuelGetter getfg3() {
        FuelGetter fg = new FuelGetter();
        fg.standartInit("fg3");
        return fg;
    }
    @Bean("fg4")
    public FuelGetter getfg4() {
        FuelGetter fg = new FuelGetter();
        fg.standartInit("fg4");
        return fg;
    }
    @Bean("fg5")
    public FuelGetter getfg5() {
        FuelGetter fg = new FuelGetter();
        fg.standartInit("fg5");
        return fg;
    }
    @Bean
    @Scope("prototype")
    public Request request() {
        Request request = new Request(null,getCar(),getfg1(),getCar().toFull(),getCar().toFull());
        return request;
    }
}

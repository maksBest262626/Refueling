package di.config;

import di.model.Car;
import di.model.FuelGetter;
import di.model.Request;
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
        fg.StandartInit(1);
        return fg;
    }
    @Bean("fg2")
    public FuelGetter getfg2() {
        FuelGetter fg = new FuelGetter();
        fg.StandartInit(2);
        return fg;
    }
    @Bean("fg3")
    public FuelGetter getfg3() {
        FuelGetter fg = new FuelGetter();
        fg.StandartInit(3);
        return fg;
    }
    @Bean("fg4")
    public FuelGetter getfg4() {
        FuelGetter fg = new FuelGetter();
        fg.StandartInit(4);
        return fg;
    }
    @Bean("fg5")
    public FuelGetter getfg5() {
        FuelGetter fg = new FuelGetter();
        fg.StandartInit(5);
        return fg;
    }
    @Bean
    @Scope("prototype")
    public Request request() {
        Request request = new Request(getCar(),getfg1(),getCar().toFull());
        return request;
    }
}

package refueling.model;


import org.springframework.beans.factory.annotation.Autowired;
import refueling.Type;
import refueling.service.RequestService;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "car")
public class Car implements Runnable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mark")
    private String mark;
    @Column(name = "model")
    private String model;

    @Transient
    private Type fuel;
    @Column(name = "volume")
    private double volume;
    @Column(name = "balance")
    private double balance;

    @Column(name = "fuel")
    private String fuelType;

    @Transient
    @Autowired
    private RequestService requestService;

    public Car() {
    }


    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuel(Type fuel) {
        this.fuel = fuel;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public Type getFuel() {
        return fuel;
    }

    public double getVolume() {
        return volume;
    }

    public double getBalance() {
        return balance;
    }

    public Car(Integer id, String mark, String model, Type fuel, double volume, double balance) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.fuel = fuel;
        this.volume = volume;
        this.balance = balance;
    }
    public void Init (){
        Random rnd = new Random();
        this.mark = getName(3+rnd.nextInt(7));
        this.model = getName(3+rnd.nextInt(7));
        this.fuel = getRandomType();
        this.volume = 30+rnd.nextInt(30);
        this.balance = getVolume()- rnd.nextInt((int)getVolume()-20) - 10;
        this.fuelType= this.fuel.toString();
    }

    private Type getRandomType() {
        int pick = new Random().nextInt(Type.values().length);
        return Type.values()[pick];
    }
    private char getChar() {
        Random rnd = new Random();
        char[] alphabetA = new String("abcdefghijklmnopqrstuvwxyz").toCharArray();
        return alphabetA[rnd.nextInt(alphabetA.length)];
    }

    private String getName(int sz) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sz; i++)
            sb.append(getChar());
        return new String(sb);
    }


    public double toFull(){
        return this.volume-this.balance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", fuel=" + fuel +
                ", volume=" + volume +
                ", balance=" + balance +
                '}';
    }

    @Override
    public void run() {
        while(true) {
            try {
                Calendar c = Calendar.getInstance();
                Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                Integer time = 5;
                if (dayOfWeek != 1 && dayOfWeek != 6 && dayOfWeek != 7) { time +=10; }
                // Если не суббота, пятница, воскресенье то меньше клиентов будет.

                Integer hourOfDay = c.get(Calendar.HOUR_OF_DAY);
                if (hourOfDay >=6 && hourOfDay <=9 || hourOfDay >=17 && hourOfDay <= 20) { } else { time +=10; }
                // Если не час пик то клиента придется ждать еще дольше.

                time += requestService.getPricePercent()*3*time/100;
                //С каждым процентом наценки покупателей становится на три процента меньше.

                TimeUnit.SECONDS.sleep(time);
                System.out.println("Приехал новый клиент!!!");
                Car client = new Car();
                client.Init();
                requestService.addClient(client);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public RequestService getRequestService() {
        return requestService;
    }
}

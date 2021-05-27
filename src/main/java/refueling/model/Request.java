package refueling.model;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   // @ManyToOne
   // @JoinColumn(name = "client")
    @Transient
    private Car client;

   // @ManyToOne
   // @JoinColumn(name = "fuelgetter")
   @Transient
    private FuelGetter fuelGetter;

    @Column(name = "countOfFuel")
    private Double countOfFuel;

    @Column(name = "money")
    private Double money;

    public Request(Integer id, Car client, FuelGetter fuelGetter, Double countOfFuel, Double money) {
        this.id = id;
        this.client = client;
        this.fuelGetter = fuelGetter;
        this.countOfFuel = countOfFuel;
        this.money = money;
    }

    public Request() {
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", client=" + client +
                ", fuelGetter=" + fuelGetter +
                ", countOfFuel=" + countOfFuel +
                ", money=" + money +
                '}';
    }
}

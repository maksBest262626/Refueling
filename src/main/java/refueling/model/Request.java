package refueling.model;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Car client;

    @ManyToOne
    @JoinColumn(name = "id_fg")
    private FuelGetter fuelGetter;

    @Transient
    private Integer id_fg;




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
        this.id_fg = this.fuelGetter.getId();
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

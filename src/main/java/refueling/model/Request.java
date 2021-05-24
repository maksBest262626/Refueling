package refueling.model;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Car client;

    @ManyToOne
    @JoinColumn(name = "fuelgetter_id")
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


    public String toString() {
        return client.getMark()+" "+client.getModel()+" Buy fuel= "+client.getFuel()+" count:"+this.countOfFuel+" FUEL GETTER NAME=:"+this.fuelGetter.getName();
    }


}

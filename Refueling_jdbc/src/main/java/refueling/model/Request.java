package refueling.model;

public class Request {
    Car client;
    FuelGetter fuelGetter;
    Double countOfFuel;

    public Request() {
    }

    public Request(Car client, FuelGetter fuelGetter, Double countOfFuel) {
        this.client = client;
        this.fuelGetter = fuelGetter;
        this.countOfFuel = countOfFuel;
    }

    public String toString() {
        return client.getMark()+" "+client.getModel()+" Buy fuel= "+client.getFuel()+" count:"+this.countOfFuel+" FUEL GETTER NAME=:"+this.fuelGetter.getName();
    }


}

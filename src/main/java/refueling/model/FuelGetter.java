package refueling.model;

import java.util.HashSet;

public class FuelGetter {
    private int number;

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    private HashSet<Type> typeSet;
    private Boolean state;

    public FuelGetter() {
    }

    public FuelGetter(int number, HashSet<Type> typeSet, Boolean state) {
        this.number = number;
        this.typeSet = typeSet;
        this.state= state;
    }

    public void StandartInit(int number) {
        this.number = number;
        this.typeSet = new HashSet<>();
        this.typeSet.add(Type.Ai_92);
        this.typeSet.add(Type.Ai_95);
        this.typeSet.add(Type.Ai_100);
        this.typeSet.add(Type.Diesel_Summer);
        this.typeSet.add(Type.Diesel_Winter);
        this.state = true;
    }

    public void addTypeFuel(Type fuel){
        this.typeSet.add(fuel);
    }

    public boolean containTypeFuel(Type fuel){
        return this.typeSet.contains(fuel);
    }

    public int getNumber() {
        return number;
    }

    public HashSet<Type> getTypeSet() {
        return typeSet;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTypeSet(HashSet<Type> typeSet) {
        this.typeSet = typeSet;
    }
}


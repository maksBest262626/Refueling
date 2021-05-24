package refueling.model;

import java.util.HashSet;

public class FuelGetter {
    private String name;
    private HashSet<Type> typeSet;
    private Boolean state;

    public FuelGetter() {
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    public FuelGetter(String name, HashSet<Type> typeSet, Boolean state) {
        this.name = name;
        this.typeSet = typeSet;
        this.state= state;
    }

    public void StandartInit(String name) {
        this.name = name;
        this.typeSet = new HashSet<>();
        this.typeSet.add(Type.Ai_92);
        this.typeSet.add(Type.Ai_95);
        this.typeSet.add(Type.Ai_100);
        this.typeSet.add(Type.Diesel_Summer);
        this.typeSet.add(Type.Diesel_Winter);
        this.state = true;
    }

    @Override
    public String toString() {
        return "FuelGetter{" +
                "name='" + name + '\'' +
                ", typeSet=" + typeSet +
                ", state=" + state +
                '}';
    }

    public void addTypeFuel(Type fuel){
        this.typeSet.add(fuel);
    }

    public boolean containTypeFuel(Type fuel){
        return this.typeSet.contains(fuel);
    }

    public String getName() {
        return name;
    }

    public HashSet<Type> getTypeSet() {
        return typeSet;
    }

    public void setNumber(String name) {
        this.name = name;
    }

    public void setTypeSet(HashSet<Type> typeSet) {
        this.typeSet = typeSet;
    }
}


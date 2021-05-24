package refueling.model;

import refueling.Type;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "fuelgetter")
public class FuelGetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Transient
    private HashSet<Type> typeSet;

    @Transient
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

    public void standartInit(String name) {
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


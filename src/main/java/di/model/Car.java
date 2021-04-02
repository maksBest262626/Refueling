package di.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

//@Component
public class Car {

    private String mark;
    private String model;
    private Type fuel;
    private double volume;
    private double balance;


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

    public Car(String mark, String model, Type fuel, double volume, double balance) {
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

}

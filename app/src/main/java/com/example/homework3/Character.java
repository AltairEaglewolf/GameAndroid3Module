package com.example.homework3;

public class Character {
    public int Health;
    public int Fatigue;
    public int Panic;
    public String name;

    public Character(String name) {
        Health = 100;
        Fatigue = 0;
        Panic = 30;
        this.name = name;
    }

}

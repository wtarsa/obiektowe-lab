package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

public class World {
    public static void main(String[] args){
        Animal cat = new Animal();
        OptionsParser parser = new OptionsParser();
        MoveDirection[] directions = parser.parse(args);
        for(MoveDirection dir : directions){
            cat.move(dir);
        }
        System.out.println(cat.toString());
    }
}

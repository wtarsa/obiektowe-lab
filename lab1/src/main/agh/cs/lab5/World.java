package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.GrassField;
import agh.cs.lab5.Grass;

public class World {
    public static void main(String args[]) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField field = new GrassField(10);
        field.placeGrassTufts();
        field.place(new Animal(field));
        field.place(new Animal(field, new Vector2d(3, 4)));
        field.run(directions);
        System.out.println(field.toString());
    }
}

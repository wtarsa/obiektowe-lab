package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.UnboundedMap;
import agh.cs.lab5.HayStack;

public class World {
    public static void main(String args[]) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        UnboundedMap map = new UnboundedMap(4);
        map.placeHayStack(new Vector2d(-4, -4));
        map.placeHayStack(new Vector2d(7, 7));
        map.placeHayStack(new Vector2d(3, 6));
        map.placeHayStack(new Vector2d(2, 0));
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        System.out.println(map.toString());
    }
}

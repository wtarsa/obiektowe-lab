package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab3.Animal;

public class World {
    public static void main(String args[]) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        System.out.println(map.toString());
    }
}
   /* f b r l f f r r f f f f f f f f*/
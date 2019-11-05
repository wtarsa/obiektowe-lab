package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {

    protected Vector2d upperRight;
    protected Vector2d lowerLeft;
    protected ArrayList<Animal> animals = new ArrayList<Animal>();
    protected ArrayList<Grass> tufts = new ArrayList<Grass>();

    @Override
    public boolean canMoveTo(Vector2d position){
        return (!isOccupied(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight));
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    public String toString(){
        MapVisualizer mapInstance = new MapVisualizer(this);
        return mapInstance.draw(lowerLeft, this.upperRight);
    }
}

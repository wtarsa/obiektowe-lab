package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;

public class AbstractWorldMap {

    private Vector2d upperRight;
    private static final Vector2d lowerLeft = new Vector2d(0, 0);
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public AbstractWorldMap(){
        
    }

    public boolean canMoveTo(Vector2d position){
        return (!isOccupied(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight));
    }

    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    public Object objectAt(Vector2d position) {
        for(Animal animal : this.animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        for(HayStack stack: this.stacks){
            if(position.equals(stack.getPosition())) return stack;
        }
        return null;
    }

    public String toString(){
        MapVisualizer mapInstance = new MapVisualizer(this);
        return mapInstance.draw(this.lowerLeft, this.upperRight);
    }
}

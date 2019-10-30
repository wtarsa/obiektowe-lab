package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.ArrayList;


public class RectangularMap implements IWorldMap {

    private Vector2d upperRight;
    private static final Vector2d lowerLeft = new Vector2d(0, 0);
    private ArrayList<Animal> animals = new ArrayList<Animal>();


    public RectangularMap(int width, int height){
        this.upperRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return (!isOccupied(position) && position.follows(lowerLeft) && position.precedes(this.upperRight));
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
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++){
            this.animals.get(i%this.animals.size()).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : this.animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        return null;
    }

    public String toString(){
        MapVisualizer mapInstance = new MapVisualizer(this);
        return mapInstance.draw(lowerLeft, this.upperRight);
    }
}

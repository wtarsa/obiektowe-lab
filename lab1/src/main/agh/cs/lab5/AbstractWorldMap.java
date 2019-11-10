package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class AbstractWorldMap implements IWorldMap {

    protected Vector2d upperRight;
    protected Vector2d lowerLeft;
    protected HashMap<Vector2d, Animal> fasterAnimals = new LinkedHashMap<>();

    @Override
    public boolean place(Animal animal) {
        try{
            if(isOccupied(animal.getPosition()))
                throw new IllegalArgumentException("This field is occupied!") ;
            this.fasterAnimals.put(animal.getPosition(), animal);
            return true;
        }
        catch (IllegalArgumentException a){
            System.out.println("Exception thrown  :" + a);
            return false;
        }
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; ) {
            Vector2d[] positions = fasterAnimals.keySet().toArray(new Vector2d[0]);
            for(int j = 0; j < positions.length && i < directions.length; j++){
                Animal currentAnimal = fasterAnimals.get(positions[j]);
                currentAnimal.move(directions[i]);
                fasterAnimals.remove(positions[j]);
                fasterAnimals.put(currentAnimal.getPosition(), currentAnimal);
                i++;
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }


}

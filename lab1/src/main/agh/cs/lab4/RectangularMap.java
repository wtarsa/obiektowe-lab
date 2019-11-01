package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab5.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {

    public RectangularMap(int width, int height){
        this.upperRight = new Vector2d(width, height);
        this.lowerLeft = new Vector2d(0, 0);
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++){
            this.animals.get(i%this.animals.size()).move(directions[i]);
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : this.animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        return null;
    }

}

package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import java.util.Random;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    private int tuftOfGrassNumber = 0;
    private static final Vector2d v_0_0 = new Vector2d(0, 0);

    public GrassField(int number){
        this.tuftOfGrassNumber = number;
    }



 /*   public void mapDimensionsUpdate(Vector2d position){
        this.lowerLeft = position.lowerLeft(this.lowerLeft);
        this.upperRight = position.upperRight(this.upperRight);
    }*/

    private void liveMapDimensionsUpdate(){
        this.upperRight = v_0_0;
        this.lowerLeft = v_0_0;
        for(Animal animal: animals){
            this.lowerLeft = this.lowerLeft.lowerLeft(animal.getPosition());
            this.upperRight = this.upperRight.upperRight(animal.getPosition());
        }
        for(Grass stack: tufts){
            this.lowerLeft = this.lowerLeft.lowerLeft(stack.getPosition());
            this.upperRight = this.upperRight.upperRight(stack.getPosition());
        }
    }

    public void placeGrassTufts(){
        Random rand = new Random();
        int n = this.tuftOfGrassNumber;
        for(int i = 0; i < n; i++) {
            Grass tuft = new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(n * 10)), rand.nextInt((int) Math.sqrt(n * 10))));
            tufts.add(tuft);
            this.liveMapDimensionsUpdate();
        }
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            this.animals.get(i % this.animals.size()).move(directions[i]);
           /* this.liveMapDimensionsUpdate();
            System.out.println(this.toString());*/
        }
        liveMapDimensionsUpdate();
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : this.animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        for(Grass stack: this.tufts){
            if(position.equals(stack.getPosition())) return stack;
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return (!isOccupied(position));
    }


}

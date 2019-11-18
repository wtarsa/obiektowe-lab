package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.*;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    private int seed = 0;
    private int tuftOfGrassNumber = 0;
    public LinkedHashMap<Vector2d, Grass> tuftsMap = new LinkedHashMap<>();
    public GrassField(int number){
        this.tuftOfGrassNumber = number;
    }

    private void liveMapDimensionsUpdate(){
        Collection<Animal> animals = vector2dToAnimal.values();
        this.upperRight = animals.iterator().next().getPosition();
        this.lowerLeft = animals.iterator().next().getPosition();
        for(Animal animal: animals){
            this.lowerLeft = this.lowerLeft.lowerLeft(animal.getPosition());
            this.upperRight = this.upperRight.upperRight(animal.getPosition());
        }
        Collection<Grass> tufts = tuftsMap.values();
        for(Grass stack: tufts){
            this.lowerLeft = this.lowerLeft.lowerLeft(stack.getPosition());
            this.upperRight = this.upperRight.upperRight(stack.getPosition());
        }
    }

    public void placeGrassTufts(){
        Random rand = new Random();
        fillMapWithTufts(rand);
    }

    public void placeGrassTufts(int seed){
        this.seed = seed;
        Random rand = new Random(seed);
        fillMapWithTufts(rand);
    }

    private void fillMapWithTufts(Random rand){
        int n = this.tuftOfGrassNumber;
        for(int i = 0; i < n; i++) {
            placeOneTuft(rand);
        }
    }

    private void placeOneTuft(Random rand){
        int n = this.tuftOfGrassNumber;
        Grass tuft;
        do{
            tuft = new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(n * 10)), rand.nextInt((int) Math.sqrt(n * 10))));
        }
        while (tuftsMap.containsKey(tuft.getPosition()));
        this.tuftsMap.put(tuft.getPosition(), tuft);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(vector2dToAnimal.containsKey(position)) return vector2dToAnimal.get(position);
        if(tuftsMap.containsKey(position)) return tuftsMap.get(position);
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(isOccupied(position) && tuftsMap.containsKey(position)){
            Random rand = new Random(this.seed);
            placeOneTuft(rand);
            return true;
        }
        return (!isOccupied(position));

    }

    public String toString(){
        liveMapDimensionsUpdate();
        MapVisualizer mapInstance = new MapVisualizer(this);
        return mapInstance.draw(lowerLeft, this.upperRight);

    }

}

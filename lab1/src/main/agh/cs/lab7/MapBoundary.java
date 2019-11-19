package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class MapBoundary implements IPositionChangeObserver {

    private Vector2d lowerLeft;
    private Vector2d upperRight;
    private List<Vector2d> sortedX = new ArrayList<>();
    private List<Vector2d> sortedY = new ArrayList<>();

    public void add(Vector2d position){
        int index = 0;
        while(index < this.sortedX.size() && this.sortedX.get(index).x < position.x) index++;
        while(index < this.sortedX.size() && this.sortedX.get(index).x == position.x && this.sortedX.get(index).y < position.y) index++;
        this.sortedX.add(index, position);

        index = 0;
        while(index < this.sortedY.size() && this.sortedY.get(index).y < position.y) index++;
        while(index < this.sortedY.size() && this.sortedY.get(index).y == position.y && this.sortedY.get(index).x < position.x) index++;
        this.sortedY.add(index, position);
    }

    public void remove(Vector2d position){
        this.sortedX.remove(position);
        this.sortedY.remove(position);
    }


    private void updateCorners(){
        this.lowerLeft = new Vector2d(this.sortedX.get(0).x, this.sortedY.get(0).y);
        this.upperRight = new Vector2d(this.sortedX.get(this.sortedX.size()-1).x, this.sortedY.get(this.sortedY.size()-1).y);
    }

    public Vector2d getLowerLeftCorner(){
        updateCorners();
        return this.lowerLeft;
    }

    public Vector2d getUpperRightCorner(){
        updateCorners();
        return this.upperRight;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            remove(oldPosition);
            add(newPosition);
        }
    }
}

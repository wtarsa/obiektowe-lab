package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal{

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    private static final Vector2d v_0_0 = new Vector2d(0, 0);
    private static final Vector2d v_4_4 = new Vector2d(4, 4);

    /*private boolean canMove(MoveDirection dir) {
        Vector2d tmp = this.position;
        switch (dir) {
            case FORWARD:
                tmp = this.position.add(this.orientation.toUnitVector());
                break;
            case BACKWARD:
                tmp = this.position.add(this.orientation.toUnitVector().opposite());
                break;
        }
        return(tmp.precedes(v_4_4) && tmp.follows(v_0_0));
    }*/

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2 );
    }

    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        switch(this.orientation){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
            case WEST:
                return "W";
            default:
                return "";
        }
    }

    /*public void move(MoveDirection direction){
        if(direction == MoveDirection.LEFT){
            this.orientation = this.orientation.previous();
        }
        else if(direction == MoveDirection.RIGHT){
            this.orientation = this.orientation.next();
        }
        else if(direction == MoveDirection.FORWARD){
            if(canMove(direction)) this.position = this.position.add(this.orientation.toUnitVector());
        }
        else if(direction == MoveDirection.BACKWARD){
            if(canMove(direction)) this.position = this.position.add(this.orientation.toUnitVector().opposite());
        }
    }*/

    public void move(MoveDirection direction){
        if(direction == MoveDirection.LEFT){
            this.orientation = this.orientation.previous();
        }
        else if(direction == MoveDirection.RIGHT){
            this.orientation = this.orientation.next();
        }
        else if(direction == MoveDirection.FORWARD && this.map.canMoveTo(this.position.add(this.orientation.toUnitVector()))){
            this.position = this.position.add(this.orientation.toUnitVector());
        }
        else if(direction == MoveDirection.BACKWARD && this.map.canMoveTo(this.position.add(this.orientation.toUnitVector().opposite()))){
            this.position = this.position.add(this.orientation.toUnitVector().opposite());
        }
    }


}

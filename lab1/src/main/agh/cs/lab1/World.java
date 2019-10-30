package agh.cs.lab1;

import java.util.ArrayList;

public class World {
    public static void run(ArrayList<Direction> dir){
        System.out.println("Start");
        for(Direction argument : dir) {
            switch(argument){
                case FORWARD:
                    System.out.println("Do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Do tyłu");
                    break;
                case RIGHT:
                    System.out.println("W prawo");
                    break;
                case LEFT:
                    System.out.println("W lewo");
                    break;
                default:
                    break;
            }
        }
        System.out.println("Stop");
    }
    public static void main(String[] args) {
        ArrayList<Direction> dir = new ArrayList<Direction>();
        for(int i = 0; i < args.length; i++){
            switch (args[i]){
                case "f":
                    dir.add(Direction.FORWARD);
                    break;
                case "b":
                    dir.add(Direction.BACKWARD);
                    break;
                case "l":
                    dir.add(Direction.LEFT);
                    break;
                case "r":
                    dir.add(Direction.RIGHT);
                    break;
                default:
                    break;
            }
        }
        run(dir);

    }

}

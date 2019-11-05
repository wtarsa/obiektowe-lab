package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

public class OptionsParser {

    public MoveDirection[] parse(String[] s){
        MoveDirection[] directions = new MoveDirection[s.length];
        int correctStrings = s.length;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("f") || s[i].equals("forward"))
                directions[i] = MoveDirection.FORWARD;
            else if (s[i].equals("b") || s[i].equals("backward"))
                directions[i] = MoveDirection.BACKWARD;
            else if (s[i].equals("r") || s[i].equals("right"))
                directions[i] = MoveDirection.RIGHT;
            else if (s[i].equals("l") || s[i].equals("left"))
                directions[i] = MoveDirection.LEFT;
            else {
                correctStrings--;
                try {
                    throw new IllegalArgumentException(s[i] + " is not legal move specification");
                }
                catch (IllegalArgumentException a){
                    System.out.println("Exception thrown  :" + a);
                }
            }
        }

        MoveDirection[] result = new MoveDirection[correctStrings];
        int tmp = 0;
        for(int i = 0; i < s.length; i++){
            if(directions[i] != null){
                result[tmp] = directions[i];
                tmp++;
            }
        }
        return result;
    }


}

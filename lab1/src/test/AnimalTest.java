import agh.cs.lab2.MoveDirection;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void orientationTest(){
        Animal animal = new Animal();
        String[] args = {"makarena", "r", "l", "l", "l"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] directions = parser.parse(args);
        for(MoveDirection dir : directions){
            animal.move(dir);
        }
        Assert.assertEquals("S", animal.toString());
        Assert.assertNotEquals("N", animal.toString());
    }

    @Test
    public void parserTest(){
        String[] args = {"makarena", "r", "l", "d", "b", "f", "left", "right", "forward", "backward"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] directions = parser.parse(args);
        MoveDirection[] expectedDirections = {MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD,
                                              MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        Assert.assertEquals(expectedDirections, directions);
    }

}

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Test;
import org.junit.Assert;

public class RectangularMapTest {

    @Test
    public void allMethodsTest0(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        Assert.assertEquals(" y\\x  0 1 2 3 4 5 6 7 8 910\n" +
                "  6: -----------------------\n" +
                "  5: | | | |N| | | | | | | |\n" +
                "  4: | | | | | | | | | | | |\n" +
                "  3: | | | | | | | | | | | |\n" +
                "  2: | | | | | | | | | | | |\n" +
                "  1: | | | | | | | | | | | |\n" +
                "  0: | | |S| | | | | | | | |\n" +
                " -1: -----------------------\n", map.toString());
        Assert.assertNotEquals(" y\\x  0 1 2 3 4 5 6 7 8 910\n" +
                "  6: -----------------------\n" +
                "  5: | | | | | | | | | | | |\n" +
                "  4: | | | | | | | | | | | |\n" +
                "  3: | | | | | | | | | | | |\n" +
                "  2: | | | | | | | | | | | |\n" +
                "  1: | | | | | | | | | | | |\n" +
                "  0: | | |S|S| | | | | | | |\n" +
                " -1: -----------------------\n", map.toString());
    }

    @Test
    public void allMethodsTest1(){
        String[] args = {"f", "b", "f", "r", "r", "l", "b", "b", "b", "l", "l", "l", "f", "makarena", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(1,1)));
        map.place(new Animal(map, new Vector2d(3,3)));
        map.place(new Animal(map, new Vector2d(4,1)));
        map.run(directions);
        Assert.assertEquals(" y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | | | | |\n" +
                "  4: | | | | | | |\n" +
                "  3: |N| |N| | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | | | | | |S|\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------\n", map.toString());
        Assert.assertNotEquals(" y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | | | | |\n" +
                "  4: | | | | | |S|\n" +
                "  3: |S| |N| | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | | | | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------\n", map.toString());
    }

    @Test
    public void mapRangeTest(){
        String[] args = {"f", "f", "f", "f", "makarena", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(1,1)));
        map.run(directions);
        Assert.assertEquals(" y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | |N| | | | |\n" +
                "  4: | | | | | | |\n" +
                "  3: | | | | | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | | | | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------\n", map.toString());
        Assert.assertNotEquals(" y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | | | | |\n" +
                "  4: | |N| | | | |\n" +
                "  3: | | | | | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | | | | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------\n", map.toString());
    }

    @Test
    public void orientationTest(){
        String[] args = {"r", "r", "l", "l", "makarena", "l", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(1,1)));
        map.run(directions);
        Assert.assertEquals(" y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | | | | |\n" +
                "  4: | | | | | | |\n" +
                "  3: | | | | | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | |S| | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------\n", map.toString());
        Assert.assertNotEquals(" y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | | | | |\n" +
                "  4: | | | | | | |\n" +
                "  3: | | | | | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | |N| | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------\n", map.toString());
    }

    @Test
    public void objectAtTest(){
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(1,1)));
        Assert.assertNotEquals(map.objectAt(new Vector2d(1, 1)), null);
    }

    @Test
    public void isOccupiedTest(){
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(1,1)));
        Assert.assertTrue(map.isOccupied(new Vector2d(1, 1)));
        Assert.assertFalse(map.isOccupied(new Vector2d(1, 2)));
    }


}


import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.GrassField;
import org.junit.Assert;
import org.junit.Test;

public class GrassFieldTest {

    @Test
    public void animalEatGrassTest(){
        String[] args = {"b", "l", "f", "makarena"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField field = new GrassField(4);
        field.placeGrassTufts(50);
        field.place(new Animal(field));
        field.run(directions);
        Assert.assertEquals(" y\\x  0 1 2 3 4 5\n" +
                "  5: -------------\n" +
                "  4: |*| | | | |*|\n" +
                "  3: | | | | | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | |W| | | | |\n" +
                "  0: | |*| | |*| |\n" +
                " -1: -------------\n", field.toString());
        Assert.assertNotEquals(" y\\x  1 2 3 4 5\n" +
                "  5: -----------\n" +
                "  4: | | | | |*|\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: |*|W| | | |\n" +
                "  0: |*| | |*| |\n" +
                " -1: -----------\n", field.toString());
    }

    @Test
    public void allMethodsTest(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "makarena"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField field = new GrassField(10);
        field.placeGrassTufts(50);
        field.place(new Animal(field, new Vector2d(3, 4)));
        field.place(new Animal(field));
        field.run(directions);
        Assert.assertNotEquals(" y\\x  0 1 2 3 4 5 6 7 8\n" +
                "  9: -------------------\n" +
                "  8: | | | | | | |*|*| |\n" +
                "  7: | | |*| | | | | | |\n" +
                "  6: | | | | | | | | | |\n" +
                "  5: |*| |N| | | | | | |\n" +
                "  4: | | | | | | | | | |\n" +
                "  3: | | | | | |*| | | |\n" +
                "  2: |*| | |*| |*| | |*|\n" +
                "  1: | |*| | |S| | | | |\n" +
                "  0: -------------------\n", field.toString());
        Assert.assertEquals(" y\\x  0 1 2 3 4 5 6 7 8\n" +
                "  9: -------------------\n" +
                "  8: | | | | | | |*|*| |\n" +
                "  7: | | |*| | | | | | |\n" +
                "  6: | | | | | | | | | |\n" +
                "  5: |*|N| | | | | | | |\n" +
                "  4: | | |*| | | | | | |\n" +
                "  3: | | | | | |*| | | |\n" +
                "  2: |*| | |*| |*| | |*|\n" +
                "  1: | |*| | |S| | | | |\n" +
                "  0: -------------------\n", field.toString());

    }

    @Test
    public void orientationTest(){
        String[] args = {"r", "r", "l", "l", "makarena", "l", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField field = new GrassField(0);
        field.place(new Animal(field));
        field.run(directions);
        Assert.assertEquals(" y\\x  2\n" +
                "  3: ---\n" +
                "  2: |S|\n" +
                "  1: ---\n", field.toString());
    }

    @Test
    public void objectAtTest(){
        IWorldMap field = new GrassField( 5);
        field.place(new Animal(field, new Vector2d(1,1)));
        Assert.assertNotEquals(field.objectAt(new Vector2d(1, 1)), null);
    }

    @Test
    public void isOccupiedTest(){
        IWorldMap field = new GrassField( 5);
        field.place(new Animal(field, new Vector2d(1,1)));
        Assert.assertTrue(field.isOccupied(new Vector2d(1, 1)));
        Assert.assertFalse(field.isOccupied(new Vector2d(1, 2)));
    }

    @Test
    public void tuftNumberTest(){
        GrassField field = new GrassField(13);
        field.placeGrassTufts(50);
        Assert.assertEquals(13, field.tuftsMap.size());
        Assert.assertNotEquals(12, field.tuftsMap.size());
    }
}

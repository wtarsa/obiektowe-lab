import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab5.GrassField;
import org.junit.Test;
import org.junit.Assert;

public class UnboundedMapTest {

   /* @Test
    public void allMethodsTest(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        UnboundedMap map = new UnboundedMap(4);
        map.placeHayStack(new Vector2d(-4, -4));
        map.placeHayStack(new Vector2d(7, 7));
        map.placeHayStack(new Vector2d(3, 6));
        map.placeHayStack(new Vector2d(2, 0));
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        Assert.assertEquals(" y\\x -4-3-2-1 0 1 2 3 4 5 6 7\n" +
                "  8: -------------------------\n" +
                "  7: | | | | | | | | | | | |s|\n" +
                "  6: | | | | | | | |s| | | | |\n" +
                "  5: | | | | | | | |N| | | | |\n" +
                "  4: | | | | | | | | | | | | |\n" +
                "  3: | | | | | | | | | | | | |\n" +
                "  2: | | | | | | | | | | | | |\n" +
                "  1: | | | | | | |S| | | | | |\n" +
                "  0: | | | | | | |s| | | | | |\n" +
                " -1: | | | | | | | | | | | | |\n" +
                " -2: | | | | | | | | | | | | |\n" +
                " -3: | | | | | | | | | | | | |\n" +
                " -4: |s| | | | | | | | | | | |\n" +
                " -5: -------------------------\n", map.toString());
        Assert.assertNotEquals(" y\\x -4-3-2-1 0 1 2 3 4 5 6 7\n" +
                "  8: -------------------------\n" +
                "  7: | | | | | | | |N| | | |s|\n" +
                "  6: | | | | | | | |s| | | | |\n" +
                "  5: | | | | | | | | | | | | |\n" +
                "  4: | | | | | | | | | | | | |\n" +
                "  3: | | | | | | | | | | | | |\n" +
                "  2: | | | | | | | | | | | | |\n" +
                "  1: | | | | | | | | | | | | |\n" +
                "  0: | | | | | | |s| | | | | |\n" +
                " -1: | | | | | | |S| | | | | |\n" +
                " -2: | | | | | | | | | | | | |\n" +
                " -3: | | | | | | | | | | | | |\n" +
                " -4: |s| | | | | | | | | | | |\n" +
                " -5: -------------------------\n", map.toString());

    }
*/
}

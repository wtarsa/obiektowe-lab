import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab5.GrassField;
import org.junit.Assert;
import org.junit.Test;
import agh.cs.lab7.MapBoundary;

public class MapBoundaryTest {

    private static final Vector2d v_0_0 = new Vector2d(0,0);
    private static final Vector2d v_1_2 = new Vector2d(1,2);
    private static final Vector2d v_2_4 = new Vector2d(2,4);
    private static final Vector2d v_3_4 = new Vector2d(3,4);
    private static final Vector2d v_4_5 = new Vector2d(4,5);

    @Test
    public void integrationTest0(){ // add() & corners
        MapBoundary border = new MapBoundary();
        border.add(v_1_2);
        border.add(v_3_4);
        border.add(v_2_4);
        Vector2d lowerLeft = border.getLowerLeftCorner();
        Assert.assertEquals(v_1_2, lowerLeft);
        border.add(v_0_0);
        border.add(v_4_5);
        Vector2d upperRight = border.getUpperRightCorner();
        Assert.assertEquals(v_4_5, upperRight);
    }

    @Test
    public void integrationTest1(){ // add(), remove(), corners & positionChanged()
        MapBoundary border = new MapBoundary();
        border.add(v_0_0);
        border.add(v_2_4);
        border.add(v_1_2);
        Vector2d upperRight = border.getUpperRightCorner();
        Assert.assertEquals(v_2_4, upperRight);
        border.positionChanged(v_2_4, v_3_4);
        upperRight = border.getUpperRightCorner();
        Assert.assertEquals(upperRight, v_3_4);
    }

    @Test
    public void integrationTest2(){
        String[] args = {"f", "f", "f", "f", "f", "f", "f", "f", "makarena"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField field = new GrassField(4);
        field.placeGrassTufts(50);
        field.place(new Animal(field));
        field.run(directions);
        Assert.assertEquals(" y\\x  1 2 3 4 5\n" +
                " 11: -----------\n" +
                " 10: | |N| | | |\n" +
                "  9: | | | | | |\n" +
                "  8: | | | | | |\n" +
                "  7: | | | | | |\n" +
                "  6: | | | | | |\n" +
                "  5: | | | | | |\n" +
                "  4: | | | | |*|\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: |*| | | | |\n" +
                "  0: |*| | |*| |\n" +
                " -1: -----------\n", field.toString());
    }

}

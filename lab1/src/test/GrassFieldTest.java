
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.GrassField;
import org.junit.Assert;
import org.junit.Test;

public class GrassFieldTest {


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
}

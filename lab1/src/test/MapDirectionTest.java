import org.junit.Test;

import agh.cs.lab2.MapDirection;

import static junit.framework.TestCase.assertEquals;

public class MapDirectionTest {

    @Test
    public void nextTest(){
        MapDirection tmp = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, tmp.next());
        tmp = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, tmp.next());
        tmp = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, tmp.next());
        tmp = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, tmp.next());
    }

    @Test
    public void previousTest(){
        MapDirection tmp = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, tmp.previous());
        tmp = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, tmp.previous());
        tmp = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, tmp.previous());
        tmp = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, tmp.previous());
    }
}

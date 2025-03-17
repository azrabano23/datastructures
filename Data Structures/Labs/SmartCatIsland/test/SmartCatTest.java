package test;

import static org.junit.Assert.*;
import org.junit.*;

import island.*;
import island.constants.Color;

/**
 * This is a JUnit test class, used to test code
 * 
 * You should test the SmartCat class by designing Island test cases
 * and filling in the JUnit tests according to the assignment
 * description.
 * 
 * @author Colin Sullivan
 */
public class SmartCatTest {

    public static Island pathIsland = new Island(new String[][] {
        {"L", "L", "L", "L", "L", "L", "L"},
        {"W", "W", "W", "W", "W", "W", "L"},
        {"L", "L", "L", "L", "L", "W", "L"},
        {"W", "W", "W", "W", "L", "W", "L"},
        {"L", "L", "L", "W", "L", "W", "L"},
        {"W", "W", "L", "W", "L", "W", "L"},
        {"L", "L", "L", "L", "L", "L", "L"}    
    });

        public static Island yarnIsland = new Island (new String[][] {
            {"Y", "L", "L", "W", "W", "L", "Y", "L", "Y"},
            {"L", "W", "L", "L", "W", "L", "L", "W", "L"},
            {"L", "L", "W", "Y", "L", "L", "W", "L", "L"},
            {"W", "L", "L", "L", "W", "L", "L", "L", "W"},
            {"L", "L", "W", "Y", "L", "Y", "W", "L", "L"},
            {"L", "W", "L", "L", "L", "L", "L", "W", "L"},
            {"L", "L", "L", "W", "L", "W", "L", "L", "L"},
            {"W", "L", "L", "L", "Y", "L", "L", "W", "L"},
            {"Y", "L", "W", "L", "L", "L", "W", "L", "Y"}   
        });

            public static Island mazeIsland = new Island(new String[][] {
                {"L", "L", "W", "W", "W", "W", "W", "W", "W", "L"},
                {"W", "L", "L", "L", "W", "L", "L", "L", "L", "L"},
                {"W", "W", "W", "L", "W", "L", "W", "W", "W", "L"},
                {"W", "L", "L", "L", "W", "L", "L", "L", "W", "L"},
                {"W", "L", "W", "W", "W", "W", "W", "L", "W", "L"},
                {"W", "L", "L", "L", "L", "L", "L", "L", "W", "L"},
                {"W", "W", "W", "W", "W", "W", "W", "L", "W", "L"},
                {"L", "L", "L", "L", "L", "L", "W", "L", "W", "L"},
                {"W", "W", "W", "W", "W", "L", "W", "L", "W", "L"},
                {"L", "L", "L", "L", "L", "L", "W", "L", "L", "L"}
            });

    @Test
    public void testWalkPath() {
        // WRITE YOUR CODE HERE
        SmartCat smartCat = new SmartCat("bob", pathIsland, 0, 0, Color.GREY);
        Tile[][] island = pathIsland.getTiles();
        smartCat.walkPath();

        // Assert the cat ended at the rightmost column in the top row
        assertEquals(island[0].length-1,smartCat.getCol());
        assertEquals(0,smartCat.getRow());
    }

    @Test
    public void testCollectAllYarn() {
        // WRITE YOUR CODE HERE
        SmartCat smartCat = new SmartCat("bobbie", yarnIsland, 0, 0, Color.BLACK);
        Tile[][] island=yarnIsland.getTiles();
        testCollectAllYarn();
        for (int row = 0; row<island.length;row++) {
            for (int col = 0; col<island[0].length; col++) {
                assertTrue(island[row][col].hasYarn=false);

            }
        }}

    @Test
    public void testSolveMaze() {
        // WRITE YOUR CODE HERE
        SmartCat smartCat = new SmartCat("bobi", mazeIsland, 0, 0, Color.WHITE);
        Tile[][]island = mazeIsland.getTiles();
        smartCat.solveMaze();

        assertTrue(smartCat.getRow()==0);
        assertTrue(smartCat.getCol()==island[0].length-1);
        assertTrue(smartCat.numStepsTaken()>=30);
        
    }

}

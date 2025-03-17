package island;

import island.constants.*;

/**
 * Welcome to Cat Island! A mini-world made using OOP!
 * Run the driver to see the islands, then solve each one in its
 * corresponding method below.
 * 
 * You should use the cat.moveRight(), cat.moveLeft(), cat.moveUp(),
 * and cat.moveDown() methods to traverse the islands and complete
 * their unique objectives
 */
public class CatIsland {

    /**
     * To complete this island, your cat should collect all the yarn and return
     * to the starting position (1,1)
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void solveIsland1(Cat cat) throws CatInWaterException {
        // WRITE YOUR CODE HERE
        cat.moveRight(); 
        cat.moveDown(); 
        cat.moveLeft(); 
        cat.moveUp(); 
        System.out.println(cat.numYarnCollected());
    }

    /**
     * To complete this island, your cat visit every single grass square
     * on this island. It does not have to return to its starting position
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void solveIsland2(Cat cat) throws CatInWaterException {
        // WRITE YOUR CODE HERE
        Tile[][] tiles = cat.getIsland().getTiles();
        for (int row = 0; row < tiles.length; row++) {
            if (row % 2 == 0) { 
                for (int col = 0; col < tiles[row].length - 1; col++) {
                    cat.moveRight();
                }
            } else { 
                for (int col = tiles[row].length - 1; col > 0; col--) {
                    cat.moveLeft();
                }
            }
            if (row < tiles.length - 1) {
                cat.moveDown(); // move next row
            }
        }
    }

    /**
     * To complete this island, your cat should collect every yarn ball on the
     * island.
     * It does not have to return to its starting position
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void solveIsland3(Cat cat) throws CatInWaterException {
        // WRITE YOUR CODE HERE
        cat.moveRight();
        cat.moveRight();
        cat.moveUp();
        cat.moveDown();
        cat.moveDown();
        cat.moveLeft();
        cat.moveUp();
        cat.moveLeft();
        cat.moveLeft();
        cat.moveUp();
        cat.moveDown();
        cat.moveDown();
        cat.moveLeft();
    }

    /**
     * To complete this island, you will need to modify the island
     * instead of moving a cat object.
     * 
     * You can get the 2D array of tiles from the island with .getTiles().
     * 
     * You should bridge the gap between the islands, by setting
     * the type attribute of the tiles at (1,2), (2,2), and (3,2)
     * equal to Tile.LAND.
     * 
     * You should also yarn to (1,2) and (3,2), by setting the "hasYarn"
     * attribute of those tiles to true.
     * 
     * @param cat
     * @throws CatInWaterException
     */
    public static void solveIsland4(Island islandFour) throws CatInWaterException {
        // WRITE YOUR CODE HERE
        Tile[][] tiles = islandFour.getTiles();

        // Modify tiles to bridge the gap
        tiles[1][2].type = Tile.LAND;
        tiles[2][2].type = Tile.LAND;
        tiles[3][2].type = Tile.LAND;

        // Place yarn
        tiles[1][2].hasYarn = true;
        tiles[3][2].hasYarn = true;
        tiles[2][2].cat = new Cat("", islandFour, 2, 2, Color.GREY);
    }

    /**
     * To complete this island, you will need to write a simple path following
     * algorithm, which will walk the cat along the single wide path.
     * 
     * This method is the caller method, which will call your recursive solution.
     * Do not modify this method
     * 
     * @param cat The path walker cat
     * @throws CatInWaterException
     */
    public static void solveIsland5(Cat cat, Island islandFive) throws CatInWaterException {
        // DO NOT EDIT
        CatIsland.solveIsland5Recursive(cat, islandFive.getTiles(), islandFive.getTiles()[cat.getRow()][cat.getCol()]);
    }

    /**
     * This recursive method walks a cat on a single wide path from beginning to end
     * 
     * You should check all four directions from the cats current position:
     * 1) if it is in bounds (>= 0 and <= num rows or num cols)
     * 2) if the type of the tile in that direction is land
     * 3) if the tile in that direction != the prev tile
     * If all 3, then move the cat in that direction, recursively call this method
     * with the same cat, same tiles array, and the tile you just moved from.
     * 
     * @param c
     * @param tiles
     * @param prev
     * @throws CatInWaterException
     */
    public static void solveIsland5Recursive(Cat cat, Tile[][] tiles, Tile prev) throws CatInWaterException {
        // WRITE YOUR CODE HERE
        int row = cat.getRow();
        int col = cat.getCol();
    
        // Up
        if (row > 0 && tiles[row - 1][col].type.equals(Tile.LAND) && tiles[row - 1][col] != prev) {
            cat.moveUp();
            solveIsland5Recursive(cat, tiles, tiles[row][col]);
            return;
        }
        //  Down 
        if (row < tiles.length - 1 && tiles[row + 1][col].type.equals(Tile.LAND) && tiles[row + 1][col] != prev) {
            cat.moveDown();
            solveIsland5Recursive(cat, tiles, tiles[row][col]);
            return;
        }
        // Left 
        if (col > 0 && tiles[row][col - 1].type.equals(Tile.LAND) && tiles[row][col - 1] != prev) {
            cat.moveLeft();
            solveIsland5Recursive(cat, tiles, tiles[row][col]);
            return;
        }
        // Right
        if (col < tiles[0].length - 1 && tiles[row][col + 1].type.equals(Tile.LAND) && tiles[row][col + 1] != prev) {
            cat.moveRight();
            solveIsland5Recursive(cat, tiles, tiles[row][col]);
        }    
    }

}

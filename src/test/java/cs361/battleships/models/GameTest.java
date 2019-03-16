package cs361.battleships.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class gameTest {

    private Game game;

    @Before
    public void setUp(){ game = new Game(); }

    //TESTING PLACE SHIP

    @Test
    public void testBadShipPlacementXVerticalMineSweeper() {
        Ship minesweeper = new Minesweeper();

        assertFalse(game.placeShip(minesweeper, 15, 'A', true));
    }

    @Test
    public void testBadShipPlacementXHorizontalMineSweeper() {
        Ship minesweeper = new Minesweeper();

        assertFalse(game.placeShip(minesweeper, 15, 'A', false));
    }



    @Test
    public void testBadShipPlacementYHorizontalMineSweeper() {
        Ship minesweeper = new Minesweeper();

        assertFalse(game.placeShip(minesweeper, 5, 'X', false));
    }

    @Test
    public void testBadShipPlacementYVerticalMineSweeper() {
        Ship minesweeper = new Minesweeper();

        assertFalse(game.placeShip(minesweeper, 5, 'X', true));
    }

    @Test
    public void testGoodShipPlacementVerticalMineSweeper(){
        Ship minesweeper = new Minesweeper();

        assertTrue(game.placeShip(minesweeper, 5, 'D', true));

    }

    @Test
    public void testGoodShipPlacementHorizontalMineSweeper(){
        Ship minesweeper = new Minesweeper();

        assertTrue(game.placeShip(minesweeper, 5, 'D', false));

    }

    @Test
    public void testBadShipPlacementXVerticalDESTROYER() {
        Ship ship = new Destroyer();

        assertFalse(game.placeShip(ship, 15, 'A', true));
    }

    @Test
    public void testBadShipPlacementXHorizontalDESTROYER() {
        Ship ship = new Destroyer();

        assertFalse(game.placeShip(ship, 15, 'A', false));
    }

    @Test
    public void testBadShipPlacementYHorizontalDESTROYER() {
        Ship ship = new Destroyer();

        assertFalse(game.placeShip(ship, 5, 'X', false));
    }

    @Test
    public void testBadShipPlacementYVerticalDESTROYER() {
        Ship ship = new Destroyer();

        assertFalse(game.placeShip(ship, 5, 'X', true));
    }

    @Test
    public void testGoodShipPlacementVerticalDESTROYER(){
        Ship ship = new Destroyer();

        assertTrue(game.placeShip(ship, 5, 'D', true));

    }

    @Test
    public void testGoodShipPlacementHorizontalDESTROYER(){
        Ship ship = new Destroyer();

        assertTrue(game.placeShip(ship, 5, 'D', false));

    }

    @Test
    public void testBadShipPlacementXVerticalBATTLESHIP() {
        Ship ship = new Battleship();

        assertFalse(game.placeShip(ship, 15, 'A', true));
    }

    @Test
    public void testBadShipPlacementXHorizontalBATTLESHIP() {
        Ship ship = new Battleship();

        assertFalse(game.placeShip(ship, 15, 'A', false));
    }

    @Test
    public void testBadShipPlacementYHorizontalBATTLESHIP() {
        Ship ship = new Battleship();

        assertFalse(game.placeShip(ship, 5, 'X', false));
    }

    @Test
    public void testBadShipPlacementYVerticalBATTLESHIP() {
        Ship ship = new Battleship();

        assertFalse(game.placeShip(ship, 5, 'X', true));
    }

    @Test
    public void testGoodShipPlacementVerticalBATTLESHIP(){
        Ship ship = new Battleship();

        assertTrue(game.placeShip(ship, 5, 'D', true));

    }

    @Test
    public void testGoodShipPlacementHorizontalBATTLESHIP(){
        Ship ship = new Battleship();

        assertTrue(game.placeShip(ship, 5, 'D', false));

    }



    //Attack tests

    @Test
    public void testGoodAttackPlacement(){

        assertTrue(game.attack(5, 'B'));
    }

    @Test
    public void testBadSecondAttack(){
        //bad attacks happen on already attacked squares
        game.attack(5, 'B');
        assertFalse(game.attack(5, 'B'));

    }

    @Test
    public void testGoodSecondAttack(){
        game.attack(7,'C');
        assertTrue(game.attack(7, 'A'));

    }

    //SONAR PULSE TESTS - more rigorous tests happen in Board

    @Test
    public void testSonarPulse(){

        assertTrue(game.sonarPulse(4, 'E'));
    }

    //Random Vertical, Row and Col testing

    @Test
    public void testRandRow(){
        int row = game.getRandRow();

        assertTrue(row >= 1 && row <= 10);
    }

    @Test
    public void testRandCol(){
        char col = game.getRandCol();

        assertTrue(col >= 'A' && col <= 'J');

    }

    @Test
    public void testRandVertical(){
        boolean ver = game.getRandVert();

        assertTrue(ver || !ver );

    }
}

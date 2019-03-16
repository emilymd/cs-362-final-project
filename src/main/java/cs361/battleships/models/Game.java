package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static cs361.battleships.models.AtackStatus.*;

public class Game {

    @JsonProperty
    private Board playersBoard = new Board();
    @JsonProperty
    private Board opponentsBoard = new Board();

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
        boolean successful;
        System.out.print("into game\n");

        if (ship.getKind() == "SUBMARINE") {
            System.out.print("into game\n");
            successful = playersBoard.placeSubmarine(ship, x, y, isVertical);
        } else {
            successful = playersBoard.placeShip(ship, x, y, isVertical);
        }
        System.out.print(successful);
        if (!successful)
            return false;

        boolean opponentPlacedSuccessfully;
        do {
            // AI places random ships, so it might try and place overlapping ships
            // let it try until it gets it right
            if (ship.getKind() == "SUBMARINE") {
                opponentPlacedSuccessfully = opponentsBoard.placeSubmarine(ship, x, y, isVertical);
            } else {
                opponentPlacedSuccessfully = opponentsBoard.placeShip(ship, randRow(), randCol(), randVertical());
            }
        } while (!opponentPlacedSuccessfully);

        return true;
    }

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean attack(int x, char y) {
        Result playerAttack = opponentsBoard.attack(x, y);
        if (playerAttack.getResult() == INVALID) {
            return false;
        }

        Result opponentAttackResult;
        do {
            // AI does random attacks, so it might attack the same spot twice
            // let it try until it gets it right
            opponentAttackResult = playersBoard.attack(randRow(), randCol());
        } while (opponentAttackResult.getResult() == INVALID);

        return true;
    }

    public boolean laserAttack(int x, char y) {
        Result playerAttack = opponentsBoard.laserAttack(x, y);
        if (playerAttack.getResult() == INVALID) {
            return false;
        }
        Result opponentAttackResult;
        do {
            // AI does random attacks, so it might attack the same spot twice
            // let it try until it gets it right
            opponentAttackResult = playersBoard.laserAttack(randRow(), randCol());
        } while (opponentAttackResult.getResult() == INVALID);
        return true;
    }

    public boolean sonarPulse(int x, char y) {
        return opponentsBoard.sonarPulse(x, y);
    }

    private char randCol() {
        int random = new Random().nextInt(10);
        return (char) ('A' + random);
    }

    private int randRow() {
        return new Random().nextInt(10) + 1;
    }

    private boolean randVertical() {
        return new Random().nextBoolean();
    }

    @JsonIgnore
    public char getRandCol() {
        return randCol();
    }

    @JsonIgnore
    public int getRandRow() {
        return randRow();
    }

    @JsonIgnore
    public boolean getRandVert() {
        return randVertical();
    }
}
package code;

public class Square {

    Ship ship;
    boolean wasAlreadyHit;

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean hasShip() {
        if (ship != null) {
            return true;
        }
        return false;
    }

    public boolean wasAlreadyHit() {
        return wasAlreadyHit;
    }

    public void markHit() {
        wasAlreadyHit = true;
        this.ship.hit();
    }

    public void markMiss() {
        wasAlreadyHit = true;
    }

    public Square() {
        this.ship = null;
        this.wasAlreadyHit = false;
    }

    public Square(Ship ship) {
        this.ship = ship;
        this.wasAlreadyHit = false;
    }

    public Ship removeShip() {
        Ship ship = this.ship;
        this.ship = null;
        return ship;
    }

}

package code;

public class Square {

    Ship ship;
    boolean isHit;

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

    public boolean isHit() {
        return isHit;
    }

    public void markHit() {
        isHit = true;
    }

    public Square() {
        this.ship = null;
        this.isHit = false;
    }

    public Square(Ship ship) {
        this.ship = ship;
        this.isHit = false;
    }

}

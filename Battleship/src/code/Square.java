package code;

public class Square {

    private Ship ship;

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

}

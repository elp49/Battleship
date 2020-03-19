package code;

public class Ship {

    private String name;
    private int size;
    private int hpRemaining;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHpRemaining() {
        return hpRemaining;
    }

    public void setHpRemaining(int hpRemaining) {
        this.hpRemaining = hpRemaining;
    }

    public boolean isSunk() {
        if (hpRemaining == 0) {
            return true;
        }
        return false;
    }

    public Ship() {
    }

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.hpRemaining = size;
    }

    public void hit() {
        // Check ship is not already sunk.
        assert hpRemaining > 0;
        hpRemaining -= 1;
    }

}

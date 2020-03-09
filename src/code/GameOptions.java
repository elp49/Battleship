package code;

import java.io.*;

public class GameOptions implements Serializable {

    String filename = "GameOptions.ser";

    int moveTime;
    int setupTime;
    static final int MAX_MOVE_TIME = 99;
    static final int MIN_MOVE_TIME = 1;
    static final int MAX_SETUP_TIME = 99;
    static final int MIN_SETUP_TIME = 1;

    public int getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(int moveTime) {
        if (moveTime >= MIN_MOVE_TIME && moveTime <= MAX_MOVE_TIME && moveTime != this.moveTime) {
            this.moveTime = moveTime;
            // Update application's move time.
            updateApplicationsMoveTime();
        }
    }

    public int getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(int setupTime) {
        this.setupTime = setupTime;
        if (setupTime >= MIN_SETUP_TIME && setupTime <= MAX_SETUP_TIME && setupTime != this.setupTime) {
            this.setupTime = setupTime;
            // Update application's setup time.
            updateApplicationsSetupTime();
        }
    }

    public GameOptions() {
        this.moveTime = 5;
        this.setupTime = 10;
    }

    public void incrementMoveTime() {
        if (this.moveTime < MAX_MOVE_TIME) {
            this.moveTime += 1;
            // Update application's move time.
            updateApplicationsMoveTime();
        }
    }

    public void decrementMoveTime() {
        if (this.moveTime > MIN_MOVE_TIME) {
            this.moveTime -= 1;
            // Update application's move time.
            updateApplicationsMoveTime();
        }
    }

    public void incrementSetupTime() {
        if (this.setupTime < MAX_SETUP_TIME) {
            this.setupTime += 1;
            // Update application's setup time.
            updateApplicationsSetupTime();
        }
    }

    public void decrementSetupTime() {
        if (this.setupTime > MIN_SETUP_TIME) {
            this.setupTime -= 1;
            // Update application's setup time.
            updateApplicationsSetupTime();
        }
    }

    public void updateApplicationsMoveTime() {
        // this.moveTime
        // ...
    }

    public void updateApplicationsSetupTime() {
        // this.setupTime
        // ...
    }

    public void updateAllGameOptions() {
        // ...
        updateApplicationsMoveTime();
        updateApplicationsSetupTime();
        // ...
    }

    public static GameOptions loadGameOptions() {
        GameOptions gameOptions = null;
        try {
            gameOptions = gameOptions.deserialize();
        } catch (IOException | ClassNotFoundException e) {
            // If deserialization failed, then load default game options.
            e.printStackTrace();
            gameOptions = new GameOptions();
            // Serialize default game options for future use.
            gameOptions.serialize();
        }
        // Update the game options.
        gameOptions.updateAllGameOptions();
        // Return game options.
        return gameOptions;
    }

    public void saveGameOptions() {
        // Update the game options.
        this.updateAllGameOptions();
        // Serialize game options.
        this.serialize();
    }

    public void serialize() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // Serialize GameOptions object to a stream of bytes.
            fos = new FileOutputStream(this.filename);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close stream pointers.
            try {
                if (fos != null)
                    fos.close();
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public GameOptions deserialize() throws IOException, ClassNotFoundException {
        // Check if game options file exists.
        File file = new File(this.filename);
        if (!file.exists() || !file.isFile())
            throw new FileNotFoundException(this.filename);
        GameOptions gameOptions = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            // Deserialize GameOptions object from a stream of bytes.
            fis = new FileInputStream(this.filename);
            ois = new ObjectInputStream(fis);
            gameOptions = (GameOptions) ois.readObject();
        } finally {
            // Close stream pointers.
            try {
                if (ois != null)
                    ois.close();
                if (fis != null)
                    fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Return deserialized GameOptions object.
        return gameOptions;
    }

}

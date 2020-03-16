package code;

import java.io.*;
import java.util.ArrayList;

public class Settings implements Serializable {

    static String filename = "settings.ser";

    public enum Language {ENGLISH}

    Language currentLanguage;
    boolean soundEffectsOn;
    ArrayList<String> soundEffectEventIDs;
    boolean musicOn;
    String musicFilePath;
    int volumeLevel;
    static final int MAX_VOLUME_LEVEL = 100;
    static final int MIN_VOLUME_LEVEL = 0;
    String colorTheme;
    ArrayList<String> colorGraphicIDs;

    public Language getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(Language currentLanguage) {
        this.currentLanguage = currentLanguage;
        // Update system language.
        // ...
    }

    public boolean isSoundEffectsOn() {
        return soundEffectsOn;
    }

    public void turnSoundEffectsOn() {
        if (this.soundEffectsOn != true) {
            this.soundEffectsOn = true;
            // Update all system sound effects.
            this.soundEffectEventIDs.forEach((id) -> updateSystemSoundEffect(id));
        }
    }

    public void turnSoundEffectsOff() {
        if (this.soundEffectsOn != false) {
            this.soundEffectsOn = true;
            // Update all system sound effects.
            this.soundEffectEventIDs.forEach((id) -> updateSystemSoundEffect(id));
        }
    }

    public ArrayList<String> getSoundEffectEventIDs() {
        return soundEffectEventIDs;
    }

    public void setSoundEffectEventIDs(ArrayList<String> soundEffectEventIDs) {
        if (!this.soundEffectEventIDs.equals(soundEffectEventIDs)) {
            this.soundEffectEventIDs = soundEffectEventIDs;
            // Update all system sound effects.
            this.soundEffectEventIDs.forEach((id) -> updateSystemSoundEffect(id));
        }
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public void turnMusicOn() {
        if (this.musicOn != true) {
            this.musicOn = true;
            // Update system music.
            // ...
        }
    }

    public void turnMusicOff() {
        if (this.musicOn != false) {
            this.musicOn = false;
            // Update system music.
            // ...
        }
    }

    public String getMusicFilePath() {
        return musicFilePath;
    }

    public void setMusicFilePath(String musicFilePath) {
        if (!this.musicFilePath.equals(musicFilePath)) {
            this.musicFilePath = musicFilePath;
            // Update system music file.
            // ...
        }
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(int volumeLevel) {
        if (volumeLevel >= MIN_VOLUME_LEVEL && volumeLevel <= MAX_VOLUME_LEVEL && volumeLevel != this.volumeLevel) {
            this.volumeLevel = volumeLevel;
            // Update system volume level.
            updateSystemVolumeLevel();
        }
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        if (!this.colorTheme.equals(colorTheme)) {
            this.colorTheme = colorTheme;
            // Update all system color graphics.
            this.colorGraphicIDs.forEach((id) -> updateSystemColorGraphic(id));
        }
    }

    public ArrayList<String> getColorGraphicIDs() {
        return colorGraphicIDs;
    }

    public void setColorGraphicIDs(ArrayList<String> colorGraphicIDs) {
        if (!this.colorGraphicIDs.equals(colorGraphicIDs)) {
            this.colorGraphicIDs = colorGraphicIDs;
            // Update all system color graphics.
            this.colorGraphicIDs.forEach((id) -> updateSystemColorGraphic(id));
        }
    }

    public Settings() {
        this.currentLanguage = Language.valueOf("ENGLISH");
        this.soundEffectsOn = true;
        this.soundEffectEventIDs = new ArrayList<>();
        this.musicOn = true;
        this.musicFilePath = "";
        this.volumeLevel = 50;
        this.colorTheme = "blue";
        this.colorGraphicIDs = new ArrayList<>();
    }

    public void updateSystemLanguage() {
        // this.currentLanguage
        // ...
    }

    public void addSoundEffectID(String id) {
        if (!this.soundEffectEventIDs.contains(id)) {
            this.soundEffectEventIDs.add(id);
            // Update this sound effect.
            updateSystemSoundEffect(id);
        }
    }

    public void updateSystemSoundEffect(String id) {
        // this.soundEffectsOn
        // ...
    }

    public void updateSystemMusic() {
        // this.musicOn
        // ...
    }

    public void updateSystemMusicFile() {
        // this.musicFilePath
        // ...
    }

    public void incrementVolumeLevel() {
        if (this.volumeLevel < MAX_VOLUME_LEVEL) {
            this.volumeLevel += 1;
            // Update system volume level.
            updateSystemVolumeLevel();
        }
    }

    public void decrementVolumeLevel() {
        if (this.volumeLevel > MIN_VOLUME_LEVEL) {
            this.volumeLevel -= 1;
            // Update system volume level.
            updateSystemVolumeLevel();
        }
    }

    public void updateSystemVolumeLevel() {
        // this.volumeLevel
        // ...
    }

    public void addColorGraphicID(String id) {
        if (!this.colorGraphicIDs.contains(id)) {
            this.colorGraphicIDs.add(id);
            // Update this color graphic.
            updateSystemColorGraphic(id);
        }
    }

    public void updateSystemColorGraphic(String id) {
        // this.colorTheme
        // ...
    }

    public void updateAllSystemSettings() {
        updateSystemLanguage();
        this.soundEffectEventIDs.forEach((id) -> updateSystemSoundEffect(id));
        updateSystemMusic();
        updateSystemMusicFile();
        updateSystemVolumeLevel();
        this.colorGraphicIDs.forEach((id) -> updateSystemColorGraphic(id));
    }

    public static Settings loadSettings() {
        Settings settings;

        try {
            settings = Settings.deserialize();
        } catch (IOException | ClassNotFoundException e) {
            // If deserialization failed, then load default settings.
            e.printStackTrace();
            settings = new Settings();
            // Serialize default settings for future use.
            settings.serialize();
        }

        // Update the application's settings.
        settings.updateAllSystemSettings();
        // Return settings.
        return settings;
    }

    public void saveSettings() {
        // Update the application's settings.
        this.updateAllSystemSettings();
        // Serialize settings.
        this.serialize();
    }

    public void serialize() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            // Serialize Settings object to a stream of bytes.
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

    public static Settings deserialize() throws IOException, ClassNotFoundException {
        // Check if settings file exists.
        File file = new File(Settings.filename);
        if (!file.exists() || !file.isFile())
            throw new FileNotFoundException(Settings.filename);
        Settings settings = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            // Deserialize Settings object from a stream of bytes.
            fis = new FileInputStream(Settings.filename);
            ois = new ObjectInputStream(fis);
            settings = (Settings) ois.readObject();
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
        // Return deserialized Settings object.
        return settings;
    }

}

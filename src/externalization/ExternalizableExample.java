package externalization;

import java.io.*;

public class ExternalizableExample {
    public static void main(String[] args) {

        UserSettings settings = new UserSettings();
        settings.setDoNotStoreMe("Sensitive info");
        settings.setFieldOne(10000);
        settings.setFieldTwo("HowToDoInJava.com");
        settings.setFieldThree(false);

        //Before
        System.out.println(settings);
        storeUserSettings(settings);
        //After
        UserSettings loadedSettings = loadSettings();
        System.out.println(loadedSettings);
    }

    private static UserSettings loadSettings() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.ser"));
            UserSettings settings = (UserSettings) ois.readObject();
            ois.close();
            return settings;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void storeUserSettings(UserSettings settings) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.ser"));
            oos.writeObject(settings);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

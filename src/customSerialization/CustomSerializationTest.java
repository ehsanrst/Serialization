package customSerialization;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class CustomSerializationTest {

    public static void main(String[] args) {
        // Create new User object
        User myDetails = new User("Lokesh", "Gupta",
                102825, new Date(Calendar.getInstance().getTimeInMillis()));

        // Serialization code
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("User.ser"));
            out.writeObject(myDetails);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

        // De-serialization code
        User deSerializedUser = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("User.ser"));
            deSerializedUser = (User) in.readObject();
            in.close();

            // verify the object state
            System.out.println(deSerializedUser.getFirstName());
            System.out.println(deSerializedUser.getLastName());
            System.out.println(deSerializedUser.getAccountNumber());
            System.out.println(deSerializedUser.getDateOpened());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
}

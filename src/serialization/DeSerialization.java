package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialization {
    private static final String fileName = "DemoClassBytes.ser";

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        //De-serialization
        System.out.println("DemoClass de-serialized: " + readIn());
    }

    private static Object readIn()
            throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
        return ois.readObject();
    }
}

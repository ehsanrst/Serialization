package serialization;

import java.io.*;
import java.util.logging.Logger;

/**
 * If a serialization class does not explicitly declare a serialization,
 * then the serialization runtime will calculate a default serialization
 * value for that class based on various aspects of the class.
 */

public class Serialization implements Serializable {

    private static final long serialVersionUID = 4L; //Default serial version uid
    private static final String fileName = "DemoClassBytes.ser";
    private static final Logger logger = Logger.getLogger("");

    //Few data field able to serialize
    private int intVariable;
    //Not able to serialize (need readObject and writeObject methods)
    private static String staticVariable;
    transient private String transientVariable = "this is a transient instance field";
    private Thread threadClass;

    public static void main(String[] args)
            throws IOException {

        //serialization.Serialization
        Serialization demo = new Serialization();
        demo.intVariable = 1;
        staticVariable = "this is a static variable";
        writeOut(demo);
        System.out.println("DemoClass to be saved: " + demo);
    }

    private static void writeOut(Serializable obj)
            throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        oos.writeObject(obj);
        oos.close();
    }

    @Override
    public String toString() {
        return "\n DemoClass: final static fileName=" + fileName
                + "\n, final static logger=" + logger
                + "\n, non-final static staticVariable=" + staticVariable
                + "\n, instance intVariable=" + intVariable
                + "\n, transient instance transientVariable=" + transientVariable
                + "\n, non-serialization instance field threadClass:=" + threadClass;
    }

}

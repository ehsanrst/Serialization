package serializationXML;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Default java serialization convert the java objects into bytes to send over network.
 * But many times you will need a more cross-platform medium to send this information like XML
 */

public class XMLEncoderDecoderExample {

    public static void main(String[] args)
            throws IOException {

        UserSettings settings = new UserSettings();
        settings.setFieldOne(10000);
        settings.setFieldTwo("HowToDoInJava.com");
        settings.setFieldThree(false);

        //Before
        System.out.println(settings);
        serializeToXML(settings);
        //After
        UserSettings loadedSettings = deserializeFromXML();
        System.out.println(loadedSettings);
    }

    /**
     * XMLEncoder use reflection to find out what fields they contain.
     * Objects that are to be encoded don’t need to be Serializable, but they do need to:
     * 1.The object has a public empty (no-arg) constructor
     * 2.The object has public getters and setters for each protected/private property.
     */

    /**
     * if the default value of a property hasn’t changed in object to be written,
     * the XmlEncoder will not write it out.
     * For example, in our case fieldThree is of type boolean which has default value as false;
     * so it has been omitted from XML content.
     * This allows the flexibility of changing what a default value is between versions of the class.
     */
    private static void serializeToXML(UserSettings settings) throws IOException {

        XMLEncoder encoder = new XMLEncoder(new FileOutputStream("settings.xml"));

        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });

        encoder.writeObject(settings);
        encoder.close();
    }

    /**
     * The XMLEncoder and XMLDecoder is much more forgiving than the serialization framework.
     * When decoding, if a property changed its type, or if it was deleted/added/moved/renamed,
     * the decoding will decode “as much as it can” while skipping the properties that it couldn’t decode.
     */
    private static UserSettings deserializeFromXML() throws IOException {

        XMLDecoder decoder = new XMLDecoder(new FileInputStream("settings.xml"));
        UserSettings decodedSettings = (UserSettings) decoder.readObject();
        decoder.close();

        return decodedSettings;
    }
}

package customSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * To customize serialization and deserialization, define readObject() and writeObject()
 * methods in this class.
 * the sequence of class attributes in read and write methods MUST BE same.
 */

public class User implements Serializable {

    private static final long serialVersionUID = 7829136421241571165L;

    private String firstName;
    private String lastName;
    private int accountNumber;
    private Date dateOpened;

    public User(String firstName, String lastName, int accountNumber, Date dateOpened) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
    }

    public User() {
        super();
    }

    private void readObject(ObjectInputStream aInputStream)
            throws ClassNotFoundException, IOException {

        firstName = aInputStream.readUTF();
        lastName = aInputStream.readUTF();
        accountNumber = aInputStream.readInt();
        dateOpened = new Date(aInputStream.readLong());
    }

    private void writeObject(ObjectOutputStream aOutputStream)
            throws IOException {

        aOutputStream.writeUTF(firstName);
        aOutputStream.writeUTF(lastName);
        aOutputStream.writeInt(accountNumber);
        aOutputStream.writeLong(dateOpened.getTime());
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final int getAccountNumber() {
        return accountNumber;
    }

    public final Date getDateOpened() {
        return new Date(dateOpened.getTime());
    }

    public final void setFirstName(String aNewFirstName) {
        firstName = aNewFirstName;
    }

    public final void setLastName(String aNewLastName) {
        lastName = aNewLastName;
    }

    public final void setAccountNumber(int aNewAccountNumber) {
        accountNumber = aNewAccountNumber;
    }

    public final void setDateOpened(Date aNewDate) {
        Date newDate = new Date(aNewDate.getTime());
        dateOpened = newDate;
    }

    /**
     * Sometimes you may have requirement where you only want to perform any specific validation,
     * or run some business rules on deSerialized object – without affecting default java serialization mechanism.
     * This is also possible when you decide to use readObject() and writeObject() methods.
     *
     * In this useCase, you can use defaultReadObject() and defaultWriteObject() inside readObject()
     * and writeObject() methods – to enable default serialization and deserialization.
     * And you can then plugin you custom validation or business rules inside read/write methods.
     */

    /*************************************************
     * //class attributes, constructors, setters and getters as shown above
     *
     * private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
     *
     * //perform the default de-serialization first
     *  aInputStream.defaultReadObject();
     *
     * // make defensive copy of the mutable Date field
     *  dateOpened = new Date(dateOpened.getTime());
     * }
     *
     * private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
     *
     * //perform the default serialization for all non-transient, non-static fields
     *  aOutputStream.defaultWriteObject();
     * }
     *************************************************/
}

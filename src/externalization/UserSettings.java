package externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The default java serialization is not efficient.
 * If you serialize an object, having lots of attributes and properties
 * you do not wish to serialize for any reason.
 * To solve this issue, you can write your own serialization logic by implementing
 * Externalizable interface and overriding it’s methods writeExternal() and readExternal().
 * By implementing these methods, you are telling the JVM how to encode/decode your object.
 */

public class UserSettings implements Externalizable {

    //This is required
    public UserSettings() {

    }

    private String doNotStoreMe;

    private Integer fieldOne;
    private String fieldTwo;
    private boolean fieldThree;

    /*The readExternal() method must read the values in the same sequence
     and with the same types as were written by writeExternal().*/
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {

        fieldOne = in.readInt();
        fieldTwo = in.readUTF();
        fieldThree = in.readBoolean();
    }

    //Choose what be externalized
    public void writeExternal(ObjectOutput out)
            throws IOException {

        //We are not storing the field 'doNotStoreMe'
        out.writeInt(fieldOne);
        out.writeUTF(fieldTwo);
        out.writeBoolean(fieldThree);
    }

    @Override
    public String toString() {
        return "UserSettings [doNotStoreMe=" + doNotStoreMe
                + ", fieldOne=" + fieldOne
                + ", fieldTwo=" + fieldTwo
                + ", fieldThree=" + fieldThree + "]";
    }

    public String getDoNotStoreMe() {
        return doNotStoreMe;
    }

    public void setDoNotStoreMe(String doNotStoreMe) {
        this.doNotStoreMe = doNotStoreMe;
    }

    public Integer getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(Integer fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    public boolean isFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(boolean fieldThree) {
        this.fieldThree = fieldThree;
    }
}

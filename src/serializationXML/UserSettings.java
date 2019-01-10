package serializationXML;

//no need to implement Serializable
public class UserSettings {

    public UserSettings() {
        //it is necessary
    }

    private Integer fieldOne;
    private String fieldTwo;
    private boolean fieldThree;

    @Override
    public String toString() {
        return "UserSettings [fieldOne=" + fieldOne
                + ", fieldTwo=" + fieldTwo
                + ", fieldThree=" + fieldThree + "]";
    }

    /**
     * Setters and Getters are Necessary (for Private or Protected fields)
     */
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

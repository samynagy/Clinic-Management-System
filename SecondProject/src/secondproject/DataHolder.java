package secondproject;


public class DataHolder {
    private static String enteredId,enteredname,enteredphone , docname;

    public static String getEnteredId() {
        return enteredId;
    }
public static String getEnteredName() {
        return enteredname;
    }
public static String getDOCName() {
        return docname;
    }
public static String getEnteredPhone() {
        return enteredphone;
    }
    public static void setEnteredId(String id) {
        enteredId = id;
    }
    public static void setEnteredName(String name) {
        enteredname = name;
    }
     public static void setDOCName(String name) {
        docname = name;
    }
    public static void setEnteredPhone(String phone) {
        enteredphone = phone;
    }
}

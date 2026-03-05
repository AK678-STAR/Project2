//ValidationUtils
package utils;

public class ValidationUtils {

    public static boolean isValidTourID(String id) {
        return id.matches("^T\\d{5}$");
    }

    public static boolean isValidBookingID(String id) {
        return id.matches("^B\\d{5}$");
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
}
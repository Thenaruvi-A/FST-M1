package activities;

class CustomException extends Exception {
    private String message;

    public CustomException(String msg) {
        message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
}

public class Activity8 {
    public static void main(String[] args) {
        try {
            CustomException.exceptionTest("Will print to console");
            CustomException.exceptionTest(null);  // Throws exception
            CustomException.exceptionTest("Won't execute");
        } catch (CustomException exp) {
            System.out.println("Inside catch block: " + exp.getMessage());
        }
    }
}
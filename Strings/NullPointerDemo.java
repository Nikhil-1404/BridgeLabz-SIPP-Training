public class NullPointerDemo {
    public static void generateException() {
        String text = null;
        int length = text.length();
        System.out.println("Length is: " + length);
    }

    public static void handleException() {
        String text = null;
        try {
            int length = text.length();
            System.out.println("Length is: " + length);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateException();
        handleException();
    }
}

public class ConcatenateUsingStringBuffer {
    public static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " Have", " a", " nice", " day."};
        String result = concatenateStrings(words);
        System.out.println("Concatenated String: " + result);
    }
}

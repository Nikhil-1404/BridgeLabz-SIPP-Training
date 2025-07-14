public class StringConcatPerformance {

    public static void usingString(int N) {
        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) {
            s += "a"; // creates new String object each time
        }
        long end = System.nanoTime();
        System.out.println("Using String: " + (end - start)/1e6 + " ms");
    }

    public static void usingStringBuilder(int N) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long end = System.nanoTime();
        System.out.println("Using StringBuilder: " + (end - start)/1e6 + " ms");
    }

    public static void usingStringBuffer(int N) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long end = System.nanoTime();
        System.out.println("Using StringBuffer: " + (end - start)/1e6 + " ms");
    }

    public static void main(String[] args) {
        int N = 10000; // Try with 1000, 10,000, and 1,000,000 as per table

        System.out.println("Concatenation performance for N = " + N);
        usingString(N);
        usingStringBuilder(N);
        usingStringBuffer(N);
    }
}

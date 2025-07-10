public class StringBufferVsBuilderPerformance {
    public static void main(String[] args) {
        int n = 1000000; // 1 million

        // Testing StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();

        for(int i = 0; i < n; i++) {
            stringBuffer.append("hello");
        }

        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;
        System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000 + " ms");

        // Testing StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();

        for(int i = 0; i < n; i++) {
            stringBuilder.append("hello");
        }

        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;
        System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000 + " ms");
    }
}

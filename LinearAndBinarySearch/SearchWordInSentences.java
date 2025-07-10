public class SearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for(int i = 0; i < sentences.length; i++) {
            if(sentences[i].contains(word)) {
                return sentences[i]; // return the first sentence containing the word
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue.",
            "I love programming in Java.",
            "Data Structures and Algorithms are important.",
            "Practice makes a man perfect."
        };

        String word = "Java";
        String result = findSentenceWithWord(sentences, word);

        System.out.println("Result: " + result);
    }
}

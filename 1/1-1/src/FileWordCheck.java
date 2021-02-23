import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileWordCheck {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files
                .readAllBytes(Paths.get("test.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = 0;
        for (String w :words){
            if (w.length()>2) count++;
        }
        System.out.println(count);

        count = words.stream()
                .filter(w -> w.length() > 2).count();
        System.out.println(count);

        count = words.parallelStream()
                .filter(w -> w.length() > 2).count();
        System.out.println(count);

        Stream wordsStream = words.stream().filter(w -> w.length() > 2);
        System.out.println(wordsStream.count());
        System.out.println(wordsStream.count());
    }
}

package languagetables;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final String FILE_NAME = "./docs/hello.pdf";

    public static void main(String[] args) throws Exception {
        Path docPath = Paths.get(FILE_NAME);
        Files.createDirectories(docPath.getParent());
        System.out.printf("Write pdf to file: %s%n", docPath.toAbsolutePath());

        Word[] words = {
                new Word("Word 1"),
                new Word("Word 2"),
                new Word("Word 3"),
                new Word("Word 4"),
        };

        DocumentGenerator generator = new BaseDocumentGenerator();
        generator.generateDoc(words, docPath);
    }
}

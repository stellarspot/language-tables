package languagetables;

import java.nio.file.Path;

public interface DocumentGenerator {

    void generateDoc(Word[] words, Path docPath) throws GeneratorException;
}

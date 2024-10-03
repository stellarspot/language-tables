package languagetables;

public interface PageSplitter {

    int maxSize();
    IndexPair split(int size);
}

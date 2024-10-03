package languagetables;

public class Word {
    private final String main;
    private final String[] list;

    public Word(String main, String... list) {
        this.main = main;
        this.list = list;
    }

    public String getMain() {
        return main;
    }

    public String[] getList() {
        return list;
    }
}

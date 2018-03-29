package Service.Element;

public class Word {
    private String engWord;
    private String rusWord;

    public Word(String engWord, String rusWord) {
        this.engWord = engWord;
        this.rusWord = rusWord;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getRusWord() {
        return rusWord;
    }

    public void setRusWord(String rusWord) {
        this.rusWord = rusWord;
    }
}

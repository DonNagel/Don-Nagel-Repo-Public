class Transposer {
    private String fileName;

    public Transposer(String fileName) {
        this.fileName = fileName;
    }
}

public class Transposition {
    public static void main(String[] args) {
        Transposer transposer = new Transposer("input.txt");
    }
}

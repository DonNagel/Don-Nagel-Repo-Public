import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Transposer {
    private String fileName;
    private char[] data;
    private int inputInstrument;
    private int outputInstrument;

    public Transposer(String fileName) {
        this.fileName = fileName;
        this.data = new char[0];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number corresponding to the input instrument\n 1. Piano, Flute, Oboe, Bassoon, Trombone, Tuba, Strings.\n" 
        + "2. Bb Clarinet, Bass Clarinet, Soprano Sax, Tenor Sax Bb Trumpet\n"
        + "3. Eb Clarinet, Alto Sax, Baritone Sax\n"
        + "4. French Horn, English Horn.\n");
        this.inputInstrument = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Please enter a number corresponding to the output instrument\n 1. Piano, Flute, Oboe, Bassoon, Trombone, Tuba, Strings.\n" 
        + "2. Bb Clarinet, Bass Clarinet, Soprano Sax, Tenor Sax Bb Trumpet\n"
        + "3. Eb Clarinet, Alto Sax, Baritone Sax\n"
        + "4. French Horn, English Horn.\n");
        this.outputInstrument = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        scanner.close();

    }
    public void readFile(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                input = input.replaceAll(",", ""); // Remove all whitespace characters
                this.data = input.toCharArray();
            }
            System.out.println(data[0]+" "+data[2]);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }
    public String getData() {
        return new String(data);
    }
    public char[] transpose(char[] data, int inputInstrument, int outputInstrument) {
        


}

public class Transposition {
    public static void main(String[] args) {
        Transposer transposer = new Transposer("input.txt");
        transposer.readFile("input.txt");
        System.out.println(transposer.getData());
    }
}

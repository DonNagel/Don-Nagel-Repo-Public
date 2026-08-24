import java.util.Scanner;

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
        System.out.println(inputInstrument);
        System.out.println(outputInstrument);

    }
}

public class Transposition {
    public static void main(String[] args) {
        Transposer transposer = new Transposer("input.txt");
    }
}

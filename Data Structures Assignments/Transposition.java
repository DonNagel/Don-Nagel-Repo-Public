import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class Transposer {
    private char[] data;
    private final char[] compareData = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
    private int inputInstrument;
    private int outputInstrument;

    public Transposer(String fileName) {
        this.data = new char[0];

        //Get information from the user about what instrument is the input and what to translate it to.
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
        scanner.nextLine();
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
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }
    public void writeFile() {
        try (FileWriter myWriter = new FileWriter("output.txt")) {
            for (char note : data) {
                myWriter.write(note);
                myWriter.write(',');
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public String getData() {
        return new String(data);
    }
    //The mathematical formula for the transposition process.
    public char[] transposeTo() {
        //For the formula section.
        int comparator = 0;
        int index = 0;
        int mod = 0;
        if (inputInstrument == outputInstrument || inputInstrument == 1) {
            return data;
            //If values are the same, no transposition is needed, return original data.
            //If input = 1, no transpositon to is needed. return data as is.
        }
        //All input values are first set to 'C' transpositon, the base value for music.
        switch (inputInstrument) {
            //Bb instruments are set to 1, because of a 1 step difference in notes.
            case 2:
                mod = -1;
                break;
            //Eb instruments are set to 6, because of a 6 step difference in notes.
            case 3:
                mod = -5;
                break;
            //F instruments are set to 4, because of a 4 step difference.
            case 4:
                mod = -4;
                break;
        }

        for (char note : data) {
            //Converts to C.
            
            if (note == 'a') {
                comparator = 0;
            } else if (note == 'b') {
                comparator = 1;
            } else if (note == 'c') {
                comparator = 2;
            } else if (note == 'd') {
                comparator = 3;
            } else if (note == 'e') {
                comparator = 4;
            } else if (note == 'f') {
                comparator = 5;
            } else if (note == 'g') {
                comparator = 6;
            }
            comparator = comparator + mod;
            if (comparator < 0) {
                comparator = comparator + 7;
            }
            data[index] = compareData[comparator];
            index = index + 1;
        }
        return data;
    }
    public char[] transposeFrom() {
        //For the formula section.
        int comparator = 0;
        int index = 0;
        int mod = 0;
        if (inputInstrument == outputInstrument || outputInstrument == 1) {
            return data;
            //If values are the same, no transposition is needed, return original data.
            //If input = 1, no transpositon to is needed. return data as is.
        }
        //All input values are first set to 'C' transpositon, the base value for music.
        switch (outputInstrument) {
            //Bb instruments are set to 1, because of a 1 step difference in notes.
            case 2:
                mod = 1;
                break;
            //Eb instruments are set to 6, because of a 6 step difference in notes.
            case 3:
                mod = 5;
                break;
            //F instruments are set to 4, because of a 4 step difference.
            case 4:
                mod = 4;
                break;
        }

        for (char note : data) {
            //Converts to C.
            
            if (note == 'a') {
                comparator = 0;
            } else if (note == 'b') {
                comparator = 1;
            } else if (note == 'c') {
                comparator = 2;
            } else if (note == 'd') {
                comparator = 3;
            } else if (note == 'e') {
                comparator = 4;
            } else if (note == 'f') {
                comparator = 5;
            } else if (note == 'g') {
                comparator = 6;
            }
            comparator = comparator + mod;
            if (comparator > 6) {
                comparator = comparator - 7;
            }
            data[index] = compareData[comparator];
            index = index + 1;
        }
        return data;
    }
public class Transposition {
    public static void main(String[] args) {
        Transposer transposer = new Transposer("input.txt");
        transposer.readFile("input.txt");
        System.out.println(transposer.getData());
        System.out.println(transposer.transposeTo());
        System.out.println(transposer.transposeFrom());
        transposer.writeFile();
    }
}
}

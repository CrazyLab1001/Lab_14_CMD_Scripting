import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) {
        // JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        File selectedFile;
        String line;
        // String fileName;
        int lineCount = 0;
        int wordCount = 0;
        int characterCount = 0;
        // ArrayList<Object> wordCounter = new ArrayList<>();
        //Path target = new File(System.getProperty("user.dir")).toPath();
        //target = target.resolve("src"); // opens in project src folder
        Path target;
        // chooser.setCurrentDirectory(target.toFile());
        if (args.length > 0) {
            target = Paths.get(args[0]);
        } else {
            JFileChooser chooser = new JFileChooser();
            target = new File(System.getProperty("user.dir")).toPath();
            chooser.setCurrentDirectory(target.toFile());
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
            }
            else {
                System.out.println("You have to select a file! Ending program.");
                System.exit(0);
            }
        }
        try  // Below is if file is selected
        {
            inFile = new Scanner(target);

                do {
                    line = inFile.nextLine();
                    wordCount += line.split("\\s+").length;
                    characterCount += line.length();
                    System.out.println(line); // echos the file text
                    lineCount++;
                } while (inFile.hasNextLine());
                inFile.close(); // close file
                System.out.println();
                System.out.println("File name: " + target.toFile().getName());
                System.out.println("Line Count: " + lineCount);
                System.out.println("Word Count: " + wordCount);
                System.out.println("Character Count: " + characterCount);
            }

        catch (FileNotFoundException e) // Errors other than unpicked file
        {
            System.out.println("File Not Found Error!");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error!");
            e.printStackTrace();
        }
    }

}
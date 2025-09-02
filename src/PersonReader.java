import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class PersonReader {
    public static void main(String[] args) {
        // Create a file chooser so the user can pick a file
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target.toFile());

                System.out.printf("%-8s %-15s %-15s %-10s %-6s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==========================================================");


                while(inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    String[] piece = line.split(",");

                    String id = piece[0];
                    String firstName = piece[1];
                    String lastName = piece[2];
                    String title = piece[3];
                    String birthYear= piece[4];
                    System.out.printf("%-8s %-15s %-15s %-10s %-6s %n", id, firstName, lastName, title, birthYear);
                }

                inFile.close();
            }
            else
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }


    }

}



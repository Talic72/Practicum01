import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        try
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target.toFile());

                System.out.printf("%-11s %-20s %-25s %-19s %n", "ID#", "Name", "Description", "Cost");
                System.out.println("====================================================================");


                while(inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    String[] piece = line.split(",");

                    String id = piece[0];
                    String name = piece[1];
                    String description = piece[2];
                    String cost = piece[3];
                    System.out.printf("%-10s %-20s %-25s %-20s %n", id, name, description, cost);
                }

                inFile.close();
            }
            else
            {
                System.out.println("Sorry, you must select a file! Terminating!");
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

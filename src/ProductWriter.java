import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<String>();
        System.out.println("Hello, please enter the data as it asks for your persons when directed.");
        String fileName = "ProductTestData";
        boolean done = false;

        while (!done) {
            String id = SafeInput.getRegExString(in, "ID number", "\\d+");
            String name = SafeInput.getNonZeroLenString(in, "Name");
            String description = SafeInput.getNonZeroLenString(in, "Description");
            double cost = SafeInput.getDouble(in, "Cost");

            String recording = id + ", " + name + ", " + description + ", " + cost + ", " ;
            data.add(recording);
            done = !SafeInput.getYNConfirm(in, "Would you like to enter another record: Y/N?");
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String rec : data) {
                writer.write(rec + "\n");

            }
            System.out.println("Successfully saved" + fileName + ".txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

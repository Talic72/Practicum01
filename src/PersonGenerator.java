import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<String>();
        System.out.println("Hello, please enter the data as it asks for your persons when directed.");
        String fileName = "PersonTestData";
        boolean done = false;

        while (!done) {
            String id = SafeInput.getRegExString(in, "ID number", "\\d+");
            String firstName = SafeInput.getNonZeroLenString(in, "First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Title");
            int birthYear = SafeInput.getInt(in, "Birth Year");

            String recording = id + ", " + firstName + ", " + lastName + ", " + title + ", " + birthYear;
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

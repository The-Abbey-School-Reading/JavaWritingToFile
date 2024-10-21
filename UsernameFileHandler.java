import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class UsernameFileHandler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for username
        System.out.print("Enter your username: ");
        String username = input.nextLine();

        // Append username to file
        try {
            FileWriter writer = new FileWriter("username.txt", true); // 'true' for append mode
            writer.write(username + "\n");
            writer.close();
            System.out.println("Username successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Read and check username from file
        try {
            File file = new File("username.txt");
            Scanner reader = new Scanner(file);
            boolean found = false;
            while (reader.hasNextLine()) {
                String readUsername = reader.nextLine();
                System.out.println(readUsername);
                if (username.equals(readUsername)) {
                    found = true;
                    break;
                }
            }
            reader.close();
            if (found) {
                System.out.println("The username was found in the file!");
            } else {
                System.out.println("The username was not found in the file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        input.close();
    }
}

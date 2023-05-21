import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private Map<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addNumber(String name, String number) {
        phoneBook.put(name, number);
    }

    public void displayAll() {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите 1 для добавления номера");
            System.out.println("Введите 2 для вывода всего");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Введите фамилию:");
                String name = scanner.next();
                System.out.println("Введите номер:");
                String number = scanner.next();
                phoneBook.addNumber(name, number);
            } else if (choice == 2) {
                phoneBook.displayAll();
            } else {
                break;
            }
        }
    }
}
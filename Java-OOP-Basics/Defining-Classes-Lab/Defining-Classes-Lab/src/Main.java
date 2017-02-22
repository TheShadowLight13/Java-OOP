import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accountById = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("End")) {

            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {

                case "Create":
                   createBankAccount(accountById, data);
                    break;
                case "Deposit":
                    depositInAccount(accountById, data);
                    break;
                case "Withdraw":
                    withDrawFromAccount(accountById, data);
                    break;
                case "Print":
                    printAccount(accountById, data);
                    break;
            }
            input = reader.readLine();
        }

    }

    private static void printAccount(HashMap<Integer, BankAccount> accountById, String[] data) {

        int id = Integer.valueOf(data[1]);

        if (!accountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        System.out.println(accountById.get(id).toString());
    }

    private static void withDrawFromAccount(HashMap<Integer, BankAccount> accountById, String[] data) {

        int id = Integer.valueOf(data[1]);
        double amount = Double.valueOf(data[2]);

        if (!accountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        accountById.get(id).withDraw(amount);
    }

    private static void depositInAccount(HashMap<Integer, BankAccount> accountById, String[] data) {

        int id = Integer.valueOf(data[1]);
        double amount = Double.valueOf(data[2]);

        if (!accountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        accountById.get(id).deposit(amount);
    }

    private static void createBankAccount(HashMap<Integer, BankAccount> accountById, String[] data) {

        int id = Integer.valueOf(data[1]);
            if (accountById.containsKey(id)) {
            System.out.println("Account already exists");
        }else {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(id);
            accountById.put(id, bankAccount);
        }
    }
}

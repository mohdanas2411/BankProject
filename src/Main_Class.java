import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Main_Class {
    static Set<Account> accounts = new HashSet<>();
    static Scanner scan = new Scanner(System.in);

    //    public static final String TEXT_RED = "\u001B[31m";
//    public static final String TEXT_RESET = "\u001B[0m";
//    public static final String TEXT_GREEN = "\u001B[32m";
    static int accountNo = 6082001;

    public static final String TEXT_RED = "\u001B[0m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[0m";

    static void addNewUser(MyBank obj, String name) {

        Account ac3 = getAccountByName(name);
        if (ac3 != null)
            System.out.println(TEXT_RED + "\n************** Your account already existed **************" + TEXT_RESET);
        else {
            Account ac4 = new Account();
            ac4.setName(name);
            if (obj instanceof SBI_Bank) {
                ac4.setMaxAccLim(100000);
                ac4.setMinAccLim(5000);
                ac4.setMinDeposit(500);
                ac4.setMaxDeposit(10000);
                ac4.setMinWithdraw(100);
                ac4.setMaxWithdraw(500);
            } else if (obj instanceof YES_Bank) {
                ac4.setMaxAccLim(200000);
                ac4.setMinAccLim(10000);
                ac4.setMinDeposit(1000);
                ac4.setMaxDeposit(5000);
                ac4.setMinWithdraw(200);
                ac4.setMaxWithdraw(1000);
            }
            boolean Continue = false;
            do {


                // System.out.print("\nEnter Initial Account Balance: must be in range of " + ac4.getMinAccLim() + " to " + ac4.getMaxAccLim() + " : ");
                //  System.out.print(TEXT_GREEN + "New Registration in " + obj.toString() + "\nEnter Initial Account Balance: for new Account : " + TEXT_RESET);


                boolean cont = true;
                String amount;
                do {
                    System.out.print("\nEnter Initial Account Balance: for new Account : ");

//                    System.out.print("New Registration in " + obj.toString() + "\nEnter Initial Account Balance: for new Account : ");
                    amount = scan.next();
                    if (Pattern.matches("^([0-9]+\\.?[0-9]*|[0-9]*\\.[0-9]+)$", amount)) {
                        cont = false;

                    } else {
                        System.out.println(Main_Class.TEXT_RED + "\nInvalid Input" + Main_Class.TEXT_RESET);
                        System.out.println("\n\nPress any key : Try Again\nPress 0 : Exit");
                        if (scan.next().equals("2")) cont = false;
                    }
                } while (cont);


                // double balance = scan.nextDouble();

                double balance = Double.parseDouble(amount);

                if (balance > Double.MAX_VALUE) {
                    System.out.print(TEXT_RED + "\nInitial Account Balance: must be in range of " + ac4.getMinAccLim() + " to " + ac4.getMaxAccLim() + " : " + TEXT_RESET);
                } else {
                    if (balance <= ac4.getMaxAccLim() && balance >= ac4.getMinAccLim()) {
                        ac4.setBalance(balance);
                        ac4.setBankName(obj.toString());
                        ac4.setAccountNo(accountNo++);
                        System.out.println(TEXT_GREEN + "you are successfully Registered in " + obj.toString() + TEXT_RESET);
                        accounts.add(ac4);
                        Continue = true;
                        existingUser(obj, ac4);
                    } else {
                        System.out.println(TEXT_RED + "Initial Account Balance: must be in range of " + ac4.getMinAccLim() + " to " + ac4.getMaxAccLim() + TEXT_RESET);
                    }
                }
            } while (!Continue);
        }
    }

    boolean TU(String name) {
        return Pattern.matches("[a-zA-z]", name);
    }

    static void existingUser(MyBank obj, Account ac) {

        String operation = null;
        do {
            System.out.println("\n\nEnter your choice for bank operations");
            System.out.print("Press 1 for Withdraw\t\tPress 2 for Deposit\t\tPress 3 for Info\t\tPress 0 for Exit\nChoice : ");
            operation = scan.next();
            switch (operation) {
                case "1":
                    obj.withdraw(ac);
                    break;
                case "2":
                    obj.deposit(ac);
                    break;
                case "3":
                    System.out.println(ac.toString());
                    break;
                case "0":
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println(TEXT_RED + "\n************** Wrong Input Try Again **************" + TEXT_RESET);
            }
        } while (!operation.equals("0"));
    }

    static void bankOperations(MyBank obj) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nPress 1 : Existing " + obj.toString() + " Customer\nPress 2 : New To " + obj.toString() + "\nPress 3 : Exit\nChoice : ");
        String selectNewOrExisted = scan.next();

        switch (selectNewOrExisted) {
            case "1": {
                boolean cont = true;
                do {
                    System.out.print("Enter your Name : ");
                    String name = scan.next();
                    if (Pattern.matches("[a-zA-Z ]*", name)) {
                        cont = false;
                        Account ac = getAccountByName(name);
                        if (ac.getBankName().equalsIgnoreCase(obj.toString())) {
                            if (ac == null) {
                                System.out.println(TEXT_RED + "\n************** No User Found. Register Yourself **************" + TEXT_RESET);
                                addNewUser(obj, name);
                            } else existingUser(obj, ac);
                        } else {
                            System.out.println(TEXT_RED + "User doesn't exit in " + obj.toString() + ". Register Yourself" + TEXT_RESET);
                            bankOperations(obj);
                        }
                    } else {
                        System.out.println(TEXT_RED + "Enter Correct Name" + TEXT_RESET);
                        System.out.println("\n\nPress any key : Try Again\nPress 0 : Exit");
                        if (scan.next().equals("2")) cont = false;
                    }
                } while (cont);
                break;
            }
            case "2": {
                boolean cont = true;
                do {
                    System.out.print("Enter your Name : ");
                    scan.nextLine();
                    String name = scan.nextLine();;
                    if (Pattern.matches("[a-zA-Z ]*", name)) {
                        cont = false;
                        addNewUser(obj, name);
                    } else {
                        System.out.println(TEXT_RED + "Enter Correct Name" + TEXT_RESET);
                        System.out.println("\n\nPress any key : Try Again\nPress 0 : Exit");
                        if (scan.next().equals("2")) cont = false;
                    }
                } while (cont);
                break;
            }
            case "3":
                System.out.println("Exit");
                break;
            default:
                System.out.println(TEXT_RED + "Wrong input try again");
                bankOperations(obj);
                break;
        }

    }

    static String reEnterOrExit() {
        System.out.print("Press 1 for Re-Enter amount\nPress 2 for Exit\nChoice : ");
        return scan.next();
    }

    static Account getAccountByName(String name) {
        for (Account acc : accounts)
            if (acc.getName().equalsIgnoreCase(name)) return acc;
        return null;
    }

    static void storeData() throws IOException {

        try {

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("resources//MyFile.txt"));
            outputStream.writeObject(accounts);
            outputStream.close();

            //   new FileOutputStream("resources//Account_No.txt", false).close();

//            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("resources//Account_No.txt", false)));
//            dos.writeInt(accountNo);
//            dos.close();


            File file = new File("resources//Account_No.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(accountNo + "");
            bw.close();

        } catch (FileNotFoundException f) {
            f.getStackTrace();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("resources//MyFile.txt"));
            accounts = (Set<Account>) inputStream.readObject();
            inputStream.close();
            //  new FileInputStream("resources//Account_No.txt").close();

            File file = new File("resources//Account_No.txt");
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            accountNo = Integer.parseInt(br.readLine());
            br.close();

//            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("resources//Account_No.txt")));
//            accountNo = dis.readInt();
//            dis.close();

        } catch (FileNotFoundException f) {
            System.out.println(f.getStackTrace());
            System.out.println(f.getMessage());
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        }

        Scanner scan = new Scanner(System.in);
        String choice;
        do {
            System.out.print("\nPress 1 for SBI Bank\nPress 2 for YES Bank\nPress 3 for Exit\nChoice : ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    MyBank sbi_Bank = new SBI_Bank();
                    System.out.println("************* Welcome to SBI Bank *************");

                    bankOperations(sbi_Bank);
                    break;

                case "2":
                    MyBank Yes_Bank = new YES_Bank();
                    System.out.println("************* Welcome to YES Bank *************");
                    bankOperations(Yes_Bank);
                    break;
                case "3":
                    System.out.println(TEXT_GREEN + "Thank You" + TEXT_RESET);
                    storeData();
                    break;
                default:
                    System.out.println(TEXT_RED + "Entered wrong input Try again" + TEXT_RESET);
            }

        } while (!choice.equals("3"));
    }
}

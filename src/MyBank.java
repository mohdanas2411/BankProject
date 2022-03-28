import java.util.regex.Pattern;

public abstract class MyBank {
    public void withdraw(Account acc) {


        boolean cont = true;
        String amt;
        do {
            System.out.print(Main_Class.TEXT_GREEN + "Enter amount for withdraw : " + Main_Class.TEXT_RESET);

            amt = Main_Class.scan.next();
            if (Pattern.matches("^([0-9]+\\.?[0-9]*|[0-9]*\\.[0-9]+)$", amt)) {
                cont = false;

            } else {
                System.out.println(Main_Class.TEXT_RED + "\nInvalid Input" + Main_Class.TEXT_RESET);
                System.out.println("\n\nPress any key : Try Again\nPress 0 : Exit");
                if (Main_Class.scan.next().equals("2")) cont = false;
            }
        } while (cont);


        Double amount = Double.parseDouble(amt);

        if (amount < acc.getMinWithdraw()) {
            System.out.println(Main_Class.TEXT_RED + "Minimum Withdraw amount limit is " + acc.getMinWithdraw() + Main_Class.TEXT_RESET);
            if (Main_Class.reEnterOrExit().equals("1"))
                withdraw(acc);
        } else if (amount > acc.getMaxWithdraw()) {
            System.out.println(Main_Class.TEXT_RED + "Maximum Withdraw amount limit is " + acc.getMaxWithdraw() + Main_Class.TEXT_RESET);
            if (Main_Class.reEnterOrExit().equals("1"))
                withdraw(acc);
        } else {
            if (acc.getBalance() - amount >= acc.getMinAccLim()) {
                acc.setBalance(acc.getBalance() - amount);
                System.out.println(Main_Class.TEXT_GREEN + amount + " Rs withdraw successfully available balance is :" + acc.getBalance() + Main_Class.TEXT_RESET);
            } else {
                System.out.println(Main_Class.TEXT_RED + "Your account must maintain minimum balance of " + acc.getMinAccLim() + " : withdraw less amount" + Main_Class.TEXT_RESET);
                if (Main_Class.reEnterOrExit().equals("1"))
                    withdraw(acc);
            }
        }
    }

    public void deposit(Account acc) {


        boolean cont = true;
        String amt;
        do {
            System.out.print(Main_Class.TEXT_GREEN + "Enter amount for deposit : " + Main_Class.TEXT_RESET);

            amt = Main_Class.scan.next();
            if (Pattern.matches("^([0-9]+\\.?[0-9]*|[0-9]*\\.[0-9]+)$", amt)) {
                cont = false;

            } else {
                System.out.println(Main_Class.TEXT_RED + "\nInvalid Input" + Main_Class.TEXT_RESET);
                System.out.println("\n\nPress any key : Try Again\nPress 0 : Exit");
                if (Main_Class.scan.next().equals("2")) cont = false;
            }
        } while (cont);


        Double amount = Double.parseDouble(amt);

        if (amount < acc.getMinDeposit()) {
            System.out.println(Main_Class.TEXT_RED + "Minimum Deposit amount limit is : " + acc.getMinDeposit() + Main_Class.TEXT_RESET);
            if (Main_Class.reEnterOrExit().equals("1"))
                deposit(acc);
        } else if (amount > acc.getMaxDeposit()) {
            System.out.println(Main_Class.TEXT_RED + "Maximum Deposit amount limit is : " + acc.getMaxDeposit() + Main_Class.TEXT_RESET);
            if (Main_Class.reEnterOrExit().equals("1"))
                deposit(acc);
        } else {

            if (acc.getBalance() + amount <= acc.getMaxAccLim()) {
                acc.setBalance(acc.getBalance() + amount);
                System.out.println(Main_Class.TEXT_GREEN + amount + " Rs deposit successfully, current balance is :" + acc.getBalance() + Main_Class.TEXT_RESET);
            } else {
                System.out.println(Main_Class.TEXT_RED + "Your account Maximum limit is " + acc.getMaxAccLim() + " : Deposit less amount " + Main_Class.TEXT_RESET);
                if (Main_Class.reEnterOrExit().equals("1"))
                    deposit(acc);
            }
        }
    }

}

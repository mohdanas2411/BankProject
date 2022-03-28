public class SBI_Bank extends MyBank {

//    @Override
//    public void withdraw(Account acc, Double amount) {
//        if (amount < acc.getMinWithdraw()) System.out.println("Minimum Withdraw amount limit is "+acc.getMinWithdraw());
//
//        else if (amount > acc.getMaxWithdraw()) System.out.println("Maximum Withdraw amount limit is "+acc.getMaxWithdraw());
//
//        else {
//            if (acc.getBalance() - amount >= acc.getMinAccLim()) {
//                acc.setBalance(acc.getBalance() - amount);
//                System.out.println(amount + " Rs withdraw successfully available balance is :" + acc.getBalance());
//            } else {
//                System.out.println("Your account must maintain minimum balance of "+acc.getMinAccLim()+" : withdraw less amount");
//            }
//        }
//    }

//    @Override
//    public void deposit(Account acc, Double amount) {
//        if (amount < acc.getMinDeposit()) System.out.println("Minimum Deposit amount limit is : "+acc.getMinDeposit());
//
//        else if (amount > acc.getMaxDeposit()) System.out.println("Maximum Deposit amount limit is : "+acc.getMaxDeposit());
//
//        else {
//
//            if (acc.getBalance() + amount <= acc.getMaxAccLim()) {
//                acc.setBalance(acc.getBalance() + amount);
//                System.out.println(Main_Class.TEXT_GREEN + amount + " Rs deposit successfully, current balance is :" + acc.getBalance() + Main_Class.TEXT_RESET);
//            } else
//                System.out.println(Main_Class.TEXT_RED + "Your account Maximum limit is "+acc.getMaxAccLim()+" : Deposit less amount " + Main_Class.TEXT_RESET);
//        }
//    }

    @Override
    public String toString() {
        return "SBI";
    }

    //    @Override
//    public void info() {
//
//    }
//
//    @Override
//    public void addUser() {
//
//    }
}

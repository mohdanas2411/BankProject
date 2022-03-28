import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private int accountNo;
    private String bankName;
    private double balance;
    private int minAccLim;
    private int minWithdraw;
    private int maxWithdraw;
    private int minDeposit;
    private int maxDeposit;

    public int getMinWithdraw() {
        return minWithdraw;
    }

    public void setMinWithdraw(int minWithdraw) {
        this.minWithdraw = minWithdraw;
    }

    public int getMaxWithdraw() {
        return maxWithdraw;
    }

    public void setMaxWithdraw(int maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    public int getMinDeposit() {
        return minDeposit;
    }

    public void setMinDeposit(int minDeposit) {
        this.minDeposit = minDeposit;
    }

    public int getMaxDeposit() {
        return maxDeposit;
    }

    public void setMaxDeposit(int maxDeposit) {
        this.maxDeposit = maxDeposit;
    }

    public int getMinAccLim() {
        return minAccLim;
    }

    public void setMinAccLim(int minAccLim) {
        this.minAccLim = minAccLim;
    }

    public int getMaxAccLim() {
        return maxAccLim;
    }

    public void setMaxAccLim(int maxAccLim) {
        this.maxAccLim = maxAccLim;
    }

    private int maxAccLim;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return
                Main_Class.TEXT_GREEN+"\n----- User Details -----"+Main_Class.TEXT_RESET+"\n\nName            : " + name + "\nAccount No      : " + accountNo + "\nBank Name       : " + bankName + "\nCurrent Balance : " + balance;
    }
}

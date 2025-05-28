class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;

    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public double getBalance(){
        return balance;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder=accountHolder;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public String toString(){
        return "Account: " +accountNumber+ ", Holder: " +accountHolder+ ", Balance: " +balance;
    }
    public void withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
        }else{
            throw new IllegalArgumentException("Insufficent balance");
        }
    }

}
class Bank{
    private BankAccount[] accounts=new BankAccount[5];
    private int count=0;

    public void addAccount(BankAccount account){
        if(count< accounts.length){
            accounts[count++]=account;
        }else{
            System.out.println("Can't add more accounts. ");
        }
    }
public void withdrawFromAccount(int accountNumber,double amount){
   
    for(int i=0; i<count; i++){
        if(accounts[i].getAccountNumber() == accountNumber){
            try{
                accounts[i].withdraw(amount);
                System.out.println("Withdrawla successful for account  " + accountNumber);

            }catch(IllegalArgumentException e){
                System.out.println("Error: " +e.getMessage());
            }
            return;
        }
    }
System.out.println("Account " +accountNumber+ " not found.");
}

public void displayAllAccounts(){
    for(int i=0; i<count; i++){
        System.out.println(accounts[i]);
    }
}
}

class BankManager{
    public static void main(String[] args){
        Bank bm=new Bank();
        bm.addAccount(new BankAccount(1001,"Alice",5000.0));
        bm.addAccount(new BankAccount(1002,"Bob",3000.0));

        bm.withdrawFromAccount(1001,6000.0);
        bm.withdrawFromAccount(1002,1000.0);
        bm.displayAllAccounts();
    }
}
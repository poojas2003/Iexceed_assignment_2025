class BankAccount{
        String AccountNumber,AccountHolder;
        double balance;

    public BankAccount(String AccountNumber,String AccountHolder,double balance) {
        this.AccountNumber=AccountNumber;
        this.AccountHolder=AccountHolder;
        this.balance=balance;
    }

    public void deposit(double  amount){
        balance+=amount;
        System.out.println("Balance After deposit"+balance);
     }
     
    public void withDraw(double amount) {
       if(balance>amount)
       {
        balance-=amount;
       }
       else{
        System.out.println("In sufficient Balance");
       }
    }

    public String getAccountNumber(){
       return AccountNumber;
    }
    public String getAccountHolder(){
        return AccountHolder;
    }

    public double getBalance(){
        return balance;
    }
 }

 class BankAccountNumber {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);
        
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: " + account.getBalance());
        
        account.deposit(500.0);
        System.out.println("Balance after deposit: " + account.getBalance());
        
        account.withDraw(200.0);
        System.out.println("Balance after withdrawal: " + account.getBalance());
        
        account.withDraw(1500.0); // Attempt to withdraw more than balance
    }
}
    
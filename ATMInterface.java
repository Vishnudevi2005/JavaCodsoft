import java.util.Scanner;
public class ATMInterface {
    private double balance;
    private final Scanner scanner;
    public ATMInterface(){
    this.balance=0.0;
    this.scanner=new Scanner(System.in);
    }
    public void displayMenu(){
       System.out.println("\nATM INTERFACE");
       System.out.println("1.Check Balance");
       System.out.println("2.Deposit Money");
       System.out.println("3.Withdraw Money");
       System.out.println("4.exit");
    }
    public void checkBalance(){
        System.out.printf
        ("enter the current balance is:%.2f\n",balance);

    }public void depoistMoney(){
        System.out.println("enter the amount to deposit");
        double amount=scanner.nextDouble();
        if(amount>0){
            balance+=amount;
            System.out.println("deposit successful!");

        }else{
            System.out.println("Invalid amount.Please enter a positive value");

        }
    }
    public void withdrawMoney(){
        System.out.println("enter the amount to withdraw:");
        double amount=scanner.nextDouble();
        if(amount>0&&amount<=balance){
            balance-=amount;
            System.out.println("withdrawal amount successful");
        }else if(amount>balance){
            System.out.println("insufficient balance");
        }else{
            System.out.println("invalid amount.please enter positive value");
        }
    }
        public static void main(String[] args){
            ATMInterface atm=new ATMInterface();
            boolean exit=false;
            while(!exit){
                atm.displayMenu();
                System.out.println("choose an option:");
                int choice=atm.scanner.nextInt();
                switch(choice){
                    case 1:
                    atm.checkBalance();
                    break;
                    case 2:
                    atm.depoistMoney();
                    break;
                    case 3:
                    atm.withdrawMoney();
                    break;
                    case 4:
                    System.out.println("Thank you for using the ATM . Goodbye!");
                   break;
                   default:
                   System.out.println("INVALID CHOICE.Please try again");
                }
            }
        }
    }

    


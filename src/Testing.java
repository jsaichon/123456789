
import int101.banking.AccountHistory;
import int101.banking.AccountTransaction;
import int101.banking.BankAccount;
import int101.banking.TransactionType;
import int101.base.Person;
import java.math.BigDecimal;

public class Testing {

    public static void main(String[] args) {
        //testPerson();
        //testBankAccount();
        testAccountHistory();
    }

    private static void testPerson() {
        Person p0 = new Person("Alan","Turing");
        Person p1 = new Person("Alonzo","Chruch");
        Person p2 = new Person("Haskell","Curry");
        System.out.println(p0 + "\n" + p1 + "\n" + p2);
        p0.setLastname("Kay");
        System.out.println("Turing change to Kay");        
        p1.setFirstname("John").setLastname("McCarthy");
        System.out.println("Alonzo Church change to John McCarthy");
        p2.setFirstname("James").setLastname("Gosling");
        System.out.println("Haskell Curry change to James Gosling");
        System.out.println(p0);
        System.out.println(p1);
        System.out.println(p2);
    }

    private static void testBankAccount() {
        Person p0 = new Person("Alan","Turing");
        Person p1 = new Person("Alonzo","Chruch");
        Person p2 = new Person("Alan","Kay");
        BankAccount ac0 = new BankAccount("Turing Account", p0);
        BankAccount ac1 = new BankAccount("Functional Account", p1);
        BankAccount ac2 = new BankAccount("Object Account", p2);
        System.out.println(ac0 + "\n" + ac1 + "\n" + ac2);
        System.out.println("new account -> deposit 200, deposit 3000, withdraw 380");
        System.out.println(ac0.deposit(200).deposit(3000).withdraw(380));
        System.out.println("new account -> withdraw 2000: " + ac1.withdraw(2000));
        System.out.println("new account -> deposit 500: " + ac2.deposit(500));
        System.out.println("transfer to new account 400 and 10000");
        ac0.transferTo(ac1, 400).transferTo(ac2, 10000);
        System.out.println(ac0 + "\n" + ac1 + "\n" + ac2);        
    }

    private static void testAccountHistory() {
        AccountHistory ah = new AccountHistory(10);
        ah.append(new AccountTransaction(TransactionType.OPEN,new BigDecimal(0)));
        ah.append(new AccountTransaction(TransactionType.DEPOSIT,new BigDecimal(1000)));
        ah.append(new AccountTransaction(TransactionType.WITHDRAW,new BigDecimal(200)));
        ah.append(new AccountTransaction(TransactionType.TRANSFER_OUT,new BigDecimal(500)));
        ah.append(new AccountTransaction(TransactionType.TRANSFER_IN,new BigDecimal(300)));
        System.out.println(ah);
    }
}

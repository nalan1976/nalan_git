package practise;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
        Assert.assertEquals(false, account.deposit(-0.1));
        Assert.assertEquals(false, account.withdraw(-0.1));
        Assert.assertEquals(false, account.withdraw(account.getBalance()+account.getOverdraftLimit()+0.1));

        double bal = account.getBalance();
        Assert.assertEquals(true,account.deposit(5.0));
        Assert.assertEquals(bal + 5.0, account.getBalance(), 0.001);

        bal = account.getBalance();
        Assert.assertEquals(true,account.withdraw(5.0));
        Assert.assertEquals(bal - 5.0, account.getBalance(), 0.001);


    }
}
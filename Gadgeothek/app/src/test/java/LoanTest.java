import junit.framework.Assert;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.domain.Loan;

/**
 * Created by dhug on 10/28/2017.
 */

public class LoanTest {

    @Test
    public void TestLoan()
    {
        // arrange
        Loan loan = new Loan("id", new Gadget("TestGadget"), weekAgo(), yesterday());

        // assert
        Assert.assertEquals(false, loan.isOverdue());

    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    private Date weekAgo()
    {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }
}

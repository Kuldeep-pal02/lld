package expense;

import lombok.Data;
import usermanagement.model.SplitwiseUser;

import java.util.List;

@Data
public class IndiviualExpense extends Expense {

    private List<SplitwiseUser> userList;
    @Override
    protected void calculateShares() {
        this.getExpenseShareList().addAll( this.getSplitStrategy().calculateShare( this.getAmount(), this.getUserList() ) );
    }
}

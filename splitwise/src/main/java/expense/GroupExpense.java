package expense;

import groupmanagment.SplitwiseGroup;
import lombok.Data;

@Data
public class GroupExpense extends Expense{
    private SplitwiseGroup group;

    @Override
    protected void calculateShares(){
        this.getExpenseShareList().addAll( this.getSplitStrategy().calculateShare( this.getAmount(), this.getGroup().getMembers() ) );
    }
}

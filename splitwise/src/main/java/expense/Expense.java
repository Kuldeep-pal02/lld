package expense;

import groupmanagment.SplitwiseGroup;
import lombok.Data;
import usermanagement.model.SplitwiseUser;

import java.util.List;

@Data
public class Expense {

    private String expenseId;
    private String description;
    private double amount;
    private SplitwiseUser paidBy;
    private SplitwiseGroup group;
    private ISplitStrategy splitStrategy;

    private List<ExpenseShare> expenseShareList;

    public void calculateShares(){
        expenseShareList.addAll( this.splitStrategy.calculateShare( amount, group.getMembers() ) );
    }

}

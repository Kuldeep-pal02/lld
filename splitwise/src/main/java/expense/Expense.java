package expense;

import groupmanagment.SplitwiseGroup;
import lombok.Data;
import usermanagement.model.SplitwiseUser;

import java.util.List;

@Data
public abstract class Expense {

    private String expenseId;
    private String description;
    private double amount;
    private SplitwiseUser paidBy;
    private ISplitStrategy splitStrategy;

    private List<ExpenseShare> expenseShareList;


    protected abstract void calculateShares();


}

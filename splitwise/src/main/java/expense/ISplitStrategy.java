package expense;

import usermanagement.model.SplitwiseUser;

import java.util.List;

public interface ISplitStrategy {

    List<ExpenseShare> calculateShare( double amount, List<SplitwiseUser> userList);
}

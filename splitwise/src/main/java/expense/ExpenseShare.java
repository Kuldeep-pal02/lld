package expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import usermanagement.model.SplitwiseUser;

@Data
@AllArgsConstructor
public class ExpenseShare {
    //Map<User, Double > expenseMap;
    SplitwiseUser user;
    double amount;
}

package expense;

import lombok.Data;
import usermanagement.model.SplitwiseUser;

import java.util.ArrayList;
import java.util.List;

@Data
public class EqualSplitStrategy implements ISplitStrategy{
    @Override
    public List<ExpenseShare> calculateShare( double amount, List<SplitwiseUser> userList ) {
        List<ExpenseShare> expenseShares = new ArrayList<>();
        double shareAmount = amount / userList.size();
        for( SplitwiseUser user : userList ){
            expenseShares.add( new ExpenseShare( user , shareAmount) );
        }
        return expenseShares;
    }
}

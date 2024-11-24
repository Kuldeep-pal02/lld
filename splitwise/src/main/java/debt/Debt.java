package debt;

import lombok.Data;
import usermanagement.model.SplitwiseUser;

@Data
public class Debt {
    private int id;
    private SplitwiseUser lender;
    private SplitwiseUser borrower;
    private double amount;

}

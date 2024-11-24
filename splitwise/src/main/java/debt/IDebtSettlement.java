package debt;

import groupmanagment.SplitwiseGroup;

import java.util.List;

public interface IDebtSettlement {
    void settleDebit(List<Debt> debtList);
}

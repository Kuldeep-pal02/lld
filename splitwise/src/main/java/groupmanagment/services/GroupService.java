package groupmanagment.services;

import debt.Debt;
import debt.IDebtSettlement;
import groupmanagment.SplitwiseGroup;
import lombok.Data;

import java.util.List;


@Data
public class GroupService {

    private final IDebtSettlement debtSettlementStrategy;


    public GroupService(IDebtSettlement debtSettlementStrategy) {
        this.debtSettlementStrategy = debtSettlementStrategy;
    }

    //CRUD for Group

    public  void settleDebtForGroup(SplitwiseGroup group ){
        List<Debt>  debtList = fetchDebtListFromGroup( group );
        this.debtSettlementStrategy.settleDebit( debtList );

    }

    private List<Debt> fetchDebtListFromGroup(SplitwiseGroup group) {
        return List.of( new Debt() );
    }


}

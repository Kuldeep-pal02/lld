package service.atmstate;

import service.ATMContext;
import service.ATMRequest;

public interface AtmState {
    void insertCard(ATMContext ctx, ATMRequest req);
    void verifyPin( ATMContext ctx, ATMRequest req );
    void requestWithdraw( ATMContext ctx, ATMRequest req);
    void cashDispense( ATMContext ctx );
    void error( ATMContext ctx, String reason);
}

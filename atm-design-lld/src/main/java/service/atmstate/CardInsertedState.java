package service.atmstate;

import service.ATMContext;
import service.ATMRequest;

public class CardInsertedState implements AtmState {
    @Override
    public void insertCard(ATMContext ctx, ATMRequest req) {
        throw new RuntimeException(" Card Already inserted : insert card Operation not supported at this stage");
    }

    @Override
    public void verifyPin(ATMContext ctx, ATMRequest req) {
        System.out.println( "Pin Verification step is complete");
        ctx.setAtmState( new AuthenticatedState());
    }

    @Override
    public void requestWithdraw(ATMContext ctx, ATMRequest req) {

    }

    @Override
    public void cashDispense(ATMContext ctx) {

    }

    @Override
    public void error(ATMContext ctx, String reason) {

    }
}

package service.atmstate;

import service.ATMContext;
import service.ATMRequest;

public class IdleState implements AtmState {
    @Override
    public void insertCard(ATMContext ctx, ATMRequest req) {
        System.out.println("Card Inserted");
        ctx.setAtmState( new CardInsertedState() );
    }

    @Override
    public void verifyPin(ATMContext ctx, ATMRequest req) {
        throw new RuntimeException(" verifyPin Operation not supported at this stage");
    }

    @Override
    public void requestWithdraw(ATMContext ctx, ATMRequest req) {
        throw new RuntimeException(" requestWithdraw Operation not supported at this stage");
    }

    @Override
    public void cashDispense(ATMContext ctx) {
        throw new RuntimeException(" cashDispense Operation not supported at this stage");
    }

    @Override
    public void error(ATMContext ctx, String reason) {
        System.out.println( " Error at IdleState  " + reason);
    }
}

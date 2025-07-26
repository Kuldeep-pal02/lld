package service.atmstate;

import service.ATMContext;
import service.ATMRequest;

public class AuthenticatedState implements AtmState {
    @Override
    public void insertCard(ATMContext ctx, ATMRequest req) {

    }

    @Override
    public void verifyPin(ATMContext ctx, ATMRequest req) {

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

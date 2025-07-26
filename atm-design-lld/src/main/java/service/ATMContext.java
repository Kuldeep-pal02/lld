package service;

import service.atmstate.AtmState;

public class ATMContext {
    private AtmState atmState;


    public ATMContext(AtmState atmState) {
        this.atmState = atmState;
    }

    public void setAtmState( AtmState state ){
        this.atmState = state;
    }

    public AtmState getAtmState( ){
        return this.atmState;
    }

    public void insertCard( ATMRequest request ){
        this.atmState.insertCard( this , request);
    }
    public void verifyPin( ATMRequest request ){
        this.atmState.verifyPin( this, request );
    }
    public void requestWithdraw(ATMRequest request ){
        this.atmState.requestWithdraw( this, request );
    }

}

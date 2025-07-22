package service;

public class PaymentRequest {
    int tktNumber;
    int amount;
    int txtId;
    PaymentRequest( int tktNumber, int amount, int txtId){
        this.amount =amount;
        this.tktNumber = tktNumber;
        this.txtId = txtId;
    }
}

package services.payments;

import dto.PaymentRequestDto;

public class CreditCardPayment implements IPaymentStrategy {
    @Override
    public boolean makePayment( PaymentRequestDto paymentRequestDto ) {
        System.out.println( "Paymenet doone through CC :: bookingId :: "+paymentRequestDto.getBookingId() +" collected amoint :: "+ paymentRequestDto.getAmount() );
        return false;
    }
}

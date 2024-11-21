package services.payments;

import dto.PaymentRequestDto;

public interface IPaymentStrategy {
    public boolean makePayment( PaymentRequestDto paymentRequestDto);
}

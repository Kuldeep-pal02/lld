package services.payments;

import dto.BookingRequestDto;
import dto.PaymentRequestDto;
import lombok.Data;

@Data
public class BMSPayments {
    private  final IPaymentStrategy paymentStrategy;

    public BMSPayments( IPaymentStrategy paymentStrategy ){
        this.paymentStrategy = paymentStrategy;
    }

    public void collectPayment( BookingRequestDto bookingRequestDto ){
        paymentStrategy.makePayment( new PaymentRequestDto( bookingRequestDto.getBookingId() , bookingRequestDto.getAmount() ) );
    }

}

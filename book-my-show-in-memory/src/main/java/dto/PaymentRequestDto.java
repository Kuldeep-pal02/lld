package dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
    int bookingId;
    int amount;

    public PaymentRequestDto( int bookingId , int amount ){
        this.bookingId = bookingId;
        this.amount = amount;
    }
}

package kg.megacom.storeservice.models.dtos.customDtos.responses;

import kg.megacom.storeservice.models.enums.Status;
import lombok.Data;

@Data
public class TransactionResponseWithDebt {
    private double totalPrice;
    private double paidAmount;
    private double debt;
    private double excessMoney;
    private Status status;
}

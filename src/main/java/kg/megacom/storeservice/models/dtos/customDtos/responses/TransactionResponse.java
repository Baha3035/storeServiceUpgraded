package kg.megacom.storeservice.models.dtos.customDtos.responses;
import kg.megacom.storeservice.models.enums.Status;
import lombok.Data;

import java.util.List;


@Data
public class TransactionResponse {
    private double totalPrice;
    private List<ProductCountOutput> products;
    private Status status;
}

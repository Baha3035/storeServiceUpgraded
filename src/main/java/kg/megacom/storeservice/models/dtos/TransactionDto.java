package kg.megacom.storeservice.models.dtos;

import kg.megacom.storeservice.models.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Long id;
    private double totalPrice;
    private Status status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ClientDto clientDto;
}

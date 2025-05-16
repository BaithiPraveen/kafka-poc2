package pbaithi.poc.branch.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long id;
    private String type;
    private Double amount;
    private LocalDateTime timestamp;
}

package pbaithi.poc.central.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    @JsonIgnore
    private Long id;
    private Long branchId;
    private String type;
    private Double amount;
    private LocalDateTime timestamp;
}

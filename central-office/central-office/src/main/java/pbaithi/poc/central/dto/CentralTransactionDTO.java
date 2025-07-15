package pbaithi.poc.central.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CentralTransactionDTO {
    @JsonIgnore
    private Long id;
    private Long branchId;
    private String type;
    private Double amount;
    private LocalDateTime timestamp;
    private String branchCode;
    private Integer userNumber;
    private String userName;
    private String email;
}

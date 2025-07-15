package pabaithi.poc.base_domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long branchId;
    private String type;
    private Double amount;
    private LocalDateTime timestamp;
    private String branchCode;
    private Integer userNumber;
    private String userName;
    private  String email;
}

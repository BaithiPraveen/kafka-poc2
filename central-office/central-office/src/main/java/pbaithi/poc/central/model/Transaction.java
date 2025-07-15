package pbaithi.poc.central.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long branchId;
    private Integer userNumber;
    private String userName;
    private String branchCode;
    private  String email;
    private String type;
    private Double amount;
    private LocalDateTime timestamp;
}

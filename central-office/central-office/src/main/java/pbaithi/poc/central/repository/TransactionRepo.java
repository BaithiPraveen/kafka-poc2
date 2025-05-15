package pbaithi.poc.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbaithi.poc.central.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}

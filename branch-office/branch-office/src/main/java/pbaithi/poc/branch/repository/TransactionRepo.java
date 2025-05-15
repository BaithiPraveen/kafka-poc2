package pbaithi.poc.branch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pbaithi.poc.branch.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}

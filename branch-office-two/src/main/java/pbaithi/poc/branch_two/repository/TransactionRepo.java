package pbaithi.poc.branch_two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pbaithi.poc.branch_two.model.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}

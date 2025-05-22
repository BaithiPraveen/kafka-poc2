package pbaithi.poc.branch_three.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pbaithi.poc.branch_three.model.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}

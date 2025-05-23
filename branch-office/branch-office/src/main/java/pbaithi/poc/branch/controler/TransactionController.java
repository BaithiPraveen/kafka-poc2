package pbaithi.poc.branch.controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbaithi.poc.branch.model.Transaction;
import pbaithi.poc.branch.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/branch-office/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Transaction txn){
        service.createTransaction(txn);
        return ResponseEntity.ok("TXN sent successfully to KAFKA");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@org.springframework.web.bind.annotation.PathVariable Long id) {
        Transaction txn = service.getTransactionById(id);
        if (txn != null) {
            return ResponseEntity.ok(txn);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll() {
        return ResponseEntity.ok(service.getAllTransactions());
    }
}

package pbaithi.poc.branch_two.controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbaithi.poc.branch_two.model.Transaction;
import pbaithi.poc.branch_two.service.TransactionService;


import java.util.List;

@RestController
@RequestMapping("/branch-office2/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction txn) throws JsonProcessingException {
        return ResponseEntity.ok(service.createTransaction(txn));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable Long id) {
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

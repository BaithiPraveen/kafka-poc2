package pbaithi.poc.branch.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbaithi.poc.branch.model.Transaction;
import pbaithi.poc.branch.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction txn) {
        return ResponseEntity.ok(service.createTransaction(txn));
    }
}

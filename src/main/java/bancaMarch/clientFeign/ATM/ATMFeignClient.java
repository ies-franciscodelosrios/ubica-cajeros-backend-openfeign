package bancaMarch.clientFeign.ATM;

import bancaMarch.dto.transactions.TransactionDTO;
import bancaMarch.dto.transactions.TransactionRequestDTO;
import bancaMarch.dto.transactions.TransactionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ATM", url = "http://localhost:8080/api")
public interface ATMFeignClient {

    @PostMapping("/transactions")
    ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transaction);

    @PostMapping("/transactions/status")
    ResponseEntity<TransactionResponseDTO> getTransactionStatus(@RequestBody TransactionRequestDTO requestDTO);
}

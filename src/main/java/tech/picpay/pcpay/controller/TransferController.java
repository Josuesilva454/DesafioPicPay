package tech.picpay.pcpay.controller;


import feign.Body;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.picpay.pcpay.dto.TransferDto;
import tech.picpay.pcpay.entity.Transfer;
import tech.picpay.pcpay.servico.TransferService;

@RestController
@RequestMapping("api")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer>transfer(@RequestBody @Valid TransferDto transferDto){
        var res = transferService.transfer(transferDto);
        return  ResponseEntity.ok(res);
    }
}

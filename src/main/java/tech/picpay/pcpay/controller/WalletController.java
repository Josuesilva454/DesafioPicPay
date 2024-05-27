package tech.picpay.pcpay.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.picpay.pcpay.dto.CreateWalletDto;
import tech.picpay.pcpay.entity.Wallet;
import tech.picpay.pcpay.servico.WalletService;

@RestController
@RequestMapping("api")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallet")
    public ResponseEntity<Wallet> createWallete(@RequestBody CreateWalletDto dto){
      var wallet = walletService.createWallete(dto);
      return   ResponseEntity.ok(wallet);
    }
}

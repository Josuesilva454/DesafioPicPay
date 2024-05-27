package tech.picpay.pcpay.servico;

import org.springframework.stereotype.Service;
import tech.picpay.pcpay.dto.CreateWalletDto;
import tech.picpay.pcpay.entity.Wallet;
import tech.picpay.pcpay.exception.PicPayException;
import tech.picpay.pcpay.repository.WalletRepositoy;


@Service
public class WalletService {

    private final WalletRepositoy walletRepositoy;


    public WalletService(WalletRepositoy walletRepositoy) {
        this.walletRepositoy = walletRepositoy;
    }
    public Wallet createWallete(CreateWalletDto dto){
        var walletDb = walletRepositoy.FindByCpfCnpjEmail(dto.cpfCnpfj(), dto.email()).toString();

       if (walletDb.isEmpty(){
            throw new

        return walletRepositoy.save(dto.toWallet());
    }
}
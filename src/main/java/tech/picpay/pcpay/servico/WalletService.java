package tech.picpay.pcpay.servico;

import org.springframework.stereotype.Service;
import tech.picpay.pcpay.dto.CreateWalletDto;
import tech.picpay.pcpay.entity.Wallet;
import tech.picpay.pcpay.exception.WalletDataAlreadyExistsException;
import tech.picpay.pcpay.repository.WalletRepository;


@Service
public class WalletService {

    private final WalletRepository walletRepositoy;


    public WalletService(WalletRepository walletRepositoy) {
        this.walletRepositoy = walletRepositoy;
    }
    public Wallet createWallete(CreateWalletDto dto) {
        // Verifique se a carteira já existe
        var walletDb = walletRepositoy.findByCpfCnpjAndEmail(dto.cpfCnpj(), dto.email());

        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCpnj e e-mail já existem");
        }

        // Converte o DTO para uma entidade Wallet e salva no repositório
        Wallet wallet = dto.toWallet();
        return walletRepositoy.save(wallet);
    }
}
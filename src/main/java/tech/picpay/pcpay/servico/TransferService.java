package tech.picpay.pcpay.servico;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.picpay.pcpay.dto.TransferDto;
import tech.picpay.pcpay.entity.Transfer;
import tech.picpay.pcpay.entity.Wallet;
import tech.picpay.pcpay.exception.InsufficientBalanceException;
import tech.picpay.pcpay.exception.TransferNotAllowedForWalletTypeException;
import tech.picpay.pcpay.exception.TransferNotAuthorizedException;
import tech.picpay.pcpay.exception.WalletNotFoundException;
import tech.picpay.pcpay.repository.TransferRepository;
import tech.picpay.pcpay.repository.WalletRepository;

@Service
public class TransferService {

    private final AuthorizationServico authorizationServico;
    private final NotificationService notificationService;
    private final WalletRepository walletRepositoy;
    private final TransferRepository transferRepository;

    public TransferService( AuthorizationServico authorizationServico, NotificationService notificationService, WalletRepository walletRepositoy, TransferRepository transferRepository) {
        this.authorizationServico = authorizationServico;
        this.notificationService = notificationService;
        this.walletRepositoy = walletRepositoy;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public Transfer transfer(TransferDto transferDto) {
        var sender = walletRepositoy.findById(transferDto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepositoy.findById(transferDto.Payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.Payee()));

        validateTransfer(transferDto, sender);
        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());
        var transfer = new Transfer(sender, receiver, transferDto.value());

        walletRepositoy.save(sender);
        walletRepositoy.save(receiver);

        var TrasferResul = transferRepository.save(transfer);

        return TrasferResul;
    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalancerEqualOrGreatherThan(transferDto.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationServico.isAuthorized(transferDto)) {
            throw new TransferNotAuthorizedException();
        }

    }

}


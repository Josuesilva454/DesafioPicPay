package tech.picpay.pcpay.dto;

import tech.picpay.pcpay.entity.Wallet;
import tech.picpay.pcpay.entity.WalletType;

import java.math.BigDecimal;

public record CreateWalletDto (String fullName, String cpfCnpfj,
                               String email, String password, WalletType.Enum wallettype){

    public Wallet toWallet(){
        return new Wallet( fullName,
        cpfCnpfj,
        email,
        password,
        wallettype.get()
                );
    }
}

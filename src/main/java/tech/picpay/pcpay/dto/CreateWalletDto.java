package tech.picpay.pcpay.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.picpay.pcpay.entity.Wallet;
import tech.picpay.pcpay.entity.WalletType;

import java.math.BigDecimal;

public record CreateWalletDto (@NotBlank String fullName,@NotBlank String cpfCnpfj,
                               @NotBlank String email, @NotBlank String password, @NotNull WalletType.Enum wallettype){

    public Wallet toWallet(){
        return new Wallet( fullName,
        cpfCnpfj,
        email,
        password,
        wallettype.get()
                );
    }
}

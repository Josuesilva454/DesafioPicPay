package tech.picpay.pcpay.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.picpay.pcpay.entity.Wallet;
import tech.picpay.pcpay.entity.WalletType;

import java.math.BigDecimal;

public record CreateWalletDto (@NotBlank String fullName,@NotBlank String cpfCnpj,
                               @NotBlank String email, @NotBlank String password,  @NotNull WalletType.Enum walletType){

    public Wallet toWallet(){
        return new Wallet( fullName,
        cpfCnpj,
        email,
        password,
                walletType.get()
                );
    }
}

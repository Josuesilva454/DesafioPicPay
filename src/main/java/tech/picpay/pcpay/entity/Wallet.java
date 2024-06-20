package tech.picpay.pcpay.entity;


import jakarta.persistence.*;
import tech.picpay.pcpay.exception.InsufficientBalanceException;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fullName")
    private String fullName;
    @Column( name = "cpfCnpj", unique = true)
    private String cpfCnpj;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;

    public Wallet(){

    }
    // Constructor, getters, and setters omitted for brevity

    public void debit(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }
        balance = balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }



    public boolean isBalanceEqualOrGreaterThan(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }



    public Wallet(String fullName, String cpfCnpj, String email, String password, WalletType walletType) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.walletType = walletType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpfCnpfj() {
        return cpfCnpj;
    }

    public void setCpfCnpfj(String cpfCnpfj) {
        this.cpfCnpj = cpfCnpfj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }

    public boolean isTransferAllowedForWalletType() {
        return this.walletType.equals(WalletType.Enum.USER.get());
    }

    public boolean isBalancerEqualOrGreatherThan(BigDecimal value) {
        return  balance.doubleValue() >= value.doubleValue();
    }
}

package tech.picpay.pcpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.picpay.pcpay.entity.Wallet;

@Repository
public interface WalletRepositoy extends JpaRepository< Wallet, Long> {
    Object FindByCpfCnpjEmail(String cpfCnpfj, String email);
}

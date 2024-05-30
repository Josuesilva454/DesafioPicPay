package tech.picpay.pcpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.picpay.pcpay.entity.Wallet;

import java.util.Optional;

@Repository
public interface WalletRepositoy extends JpaRepository< Wallet, Long> {
    Optional<Wallet> findByCpfCnpjAndEmail(String cpfCnpj, String email);
}

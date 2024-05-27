package tech.picpay.pcpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.picpay.pcpay.entity.WalletType;

@Repository
public interface walletTypeRepository extends JpaRepository <WalletType, Long> {
}

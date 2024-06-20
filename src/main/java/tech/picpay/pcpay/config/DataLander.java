package tech.picpay.pcpay.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.picpay.pcpay.entity.WalletType;
import tech.picpay.pcpay.repository.walletTypeRepository;

import java.util.Arrays;

@Component
public class DataLander implements CommandLineRunner {

    private final walletTypeRepository walletTypeRepository;

    public DataLander(tech.picpay.pcpay.repository.walletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(WalletType.Enum.values()).forEach(WalletType -> walletTypeRepository.save(WalletType.get()));

    }
}

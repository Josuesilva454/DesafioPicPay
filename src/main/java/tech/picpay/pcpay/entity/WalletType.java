package tech.picpay.pcpay.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "wallet_type")
public class WalletType {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    public WalletType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public enum Enum{


        USER(1L , "user"),
        MERCHANT(1l, "MERCHANT");

        Enum (Long id, String description){
            this.id = id;
            this.description = description;

        }

        private Long id;
        private String description;

    public WalletType get() {
        return new WalletType(id, description);
    }
    }
}

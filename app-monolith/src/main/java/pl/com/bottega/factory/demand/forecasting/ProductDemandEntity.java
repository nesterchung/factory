package pl.com.bottega.factory.demand.forecasting;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.com.bottega.factory.product.management.RefNoId;
import pl.com.bottega.tools.TechnicalId;

import javax.persistence.*;

@Entity(name = "ProductDemand")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductDemandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Long version;
    @Column
    private String refNo;

    public ProductDemandEntity(String refNo) {
        this.refNo = refNo;
    }

    ProductDemandEntityId createId() {
        return new ProductDemandEntityId(refNo, id, version);
    }

    @Getter
    static class ProductDemandEntityId extends RefNoId implements TechnicalId {

        Long id;
        Long version;

        ProductDemandEntityId(String refNo) {
            super(refNo);
        }

        ProductDemandEntityId(String refNo, long id, Long version) {
            super(refNo);
            this.id = id;
            this.version = version;
        }
    }
}
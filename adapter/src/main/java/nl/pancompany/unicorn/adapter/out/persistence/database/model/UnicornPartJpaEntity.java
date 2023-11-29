package nl.pancompany.unicorn.adapter.out.persistence.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unicorn_part")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnicornPartJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="unicorn_id", nullable=false)
    private UnicornJpaEntity unicorn;

    @Column
    private String color;
}

package nl.pancompany.unicorn.adapter.out.persistence.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "unicorn")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnicornJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @OneToMany(mappedBy="unicorn", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UnicornPartJpaEntity> parts;
}

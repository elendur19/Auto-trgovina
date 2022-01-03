package hr.fer.ris.autotrgovina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "date_created", updatable = false)
    protected LocalDate dateCreated;
    @Column(name = "date_updated")
    protected LocalDate dateUpdated;
    @Column(name = "date_deleted", updatable = false)
    protected LocalDate dateDeleted;
    @Column(name = "deleted", updatable = false)
    protected Boolean deleted;

    @PrePersist
    private void setDateCreated() {
        dateCreated = LocalDate.now();
    }

    @PreUpdate
    private void setDateUpdated() {
        dateUpdated = LocalDate.now();
    }

    @PreRemove
    private void setDateDeleted() {
        deleted = true;
        dateDeleted = LocalDate.now();
    }
}
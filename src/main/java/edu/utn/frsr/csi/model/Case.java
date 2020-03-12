package edu.utn.frsr.csi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "casos")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case caso = (Case) o;
        return id.equals(caso.id) &&
                name.equals(caso.name) &&
                createDate.equals(caso.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate);
    }

    @PrePersist
    public void updateCreateDate(){
        createDate = LocalDate.now();
    }


}

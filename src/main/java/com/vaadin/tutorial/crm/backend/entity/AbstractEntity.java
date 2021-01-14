package com.vaadin.tutorial.crm.backend.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public boolean isPersisted(){
        return id!=null;
    }
    @Override
    public int hashCode(){
        if (getId() != null){
            return getId().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        if (getId() == null || that.getId() == null){
            return false;
        }
        return getId().equals(that.getId());
    }
}

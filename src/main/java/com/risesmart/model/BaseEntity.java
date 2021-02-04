package com.risesmart.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * The type Base entity.
 *
 * @author Sanjay Sahu
 */
@Data
@MappedSuperclass
public class BaseEntity {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * The Activeflag.
     */
    protected Boolean activeflag = true;

    /**
     * The Version.
     */
    @Version
    protected Integer version;

    /**
     * The Created.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;

    /**
     * The Last updated.
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastupdated")
    protected Date lastUpdated;

}

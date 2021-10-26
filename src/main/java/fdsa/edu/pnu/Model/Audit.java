/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

/**
 *
 * @author Ing.Girbson BIJOU
 */


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit<U> implements Serializable {

  @CreatedDate
  @Column(name = "creationDate", nullable = true, updatable = false)
  private Instant creationDate;

  @LastModifiedDate
  @Column(name = "lastModifiedDate")
  private Instant lastModifiedDate;

  @CreatedBy
  @Column(name = "CreatedBy")
  protected U createdBy;


  @LastModifiedBy
  @Column(name = "LastModifiedBy")
  protected U lastModifiedBy;

}

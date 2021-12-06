
package com.example.SkTest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Denis Ufilin
 */

@Entity
@Table(name = "sk_example_table")
@Data
public class Thing {
  @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
  
  @Column(name = "obj")
 
    private String obj;
 

  
  
}

package dev.rafaelreis.crudspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.Table;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
// @Table(name = "tabela_nome_diferente")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("_id")
  private Long id;

  // @Column(name = "coluna_nome_diferente")
  @Column(length = 200, nullable = false)
  private String name;

  @Column(length = 20, nullable = false)
  private String category;

}

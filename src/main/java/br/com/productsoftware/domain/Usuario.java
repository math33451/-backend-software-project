package br.com.productsoftware.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	Long id;
	String nome;
	String email;
	String senha;
}

package br.com.productsoftware.infra.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="BALANCA")
@NoArgsConstructor
@AllArgsConstructor
public class Balanca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroSerie;
	private Long documentoProprietario;
	
	@OneToMany(mappedBy="balanca")
	private List<Ticket> tickets;
}

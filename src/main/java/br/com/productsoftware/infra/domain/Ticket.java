package br.com.productsoftware.infra.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="TICKET")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeSolicitante;
	private Long documentoSolicitante;
	private String emailSolicitante;
	private String telefoneSolicitante;
	private String numeroSerieBalanca;
	private Integer qtdBalanca;
	private Date dtEmissaoTicket;
	private boolean visualizado;
	private boolean atendido;
	private String descricao;
	
	@ManyToOne
    @JoinColumn(name="balanca_id", nullable=false)
    private Balanca balanca;
}

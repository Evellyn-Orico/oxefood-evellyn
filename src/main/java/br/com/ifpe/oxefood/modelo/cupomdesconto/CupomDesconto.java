package br.com.ifpe.oxefood.modelo.cupomdesconto;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CupomDesconto")
@SQLRestriction("habilitado = true") 
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CupomDesconto extends EntidadeAuditavel  {


   @Column
   private String codigoDesconto;

   @Column
   private Double percentualDesconto;

   @Column
   private Double valorDesconto;

   @Column
   private Double valorMinimoPedidoPermitido;
   
   @Column
   private int quantidadeMaximaUso;
   
   @Column
   private LocalDate inicioVigencia;

   @Column
   private LocalDate fimVigencia;


}
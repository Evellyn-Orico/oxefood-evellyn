package br.com.ifpe.oxefood.api.cupomdesconto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CupomDescontoRequest {


   private String codigoDesconto;

   private Double percentualDesconto;

   private Double valorDesconto;

   private Double valorMinimoPedidoPermitido;
   
   private int quantidadeMaximaUso;
   
   @JsonFormat(pattern = "dd/MM/yyyy") //Ele vai esperar a anotação em Dia/Mês/Ano
   private LocalDate inicioVigencia;

   @JsonFormat(pattern = "dd/MM/yyyy") //Ele vai esperar a anotação em Dia/Mês/Ano
   private LocalDate fimVigencia;


   public CupomDesconto build() {

       return CupomDesconto.builder() 
           .codigoDesconto(codigoDesconto)
           .percentualDesconto(percentualDesconto)
           .codigoDesconto(codigoDesconto)
           .valorDesconto(valorDesconto)
           .quantidadeMaximaUso(quantidadeMaximaUso)
           .inicioVigencia(inicioVigencia)
           .fimVigencia(fimVigencia)
           .build();
   }

}

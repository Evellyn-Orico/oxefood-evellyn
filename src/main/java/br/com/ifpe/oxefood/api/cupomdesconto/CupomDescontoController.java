package br.com.ifpe.oxefood.api.cupomdesconto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDesconto;
import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDescontoService;

@RestController //Faz a classe ser um controller
@RequestMapping("/api/cupomdesconto")
@CrossOrigin //Utilizada para o controller receber requisições do React

public class CupomDescontoController {
      @Autowired //Instanciar no cupomDesconto service
   private CupomDescontoService cupomDescontoService;

   @PostMapping //Especificar que essa função vai receber requisições do tipo Post
   public ResponseEntity<CupomDesconto> save(@RequestBody CupomDescontoRequest request) {

       CupomDesconto cupomDesconto = cupomDescontoService.save(request.build());
       return new ResponseEntity<CupomDesconto>(cupomDesconto, HttpStatus.CREATED);
   }

   @GetMapping
    public List<CupomDesconto> listarTodos() {
        return cupomDescontoService.listarTodos();
    }

    @GetMapping("/{id}")
    public CupomDesconto obterPorID(@PathVariable Long id) {
        return cupomDescontoService.obterPorID(id);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<CupomDesconto> update(@PathVariable("id") Long id, @RequestBody CupomDescontoRequest request) { //Recebe o id e os dados do cupomDesconto

       cupomDescontoService.update(id, request.build()); //Objeto preenchido sera enviado para o service
       return ResponseEntity.ok().build();
 }

   @DeleteMapping("/{id}") // passar o id do cupomDesconto que eu quero remover
   public ResponseEntity<Void> delete(@PathVariable Long id) { //repassar o id para a função delete

       cupomDescontoService.delete(id);
       return ResponseEntity.ok().build();
   }

}
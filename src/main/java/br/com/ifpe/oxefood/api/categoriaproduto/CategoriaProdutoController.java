package br.com.ifpe.oxefood.api.categoriaproduto;

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

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;



@RestController //Faz a classe ser um controller
@RequestMapping("/api/categoriaproduto")
@CrossOrigin //Utilizada para o controller receber requisições do React

public class CategoriaProdutoController {
    
          @Autowired //Instanciar no cliente service
   private CategoriaProdutoService categoriaprodutoService;

   @PostMapping //Especificar que essa função vai receber requisições do tipo Post
   public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request) {

       CategoriaProduto categoriaproduto = categoriaprodutoService.save(request.build());
       return new ResponseEntity<CategoriaProduto>(categoriaproduto, HttpStatus.CREATED);
   }

   @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return categoriaprodutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaprodutoService.obterPorID(id);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) { //Recebe o id e os dados do cliente

       categoriaprodutoService.update(id, request.build()); //Objeto preenchido sera enviado para o service
       return ResponseEntity.ok().build();
 }

   @DeleteMapping("/{id}") // passar o id do cliente que eu quero remover
   public ResponseEntity<Void> delete(@PathVariable Long id) { //repassar o id para a função delete

       categoriaprodutoService.delete(id);
       return ResponseEntity.ok().build();
   }

}

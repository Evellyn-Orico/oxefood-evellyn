package br.com.ifpe.oxefood.modelo.cupomdesconto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service 
public class CupomDescontoService {

    @Autowired 
    private CupomDescontoRepository repository;

    @Transactional 
    public CupomDesconto save(CupomDesconto cupomDesconto) { //Recebe o objeto cupomDesconto que ele vai salvar no banco

        cupomDesconto.setHabilitado(Boolean.TRUE);
        return repository.save(cupomDesconto);

    
    }

    public List<CupomDesconto> listarTodos() {

        return repository.findAll();
    }

    public CupomDesconto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CupomDesconto cupomDescontoAlterado) {

        CupomDesconto cupomDesconto = repository.findById(id).get(); //Consultar no banco o cupomDesconto
        cupomDesconto.setCodigoDesconto(cupomDescontoAlterado.getCodigoDesconto());
        cupomDesconto.setPercentualDesconto(cupomDescontoAlterado.getPercentualDesconto());
        cupomDesconto.setValorDesconto(cupomDescontoAlterado.getValorDesconto());
        cupomDesconto.setValorMinimoPedidoPermitido(cupomDescontoAlterado.getValorMinimoPedidoPermitido());
        cupomDesconto.setQuantidadeMaximaUso(cupomDescontoAlterado.getQuantidadeMaximaUso());
        cupomDesconto.setInicioVigencia(cupomDescontoAlterado.getInicioVigencia());
        cupomDesconto.setFimVigencia(cupomDescontoAlterado.getFimVigencia());

        repository.save(cupomDesconto); //Função para cadastra e alterar objeto
    }

    @Transactional //Toda vez que for mexer no banco utilizar o transactional
    public void delete(Long id) {

        CupomDesconto cupomDesconto = repository.findById(id).get();
        cupomDesconto.setHabilitado(Boolean.FALSE);

        repository.save(cupomDesconto); //Na verdade está sendo alterado se realmente fosse deletado em vez de save seria o delete
    }

}

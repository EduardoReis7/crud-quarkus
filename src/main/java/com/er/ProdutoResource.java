package com.er;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarTodosProdutos() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void criarProduto(ProdutoDto dto) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setValor(dto.getValor());
        p.persist();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void atualizarProduto(@PathParam("id") Long id, ProdutoDto dto) {
        Optional<Produto> optProduto = Produto.findByIdOptional(id);
        optProduto.ifPresentOrElse(produto -> {
            produto.setNome(dto.getNome());
            produto.setValor(dto.getValor());
            produto.persist();
        }, () -> {
            throw new NotFoundException("");
        });
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletarProduto(@PathParam("id") Long id) {
        boolean deletado = Produto.deleteById(id);
        if (!deletado)
            throw new NotFoundException();
    }
}

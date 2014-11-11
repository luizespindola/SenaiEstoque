/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.senai.senaiEstoque.controller.UsuarioController;
import br.com.senai.senaiEstoque.dao.CaracteristicaDao;
import br.com.senai.senaiEstoque.dao.EntradaDao;
import br.com.senai.senaiEstoque.dao.FornecedorDao;
import br.com.senai.senaiEstoque.dao.FotoDao;
import br.com.senai.senaiEstoque.dao.MarcaDao;
import br.com.senai.senaiEstoque.dao.PermissaoDao;
import br.com.senai.senaiEstoque.dao.ProdutoDao;
import br.com.senai.senaiEstoque.dao.SaidaDao;
import br.com.senai.senaiEstoque.dao.TipoUsuarioDao;
import br.com.senai.senaiEstoque.dao.ValorCaracteristicaDao;
import br.com.senai.senaiEstoque.entity.Caracteristica;
import br.com.senai.senaiEstoque.entity.Entrada;
import br.com.senai.senaiEstoque.entity.Fornecedor;
import br.com.senai.senaiEstoque.entity.Foto;
import br.com.senai.senaiEstoque.entity.Marca;
import br.com.senai.senaiEstoque.entity.Permissao;
import br.com.senai.senaiEstoque.entity.Produto;
import br.com.senai.senaiEstoque.entity.Saida;
import br.com.senai.senaiEstoque.entity.TipoUsuario;
import br.com.senai.senaiEstoque.entity.Usuario;
import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author luiz_espindola
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       

        Permissao permissao = new Permissao();
        permissao.setEditar("Sim");
        permissao.setEditarPermissao("Sim");
        permissao.setVisualizar("Sim");
        PermissaoDao permissaoDao = new PermissaoDao();
        permissaoDao.insert(permissao);

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNome("FODAO");
        tipoUsuario.setPermissao(permissao);
        TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
        tipoUsuarioDao.insert(tipoUsuario);

        Usuario usuario = new Usuario();
        usuario.setNome("Luiz");
        usuario.setLogin("luiz");
        usuario.setSenha("luiz");
        usuario.setTipoUsuario(tipoUsuario);
        UsuarioController controller = new UsuarioController();
//        controller.insert(usuario);

        System.out.println(controller.getAll());

        ValorCaracteristica valorCaracteristica = new ValorCaracteristica();
        valorCaracteristica.setNome("Preto");
        List<ValorCaracteristica> lista=new ArrayList<ValorCaracteristica>();
        lista.add(valorCaracteristica);

        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setNome("Cor");
        caracteristica.setListaValorCaracteristica(lista);
        CaracteristicaDao caracteristicaDao = new CaracteristicaDao();
        caracteristicaDao.salvar(caracteristica);

        Foto foto = new Foto();
        foto.setEndereco("foto1");
        FotoDao fotoDao = new FotoDao();
        fotoDao.insert(foto);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("fornecedor1");
        fornecedor.setEmail("fornecedor1");
        fornecedor.setSite("fornecedor1");
        fornecedor.setObservacao("fornecedor1");
        FornecedorDao fornecedorDao = new FornecedorDao();
        fornecedorDao.salvar(fornecedor);

        Marca marca = new Marca();
        marca.setNome("Marca1");
        MarcaDao marcaDao = new MarcaDao();
        marcaDao.salvar(marca);
        
        Produto produto = new Produto();
        produto.setCodigo(12345);
        produto.setNome("ventilador");
        produto.setPrecoCusto(1.1);
        produto.setQuantidade(1000);
        produto.setFoto(foto);
        produto.setFornecedor(fornecedor);
        produto.setMarca(marca);
        List<Caracteristica> listaCaracteristicas=new ArrayList<Caracteristica>();
        produto.setListaCaracteristicas(listaCaracteristicas);
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.salvar(produto);
               
        Entrada entrada = new Entrada();
        entrada.setQuantidade(100);
        entrada.setDataEntrada(new Date());
        entrada.setProduto(produto);
        EntradaDao entradaDao = new EntradaDao();
        entradaDao.salvar(entrada);
        
        
        Saida saida = new Saida();
        saida.setDataSaida(new Date());
        saida.setQuantidade(100);
        saida.setProduto(produto);
        SaidaDao saidaDao = new SaidaDao();
        saidaDao.insert(saida);
    }

}

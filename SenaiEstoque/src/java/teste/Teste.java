/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.senai.senaiEstoque.dao.CorDao;
import br.com.senai.senaiEstoque.dao.FornecedorDao;
import br.com.senai.senaiEstoque.dao.FotoDao;
import br.com.senai.senaiEstoque.dao.MarcaDao;
import br.com.senai.senaiEstoque.dao.UsuarioDao;
import br.com.senai.senaiEstoque.entity.Cor;
import br.com.senai.senaiEstoque.entity.Fornecedor;
import br.com.senai.senaiEstoque.entity.Foto;
import br.com.senai.senaiEstoque.entity.Marca;
import br.com.senai.senaiEstoque.entity.Produto;
import br.com.senai.senaiEstoque.entity.Usuario;
import br.com.senai.senaiEstoque.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        
        Usuario usuario = new Usuario();
        usuario.setNome("Luiz");
        usuario.setLogin("luiz");
        usuario.setSenha("luiz");

        
      

        UsuarioDao dao = new UsuarioDao();
        dao.insert(usuario);

//        Foto foto = new Foto();
//        foto.setEndereco("dada");
//       
//        
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session session = sf.openSession();
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.getTransaction().begin();
//        session.saveOrUpdate(foto);
//        session.getTransaction().commit();
//        session.close();
//
//        Cor cor = new Cor();
//        cor.setNome("preto");
//        CorDao dao1 = new CorDao();
//        dao1.insert(cor);
//
//        Fornecedor fornecedor = new Fornecedor();
//        fornecedor.setEmail("@gmail.com");
//        fornecedor.setNome("dwsdqa");
//        fornecedor.setObservacao("dcsds");
//        fornecedor.setSite("www.www.www");
//        FornecedorDao fornecedorDao = new FornecedorDao();
//        fornecedorDao.insert(fornecedor);
//
//        Marca marca = new Marca();
//        marca.setNome("caca");
//        MarcaDao marcaDao = new MarcaDao();
//        marcaDao.insert(marca);
//
//        Produto produto = new Produto();
//        produto.setCodigo(123456789);
//        produto.setNome("ventilador");
//        produto.setPrecoCusto(12.12);
//        produto.setQuantidade(1000);
//        produto.setCor(cor);
//        produto.setFornecedor(fornecedor);
//        produto.setMarca(marca);
//        produto.setFoto(foto);
    }
}

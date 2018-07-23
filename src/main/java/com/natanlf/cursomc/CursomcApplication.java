package com.natanlf.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.natanlf.cursomc.domain.Categoria;
import com.natanlf.cursomc.domain.Cidade;
import com.natanlf.cursomc.domain.Cliente;
import com.natanlf.cursomc.domain.Endereco;
import com.natanlf.cursomc.domain.Estado;
import com.natanlf.cursomc.domain.Produto;
import com.natanlf.cursomc.domain.enums.TipoCliente;
import com.natanlf.cursomc.repositories.CategoriaRepository;
import com.natanlf.cursomc.repositories.CidadeRepository;
import com.natanlf.cursomc.repositories.ClienteRepository;
import com.natanlf.cursomc.repositories.EnderecoRepository;
import com.natanlf.cursomc.repositories.EstadoRepository;
import com.natanlf.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository; //camada de acesso a dados
	
	@Autowired
	private ProdutoRepository produtoRepository; //camada de acesso a dados
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //roda automaticamente
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		//Associando
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3)); //Digo que a categoria 1 tem os produtos informados
		cat2.getProdutos().addAll(Arrays.asList(p2)); //Digo que a categoria 2 tem os produtos informados
		
		p1.getCategorias().addAll(Arrays.asList(cat1)); //p1 pertence a categoria cat1
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2)); //p2 pertence a categoria 1 e 2
		p3.getCategorias().addAll(Arrays.asList(cat1)); //p3 pertence a categoria cat1
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); //coloca meus objetos em lista para salvar
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "23545885254", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("25789812","37146785"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "30", "Apt 540", "Jardim", "25784441", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "20989557", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}
	

}

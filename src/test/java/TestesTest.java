import dao.ClienteDAO;
import dao.LivroDAO;
import dao.ConnectionFactory;
import dao.RecebeDAO;
import model.Cliente;
import model.Livro;
import model.Recebe;
import org.junit.jupiter.api.*;


import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestesTest {


    //private static ClienteDAO clienteDAOGeral = new ClienteDAO();
    //private static LivroDAO livroDAOGeral = new LivroDAO();

    @BeforeAll
    public static void setUpClass() {
        // Excluir todos os clientes antes de realizar o teste
        ClienteDAO limpeza = new ClienteDAO();

        if(limpeza.listarTodos().size() > 0){
            ArrayList<Cliente> clientesExistentes = limpeza.listarTodos();
            for(int i=0;i<clientesExistentes.size();i++){
                limpeza.excluir(clientesExistentes.get(i).getCpf());
            }
        }

        // Excluir todos os livros antes de realizar o teste

        LivroDAO limpezaLivro = new LivroDAO();

        if(limpezaLivro.listarTodos().size() > 0){
            ArrayList<Livro> livrosExistentes = limpezaLivro.listarTodos();
            int id_inicial = livrosExistentes.get(0).getId();
            for(int j = id_inicial;j<id_inicial+livrosExistentes.size();j++){
                limpezaLivro.excluir(j);
            }
        }
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    @Order(1)
    public void conexaoTest() {
        Connection conexao;
        conexao = new ConnectionFactory().getConnection();

        assertNotNull(conexao);
    }

    @Test
    @Order(2)
    public void addClienteTest(){

        ClienteDAO clienteTesteDAO = new ClienteDAO();
        Cliente clienteTeste = new Cliente();
        Cliente clienteRetornado = new Cliente();

        //Dados do Cliente - Dados Esperados
        String[] dadosUsuario = {"Adeline LaRue","adelinelarue@gmail.com","(31)99928-1691","123.456.789-11","30320-080","Villon-Sur-Sathre","FR","Choupana","120"};

        //Configura????o do Cliente
        clienteTeste.setNome(dadosUsuario[0]);
        clienteTeste.setEmail(dadosUsuario[1]);
        clienteTeste.setTelefone(dadosUsuario[2]);
        clienteTeste.setCpf(dadosUsuario[3]);
        clienteTeste.setCep(dadosUsuario[4]);
        clienteTeste.setCidade(dadosUsuario[5]);
        clienteTeste.setUf(dadosUsuario[6]);
        clienteTeste.setRua(dadosUsuario[7]);
        clienteTeste.setNumero(Integer.parseInt(dadosUsuario[8]));

        //Inserir Cliente
        clienteTesteDAO.inserir(clienteTeste);
        //Pegar o cliente inserido
        clienteTesteDAO.listarTodos();
        ArrayList<Cliente> clienteInserido = clienteTesteDAO.listarTodos();
        clienteRetornado = clienteInserido.get(0);

        String[] dadosRetornados = new String[9];
        dadosRetornados[0] = clienteRetornado.getNome();
        dadosRetornados[1] = clienteRetornado.getEmail();
        dadosRetornados[2] = clienteRetornado.getTelefone();
        dadosRetornados[3] = clienteRetornado.getCpf();
        dadosRetornados[4] = clienteRetornado.getCep();
        dadosRetornados[5] = clienteRetornado.getCidade();
        dadosRetornados[6] = clienteRetornado.getUf();
        dadosRetornados[7] = clienteRetornado.getRua();
        dadosRetornados[8] = Integer.toString(clienteRetornado.getNumero());

        //Verificar se a Inser????o foi feita corretamente
        assertArrayEquals(dadosUsuario,dadosRetornados);
    }


    @Test
    @Order(3)
    public void addLivroTest(){

        LivroDAO livroDAOTeste = new LivroDAO();
        Livro livroTeste = new Livro();
        Livro livroRetornado = new Livro();

        String[] dadosLivro = {"A Vida Invis??vel de Addie LaRue", "2021", "Galera", "V.E Schwab", "504", "Romance"};

        livroTeste.setNome(dadosLivro[0]);
        livroTeste.setAno(Integer.parseInt(dadosLivro[1]));
        livroTeste.setEditora(dadosLivro[2]);
        livroTeste.setAutor(dadosLivro[3]);
        livroTeste.setNum_paginas(Integer.parseInt(dadosLivro[4]));
        livroTeste.setGenero(dadosLivro[5]);

        livroDAOTeste.inserir(livroTeste);

        ArrayList<Livro> livrosRecebidos = livroDAOTeste.listarTodos();
        livroRetornado = livrosRecebidos.get(0);

        String[] dadosRetornados = new String[6];

        dadosRetornados[0] = livroRetornado.getNome();
        dadosRetornados[1] = Integer.toString(livroRetornado.getAno());
        dadosRetornados[2] = livroRetornado.getEditora();
        dadosRetornados[3] = livroRetornado.getAutor();
        dadosRetornados[4] = Integer.toString(livroRetornado.getNum_paginas());
        dadosRetornados[5] = livroRetornado.getGenero();


        assertArrayEquals(dadosLivro,dadosRetornados);
        //JOptionPane.showMessageDialog(null, livroDAOTeste.listarTodos());

    }

        @Test
    @Order(4)
    public void listarDadosTest() {
        ArrayList<Livro> listaLivros = livroDAOTeste.listarTodos();
        ArrayList<Cliente> listaClientes = clienteTesteDAO.listarTodos();

        assertNotNull(listaLivros);
        assertNotNull(listaClientes);
    }

    @Test
    @Order(5)
    public void alteraDadosTest(){

        ClienteDAO clienteTeste = new ClienteDAO();
        LivroDAO livroTeste = new LivroDAO();

        String[] dadosNovosCliente = {"Jude Duarte","judeduarte@gmail.com","(31)99928-2001","111.111.789-11","30890-080","Elfhame","SE","Madoc's Place","12"};
        String[] dadosNovosLivro = {"Pr??ncipe Cruel", "2018", "Galera", "Holly Black", "320", "Romance"};

        Cliente novoCliente = new Cliente();
        Livro novoLivro = new Livro();

        novoCliente.setNome(dadosNovosCliente[0]);
        novoCliente.setEmail(dadosNovosCliente[1]);
        novoCliente.setTelefone(dadosNovosCliente[2]);
        novoCliente.setCpf(dadosNovosCliente[3]);
        novoCliente.setCep(dadosNovosCliente[4]);
        novoCliente.setCidade(dadosNovosCliente[5]);
        novoCliente.setUf(dadosNovosCliente[6]);
        novoCliente.setRua(dadosNovosCliente[7]);
        novoCliente.setNumero(Integer.parseInt(dadosNovosCliente[8]));

        novoLivro.setNome(dadosNovosLivro[0]);
        novoLivro.setAno(Integer.parseInt(dadosNovosLivro[1]));
        novoLivro.setEditora(dadosNovosLivro[2]);
        novoLivro.setAutor(dadosNovosLivro[3]);
        novoLivro.setNum_paginas(Integer.parseInt(dadosNovosLivro[4]));
        novoLivro.setGenero(dadosNovosLivro[5]);

        clienteTeste.alterar(novoCliente);
        livroTeste.alterar(novoLivro);
    }


    @Test
    @Order(6)
    public void deletaItens(){

        LivroDAO delecaoLivros = new LivroDAO();
        ClienteDAO delecaoClientes = new ClienteDAO();

        ArrayList<Cliente> clientesExcluir = new ArrayList<>();
        ArrayList<Livro> livrosExcluir = new ArrayList<>();

        clientesExcluir = delecaoClientes.listarTodos();
        livrosExcluir = delecaoLivros.listarTodos();

        for (Cliente cliente : clientesExcluir) {
            delecaoClientes.excluir(cliente.getCpf());
        }

        int id_inicial = livrosExcluir.get(0).getId();

        for(int j=id_inicial; j<id_inicial+livrosExcluir.size(); j++){
            delecaoLivros.excluir(j);
        }
        int[] numItensRecebido = new int[2];
        numItensRecebido[0] = delecaoClientes.listarTodos().size();
        numItensRecebido[1] = delecaoLivros.listarTodos().size();
        int[] numItensEsperado = {1, 1}; // Linha vazia na tabela

        assertArrayEquals(numItensEsperado, numItensRecebido);

    }

}



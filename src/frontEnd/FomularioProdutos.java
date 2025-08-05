package frontEnd;

import javax.swing.*;
import java.awt.*;

/**
 * Classe responsável por exibir o formulário de cadastro de produtos (Filme ou Jogo).
 */
public class FomularioProdutos extends JFrame {
    // Variável para armazenar a opção selecionada (Filme ou Jogo)
    private String opcao = "";
    // Painel onde o formulário será exibido
    private JPanel painelFormulario;

    public FomularioProdutos() {
        setTitle("Formulario para adicionar filme ou jogo"); // Título da janela
        setSize(700, 700); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
        setLayout(null); // Layout absoluto

        // Botões para seleção do tipo de produto
        JButton botaoFilme = new JButton("Filme");
        JButton botaoJogo = new JButton("Jogo");
        JLabel label = new JLabel("Selecione uma opção:");
        botaoFilme.setBounds(50, 100, 100, 30);
        botaoJogo.setBounds(200, 100, 100, 30);
        label.setBounds(50, 10, 200, 30);
        add(botaoFilme);
        add(botaoJogo);
        add(label);

        // Painel onde o formulário será exibido
        painelFormulario = new JPanel();
        painelFormulario.setLayout(null);
        painelFormulario.setBounds(0, 150, 700, 500);
        add(painelFormulario);

        // Ação ao clicar no botão "Filme"
        botaoFilme.addActionListener(e -> {
            opcao = "Filme";
            mostrarFormularioVideo();
        });

        // Ação ao clicar no botão "Jogo"
        botaoJogo.addActionListener(e -> {
            opcao = "Jogo";
            mostrarFormularioJogo();
        });

        setVisible(true); // Exibe a janela
    }

    /**
     * Exibe o formulário de cadastro de Filme no painel.
     */
    private void mostrarFormularioVideo() {
        painelFormulario.removeAll(); // Limpa o painel

        // Criação dos componentes do formulário de Video
        JLabel lformularioDeVideo = new JLabel("Formulario: " + opcao);
        JLabel lnome = new JLabel("Nome:");
        JLabel lclassInd = new JLabel("Classificação:");
        JLabel lestudio = new JLabel("Estúdio:");
        JLabel ldistrubuidora = new JLabel("Distribuidora:");
        JLabel lformato = new JLabel("Formato:");
        JLabel ltipoMidia = new JLabel("Tipo de Mídia:");
        JLabel lduracao = new JLabel("Duração (min):");

        JTextField nome = new JTextField();
        JTextField classInd = new JTextField();
        JTextField estudio = new JTextField();
        JTextField distrubuidora = new JTextField();
        JTextField formato = new JTextField();
        JTextField tipoMidia = new JTextField();
        JTextField duracao = new JTextField();

        // Define posições dos componentes
        lformularioDeVideo.setBounds(50, 10, 200, 30);
        lnome.setBounds(50, 50, 100, 30);
        lclassInd.setBounds(50, 90, 100, 30);
        lestudio.setBounds(50, 130, 100, 30);
        ldistrubuidora.setBounds(50, 170, 100, 30);
        lformato.setBounds(50, 210, 100, 30);
        ltipoMidia.setBounds(50, 250, 100, 30);
        lduracao.setBounds(50, 290, 100, 30);

        nome.setBounds(180, 50, 200, 30);
        classInd.setBounds(180, 90, 200, 30);
        estudio.setBounds(180, 130, 200, 30);
        distrubuidora.setBounds(180, 170, 200, 30);
        formato.setBounds(180, 210, 200, 30);
        tipoMidia.setBounds(180, 250, 200, 30);
        duracao.setBounds(180, 290, 200, 30);

        // Botão para salvar
        JButton salvar = new JButton("Salvar");
        salvar.setBounds(180, 340, 100, 30);

        // Adiciona componentes ao painel
        painelFormulario.add(lformularioDeVideo);
        painelFormulario.add(lnome);
        painelFormulario.add(lclassInd);
        painelFormulario.add(lestudio);
        painelFormulario.add(ldistrubuidora);
        painelFormulario.add(lformato);
        painelFormulario.add(ltipoMidia);
        painelFormulario.add(lduracao);
        painelFormulario.add(nome);
        painelFormulario.add(classInd);
        painelFormulario.add(estudio);
        painelFormulario.add(distrubuidora);
        painelFormulario.add(formato);
        painelFormulario.add(tipoMidia);
        painelFormulario.add(duracao);
        painelFormulario.add(salvar);

        // Ação do botão salvar
        salvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Jogo cadastrado com sucesso!");
        });

        painelFormulario.revalidate(); // Atualiza o painel
        painelFormulario.repaint();
    }

    /**
     * Exibe o formulário de cadastro de Jogo no painel.
     */
    private void mostrarFormularioJogo() {
        painelFormulario.removeAll(); // Limpa o painel

        // Criação dos componentes do formulário de Game
        JLabel lformularioDeJogo = new JLabel("Formulario: " + opcao);
        JLabel lnome = new JLabel("Nome:");
        JLabel lclassInd = new JLabel("Classificação:");
        JLabel lpublicadora = new JLabel("Publicadora:");
        JLabel ldesenvolvedor = new JLabel("Desenvolvedor:");
        JLabel lplataforma = new JLabel("Plataforma:");

        JTextField nome = new JTextField();
        JTextField classInd = new JTextField();
        JTextField publicadora = new JTextField();
        JTextField desenvolvedor = new JTextField();
        JTextField plataforma = new JTextField();

        // Define posições dos componentes
        lformularioDeJogo.setBounds(50, 10, 200, 30);
        lnome.setBounds(50, 50, 100, 30);
        lclassInd.setBounds(50, 90, 100, 30);
        lpublicadora.setBounds(50, 130, 100, 30);
        ldesenvolvedor.setBounds(50, 170, 100, 30);
        lplataforma.setBounds(50, 210, 100, 30);

        nome.setBounds(180, 50, 200, 30);
        classInd.setBounds(180, 90, 200, 30);
        publicadora.setBounds(180, 130, 200, 30);
        desenvolvedor.setBounds(180, 170, 200, 30);
        plataforma.setBounds(180, 210, 200, 30);

        //Cria o botão salvar
        JButton salvar = new JButton("Salvar");
        salvar.setBounds(180, 260, 100, 30);

        // Adiciona componentes ao painel
        painelFormulario.add(lformularioDeJogo);
        painelFormulario.add(lnome);
        painelFormulario.add(lclassInd);
        painelFormulario.add(lpublicadora);
        painelFormulario.add(ldesenvolvedor);
        painelFormulario.add(lplataforma);
        painelFormulario.add(nome);
        painelFormulario.add(classInd);
        painelFormulario.add(publicadora);
        painelFormulario.add(desenvolvedor);
        painelFormulario.add(plataforma);
        painelFormulario.add(salvar);

        // Ação do botão salvar
        salvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Jogo cadastrado com sucesso!");
        });

        painelFormulario.revalidate(); // Atualiza o painel
        painelFormulario.repaint();
    }
}

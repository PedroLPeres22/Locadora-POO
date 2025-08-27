/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontEnd;

import frontEnd.formularios.*;
import frontEnd.telas.*;
import java.awt.CardLayout;

/**
 *
 * @author gbert
 */
public class App extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App.class.getName());
    // componentes de tela
    private FormularioCliente formularioCliente;
    private CadastrarProdutos cadastrarprodutos;
    private ListaDeDados listaDados;

    /**
     * Creates new form App
     */
    public App() {
        initComponents();

        // Cria e registra os cards usados na aplicação (fazer isso após initComponents)
        formularioCliente = new FormularioCliente();
        cadastrarprodutos = new CadastrarProdutos();
        listaDados =  new ListaDeDados();

        // painel vazio inicial e outros cards
        tela.add(listaDados, "Lista de dados");
        tela.add(formularioCliente, "Formulario de cliente");
        tela.add(cadastrarprodutos, "Cadastrar Produtos");
        //tela.add(new javax.swing.JPanel(), "Lista de dados");

        // mostra o card vazio inicialmente
        ((CardLayout) tela.getLayout()).show(tela, "vazio");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        listaBotao = new javax.swing.JButton();
        cadastrarProdutoBotao = new javax.swing.JButton();
        cadastrarClienteBotao = new javax.swing.JButton();
        tela = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 700));
        setPreferredSize(new java.awt.Dimension(850, 700));

        menu.setBackground(new java.awt.Color(204, 204, 204));
        menu.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        menu.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        listaBotao.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        listaBotao.setText("Lista de Dados");
        listaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaBotaoActionPerformed(evt);
            }
        });
        menu.add(listaBotao);

        cadastrarProdutoBotao.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cadastrarProdutoBotao.setText("Cadastrar produtos");
        cadastrarProdutoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProdutoBotaoActionPerformed(evt);
            }
        });
        menu.add(cadastrarProdutoBotao);

        cadastrarClienteBotao.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cadastrarClienteBotao.setText("Cadastrar cliente");
        cadastrarClienteBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteBotaoActionPerformed(evt);
            }
        });
        menu.add(cadastrarClienteBotao);

        tela.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // mudando de tela para cadastrar produtos
    private void cadastrarProdutoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarProdutoBotaoActionPerformed
        CardLayout cl = (CardLayout) tela.getLayout();
        cl.show(tela, "Cadastrar Produtos");
    }//GEN-LAST:event_cadastrarProdutoBotaoActionPerformed

    // mudando de tela para lista de dados
    private void listaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaBotaoActionPerformed
        CardLayout cl = (CardLayout) tela.getLayout();
        listaDados.atualizarListas();
        cl.show(tela, "Lista de dados");
    }//GEN-LAST:event_listaBotaoActionPerformed

    // mudando de tela para cadastrar cliente
    private void cadastrarClienteBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteBotaoActionPerformed
        CardLayout cl = (CardLayout) tela.getLayout();
        cl.show(tela, "Formulario de cliente");
    }//GEN-LAST:event_cadastrarClienteBotaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarClienteBotao;
    private javax.swing.JButton cadastrarProdutoBotao;
    private javax.swing.JButton listaBotao;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel tela;
    // End of variables declaration//GEN-END:variables
}

package original;

import javax.swing.*;
import java.util.*;
import java.util.List;

public class Grafo extends JFrame {
    private List<String> index = new ArrayList<String>();
    private Dijkstra dijk = new Dijkstra(100);
    
    public Grafo(){
        initializeGraph();
    }
    
    private void initializeGraph() {
        adicionarVertice("Sao Paulo");
        adicionarVertice("Santos");
        adicionarVertice("Sao Jose dos Campos");
        adicionarVertice("Sorocaba");
        adicionarVertice("Campinas");
        adicionarVertice("Piracicaba");
        adicionarVertice("Araraquara");
        adicionarVertice("Riberao Preto");
        adicionarVertice("Sao Jose do Rio Preto");
        adicionarVertice("Bauru");
        adicionarVertice("Marilia");
        adicionarVertice("Presidente Prudente");
        adicionarVertice("Araçatuba");
        
        adicionarAresta("Sao Paulo", "Santos", 85);
        adicionarAresta("Sao Paulo", "Sao Jose dos Campos", 91);
        adicionarAresta("Sao Paulo", "Sorocaba", 101);
        adicionarAresta("Sao Paulo", "Campinas", 92);
        adicionarAresta("Santos", "Sao Paulo", 85);
        adicionarAresta("Sao Jose dos Campos", "Sao Paulo", 91);
        adicionarAresta("Sorocaba", "Bauru", 244);
        adicionarAresta("Sorocaba", "Presidente Prudente", 472);
        adicionarAresta("Sorocaba", "Sao Paulo", 101);
        adicionarAresta("Campinas", "Sao Paulo", 92);
        adicionarAresta("Campinas", "Piracicaba", 72);
        adicionarAresta("Campinas", "Araraquara", 185);
        adicionarAresta("Campinas", "Riberao Preto", 222);
        adicionarAresta("Piracicaba", "Campinas", 72);
        adicionarAresta("Araraquara", "Campinas", 185);
        adicionarAresta("Araraquara", "Sao Jose do Rio Preto", 168);
        adicionarAresta("Riberao Preto", "Campinas", 222);
        adicionarAresta("Sao Jose do Rio Preto", "Araraquara", 185);
        adicionarAresta("Bauru", "Marilia", 106);
        adicionarAresta("Bauru", "Sorocaba", 244);
        adicionarAresta("Bauru", "Araçatuba", 191);
        adicionarAresta("Marilia", "Bauru", 106);
        adicionarAresta("Presidente Prudente", "Sorocaba", 472);
        adicionarAresta("Araçatuba", "Bauru", 191);    
 
 }
    
    public void adicionarVertice(String nome){
        dijk.adicionarDadosVertice(index.size(), nome);
        index.add(nome);
    }
    
    public void adicionarAresta(String origemNome, String destinoNome, int distancia){
        
        if(index.contains(origemNome) && index.contains(destinoNome)){
            int origem = index.indexOf(origemNome);
            int destino = index.indexOf(destinoNome);
            dijk.adicionarAresta(origem, destino, distancia);
        }else if(distancia < 1)
            JOptionPane.showMessageDialog(this, "Distancia invalida.");
        else
            JOptionPane.showMessageDialog(this, "Cidade(s) invalidas(s).");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cadastrarCidade = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        origemCidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        destinoCidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        origemCaminho = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        destinoCaminho = new javax.swing.JTextField();
        cadastrarCaminho = new javax.swing.JButton();
        distanciaCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        distanciaCaminho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Tela = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        destinoCurto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        origemCurto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        acharCurto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastrarCidade.setText("Cadastrar");
        cadastrarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCidadeActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome da cidade");

        origemCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origemCidadeActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Conecta-se a qual");

        destinoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoCidadeActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Origem");

        origemCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origemCaminhoActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Destino");

        destinoCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoCaminhoActionPerformed(evt);
            }
        });

        cadastrarCaminho.setText("Cadastrar");
        cadastrarCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCaminhoActionPerformed(evt);
            }
        });

        distanciaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaCidadeActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Distância (metros)");

        distanciaCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaCaminhoActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Distância (metros)");

        javax.swing.GroupLayout TelaLayout = new javax.swing.GroupLayout(Tela);
        Tela.setLayout(TelaLayout);
        TelaLayout.setHorizontalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        TelaLayout.setVerticalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cadastrar Caminho");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cadastrar Cidade");

        jLabel9.setText("Menor caminho");

        destinoCurto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoCurtoActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Destino");

        origemCurto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origemCurtoActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Origem");

        acharCurto.setText("Achar caminho");
        acharCurto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acharCurtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(acharCurto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cadastrarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(origemCidade)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(destinoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(distanciaCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(origemCurto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(destinoCurto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastrarCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(origemCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(destinoCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distanciaCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(44, 44, 44)
                .addComponent(Tela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(origemCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(destinoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(distanciaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastrarCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(origemCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destinoCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distanciaCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastrarCaminho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(origemCurto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destinoCurto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acharCurto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void origemCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origemCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origemCidadeActionPerformed

    private void destinoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoCidadeActionPerformed

    private void cadastrarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarCidadeActionPerformed
        String origem = origemCidade.getText();
        String destino = destinoCidade.getText();
        String distancia = distanciaCidade.getText();
        
        adicionarVertice(origemCidade.getText());
        
        if(!destino.isEmpty() && !distancia.isEmpty()){
            int dist;
            try {
                dist = Integer.parseInt(distancia);
            } catch (NumberFormatException e) {
                dist = 0;
            }
            adicionarAresta(origem, destino, dist);      
        }
    }//GEN-LAST:event_cadastrarCidadeActionPerformed

    private void origemCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origemCaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origemCaminhoActionPerformed

    private void destinoCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoCaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoCaminhoActionPerformed

    private void cadastrarCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarCaminhoActionPerformed
        String origem = origemCaminho.getText();
        String destino = destinoCaminho.getText();
        String distancia = distanciaCaminho.getText();
        
        if(!destino.isEmpty() && !distancia.isEmpty()){
            int dist;
            try {
                dist = Integer.parseInt(distancia);
            } catch (NumberFormatException e) {
                dist = 0;
            }
            adicionarAresta(origem, destino, dist);      
        }
    }//GEN-LAST:event_cadastrarCaminhoActionPerformed

    private void distanciaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaCidadeActionPerformed

    private void distanciaCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaCaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaCaminhoActionPerformed

    private void destinoCurtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoCurtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoCurtoActionPerformed

    private void origemCurtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origemCurtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origemCurtoActionPerformed

    private void acharCurtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acharCurtoActionPerformed
        String origem = origemCurto.getText();
        String destino = destinoCurto.getText();
        
        System.out.println(dijk.menorDistanciaEspecifica(origem, index.indexOf(destino)));
        List<Integer> caminho = new ArrayList<>();
        caminho = dijk.caminhoMaisCurto(index.indexOf(destino));
        for(int cidade:caminho){
            System.out.println(index.get(cidade) + "\n");
        }
    }//GEN-LAST:event_acharCurtoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tela;
    private javax.swing.JPanel Tela1;
    private javax.swing.JButton acharCurto;
    private javax.swing.JButton cadastrarCaminho;
    private javax.swing.JButton cadastrarCidade;
    private javax.swing.JTextField destinoCaminho;
    private javax.swing.JTextField destinoCidade;
    private javax.swing.JTextField destinoCurto;
    private javax.swing.JTextField distanciaCaminho;
    private javax.swing.JTextField distanciaCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField origemCaminho;
    private javax.swing.JTextField origemCidade;
    private javax.swing.JTextField origemCurto;
    // End of variables declaration//GEN-END:variables
}

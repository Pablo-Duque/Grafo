package ed2.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.util.*;
import java.util.List;
import grafo.Dijkstra;

public class Grafo extends JFrame {
    private List<String> index = new ArrayList<String>();
    private List<Cidade> cidades = new ArrayList<Cidade>();
    private List<Caminho> caminhos = new ArrayList<Caminho>();
    private Dijkstra dijk = new Dijkstra(100);
    private List<Integer> curto = new ArrayList<Integer>();
    private Tela tela;
    
    private static final int RAIO_CIDADE = 20;
    private static final int EDGE_COLOR_ALPHA = 150;
    
    public Grafo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        tela = new Tela();
        inicializarGrafo();
        posicionarCidades();
    }
    
    private void inicializarGrafo() {
        adicionarCidade("Sao Paulo");
        adicionarCidade("Santos");
        adicionarCidade("Sao Jose dos Campos");
        adicionarCidade("Sorocaba");
        adicionarCidade("Campinas");
        adicionarCidade("Piracicaba");
        adicionarCidade("Araraquara");
        adicionarCidade("Riberao Preto");
        adicionarCidade("Sao Jose do Rio Preto");
        adicionarCidade("Bauru");
        adicionarCidade("Marilia");
        adicionarCidade("Presidente Prudente");
        adicionarCidade("Araçatuba");
        
        adicionarCaminho("Sao Paulo", "Santos", 85);
        adicionarCaminho("Sao Paulo", "Sao Jose dos Campos", 91);
        adicionarCaminho("Sao Paulo", "Sorocaba", 101);
        adicionarCaminho("Sao Paulo", "Campinas", 92);
        adicionarCaminho("Santos", "Sao Paulo", 85);
        adicionarCaminho("Sao Jose dos Campos", "Sao Paulo", 91);
        adicionarCaminho("Sorocaba", "Bauru", 244);
        adicionarCaminho("Sorocaba", "Presidente Prudente", 472);
        adicionarCaminho("Sorocaba", "Sao Paulo", 101);
        adicionarCaminho("Campinas", "Sao Paulo", 92);
        adicionarCaminho("Campinas", "Piracicaba", 72);
        adicionarCaminho("Campinas", "Araraquara", 185);
        adicionarCaminho("Campinas", "Riberao Preto", 222);
        adicionarCaminho("Piracicaba", "Campinas", 72);
        adicionarCaminho("Araraquara", "Campinas", 185);
        adicionarCaminho("Araraquara", "Sao Jose do Rio Preto", 168);
        adicionarCaminho("Riberao Preto", "Campinas", 222);
        adicionarCaminho("Sao Jose do Rio Preto", "Araraquara", 185);
        adicionarCaminho("Bauru", "Marilia", 106);
        adicionarCaminho("Bauru", "Sorocaba", 244);
        adicionarCaminho("Bauru", "Araçatuba", 191);
        adicionarCaminho("Marilia", "Bauru", 106);
        adicionarCaminho("Presidente Prudente", "Sorocaba", 472);
        adicionarCaminho("Araçatuba", "Bauru", 191);    

 }
    
    public void adicionarCidade(String nome){
        int id = cidades.size();
        dijk.adicionarDadosVertice(id, nome);
        cidades.add(new Cidade(id, nome));
        index.add(nome);
        posicionarCidades();
    }
    
    public void adicionarCaminho(String origemNome, String destinoNome, int distancia){
        
        if(index.contains(origemNome) && index.contains(destinoNome)){
            int origem = index.indexOf(origemNome);
            int destino = index.indexOf(destinoNome);
            dijk.adicionarAresta(origem, destino, distancia);
            caminhos.add(new Caminho(origem, destino, distancia));
        }else if(distancia < 1)
            JOptionPane.showMessageDialog(this, "Distancia invalida.");
        else
            JOptionPane.showMessageDialog(this, "Cidade(s) invalidas(s).");
        
        posicionarCidades();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        destinoCurto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        origemCurto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        acharCurto = new javax.swing.JButton();
        deletarCaminho = new javax.swing.JButton();
        deletarCidade1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastrarCidade.setText("Criar");
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

        cadastrarCaminho.setText("Criar");
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

        deletarCaminho.setText("Del");
        deletarCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarCaminhoActionPerformed(evt);
            }
        });

        deletarCidade1.setText("Del");
        deletarCidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarCidade1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(origemCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinoCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(distanciaCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(deletarCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cadastrarCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(12, 12, 12)
                        .addComponent(deletarCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cadastrarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(acharCurto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1076, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarCidade)
                    .addComponent(deletarCidade1))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarCaminho)
                    .addComponent(deletarCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(46, Short.MAX_VALUE))
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
        
        adicionarCidade(origemCidade.getText());
        
        if(!destino.isEmpty() && !distancia.isEmpty()){
            int dist;
            try {
                dist = Integer.parseInt(distancia);
            } catch (NumberFormatException e) {
                dist = 0;
            }
            adicionarCaminho(origem, destino, dist);      
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
        
        if(!origem.isEmpty() && !destino.isEmpty() && !distancia.isEmpty()){
            int dist;
            try {
                dist = Integer.parseInt(distancia);
            } catch (NumberFormatException e) {
                dist = 0;
            }
            adicionarCaminho(origem, destino, dist);      
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
        
        if(index.contains(origem) && index.contains(destino)){
            dijk.menorDistanciaEspecifica(origem, index.indexOf(destino));
            curto = dijk.caminhoMaisCurto(index.indexOf(destino));
//            tela.repaint();
posicionarCidades();
        }
    }//GEN-LAST:event_acharCurtoActionPerformed

    private void deletarCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarCaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletarCaminhoActionPerformed

    private void deletarCidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarCidade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletarCidade1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafo().setVisible(true);
            }
        });
    }
        
    private void posicionarCidades() {
        Random rand = new Random();
        int gridSize = 100;
        int maximoTentativas = 100;

        for (Cidade city : cidades) {
            int qtdTentativa = 0;
            boolean posicionado = false;
            while (!posicionado && qtdTentativa < maximoTentativas) {
                int x = rand.nextInt(tela.getWidth() - 2 * RAIO_CIDADE);
                int y = rand.nextInt(tela.getHeight()- 2 * RAIO_CIDADE);

                city.setX(x);
                city.setY(y);

                posicionado = true;
                for (Cidade outro : cidades) {
                    if (outro != city && Math.abs(outro.getX() - x) < gridSize && Math.abs(outro.getY() - y) < gridSize) {
                        posicionado = false;
                        break;
                    }
                }
                qtdTentativa++;
            }
        }
        tela.repaint();
    }
    
    //Pintar
    private class Tela extends javax.swing.JPanel {

        public Tela(){
            setSize(1038, 656);
            setLocation(163, 19);
            setAlignmentX(0.5f);
            setAlignmentY(0.5f);
            setBackground(Color.WHITE);
            jPanel1.add(this);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            List<String> passou = new ArrayList<String>();
                        
                for (Caminho road : caminhos) {
                    Cidade origem = cidades.get(road.getOrigem());
                    Cidade destino = cidades.get(road.getDestino());
                    passou.add(origem.getId() + "," + destino.getId());
                    
                    //Evita linha dupla
                    if(!passou.contains(destino.getId() + "," + origem.getId())){
                        int comecoX = origem.getX();
                        int comecoY = origem.getY();
                        int fimX = destino.getX();
                        int fimY = destino.getY();

                        if(!curto.isEmpty()){
                            int idO = origem.getId();
                            int idD = destino.getId();
                            
                            for(int i = 0; i < curto.size(); i++){            
                                if (i+1 < curto.size()) {
                                    if(curto.contains(idO) && curto.contains(idD))
                                        g.setColor(Color.BLUE);  
                                     else 
                                        g.setColor(Color.RED);
                                    }
                            }
                        }else{
                            g.setColor(Color.RED);
                        }
                        g.drawLine(comecoX, comecoY, fimX, fimY);
                        g.drawString(String.valueOf(road.getDistancia()), (comecoX + fimX) / 2, (comecoY + fimY) / 2);
                    }
                }
                

            for (Cidade city : cidades) {
                int x = city.getX();
                int y = city.getY();

                g.setColor(new Color(167, 171, 221));
                g.fillOval(x - RAIO_CIDADE, y - RAIO_CIDADE, 2 * RAIO_CIDADE, 2 * RAIO_CIDADE);
                g.setColor(Color.BLACK);
                g.drawString(city.getNome(), x - 10, y);
            }
        }
    }
        
    private class Cidade {
        private int id;
        private String nome;
        private int x;
        private int y;

        public Cidade(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    private class Caminho {
        private int origem;
        private int destino;
        private int distancia;

        public Caminho(int origem, int destino, int distancia) {
            this.origem = origem;
            this.destino = destino;
            this.distancia = distancia;
        }

        public int getOrigem() {
            return origem;
        }

        public int getDestino() {
            return destino;
        }
        
        public int getDistancia() {
            return distancia;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acharCurto;
    private javax.swing.JButton cadastrarCaminho;
    private javax.swing.JButton cadastrarCidade;
    private javax.swing.JButton deletarCaminho;
    private javax.swing.JButton deletarCidade1;
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

package original;

import javax.swing.*;
import java.util.*;
import java.util.List;

public class OLD_Grafo extends JFrame {
    private List<String> index = new ArrayList<String>();
    private Dijkstra dijk = new Dijkstra(100);
    
    public OLD_Grafo(){
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
        
        
        System.out.println(dijk.menorDistanciaEspecifica("Sao Paulo", index.indexOf("Bauru")));
        List<Integer> caminho = new ArrayList<>();
        caminho = dijk.caminhoMaisCurto(index.indexOf("Bauru"));
        for(int a:caminho){
            System.out.println(index.get(a) + "\n");
        }
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
        }
        else{
            JOptionPane.showMessageDialog(this, "Vértice(s) inválido(s).");
        }
    }

    public static void main(String[] args) {
        new OLD_Grafo();
    }
    
}
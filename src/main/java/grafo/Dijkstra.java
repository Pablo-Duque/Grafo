package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

    public int[][] matrizAdjacencia;
    public double[][] matrizPedagio;
    public String[] dadosVertices;
    public int tamanho;
    public int[] predecessores;

    public Dijkstra(int tamanho) {
        this.tamanho = tamanho;
        this.matrizAdjacencia = new int[tamanho][tamanho];
        this.matrizPedagio = new double[tamanho][tamanho];
        this.dadosVertices = new String[tamanho];
    }

    public void adicionarAresta(int origem, int destino, int peso, double pedagio) {
        if (verticeValido(origem) && verticeValido(destino)) {
            matrizAdjacencia[origem][destino] = peso;
            matrizAdjacencia[destino][origem] = peso;
            matrizPedagio[origem][destino] = pedagio;
            matrizPedagio[destino][origem] = pedagio;
        }
    }

    public void removerAresta(int origem, int destino) {
        if (verticeValido(origem) && verticeValido(destino)) {
            matrizAdjacencia[origem][destino] = 0;
            matrizAdjacencia[destino][origem] = 0;
            matrizPedagio[origem][destino] = 0;
            matrizPedagio[destino][origem] = 0;
        }
    }
                
    public void adicionarDadosVertice(int vertice, String dados) {
        if (verticeValido(vertice)) {
            dadosVertices[vertice] = dados;
        }
    }
    
    public void removerDadosVertice(int vertice) {
        if (verticeValido(vertice)) {
            for(int i = 0; i < tamanho; i++){
                matrizAdjacencia[i][vertice] = 0;
                matrizPedagio[i][vertice] = 0;
            }
            for(int i = 0; i < tamanho; i++){
                matrizAdjacencia[vertice][i] = 0;
                matrizPedagio[vertice][i] = 0;
            }
            dadosVertices[vertice] = null;
        }
    }

    public double[] dijkstra(String dadosVerticeInicial, boolean usarDistancia) {
        int verticeInicial = encontrarIndice(dadosVerticeInicial);
        double[] distancias = new double[tamanho];
        boolean[] visitados = new boolean[tamanho];
        predecessores = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            predecessores[i] = -1;
        }

        inicializarDistancias(distancias, verticeInicial);

        for (int i = 0; i < tamanho; i++) {
            int verticeAtual = encontrarMenorDistancia(distancias, visitados);
            if (verticeAtual == -1)
                break;
            visitados[verticeAtual] = true;
            atualizarDistancias(verticeAtual, distancias, visitados, usarDistancia);
        }
        return distancias;
    }

    private boolean verticeValido(int vertice) {
        return vertice >= 0 && vertice < tamanho;
    }

    private void inicializarDistancias(double[] distancias, int verticeInicial) {
        for (int i = 0; i < tamanho; i++) {
            distancias[i] = Integer.MAX_VALUE;
        }
        distancias[verticeInicial] = 0;
    }

    public int encontrarIndice(String dados) {
        for (int i = 0; i < tamanho; i++) {
            if (dadosVertices[i] != null && dadosVertices[i].equals(dados)) {
                return i;
            }
        }
        return -1;
    }

    private int encontrarMenorDistancia(double[] distancias, boolean[] visitados) {
        double menorDistancia = Integer.MAX_VALUE;
        int indiceMenorDistancia = -1;

        for (int i = 0; i < tamanho; i++) {
            if (!visitados[i] && distancias[i] <= menorDistancia) {
                menorDistancia = distancias[i];
                indiceMenorDistancia = i;
            }
        }
        return indiceMenorDistancia;
    }

    public double menorDistanciaEspecifica(String origem, int destino, boolean usarDistancia){
        double [] distancias = dijkstra(origem, usarDistancia);
        return distancias[destino];
    }

    private void atualizarDistancias(int verticeAtual, double[] distancias, boolean[] visitados, boolean usarDistancia) {
        for (int i = 0; i < tamanho; i++) {
            if (!visitados[i] && matrizAdjacencia[verticeAtual][i] != 0
                    && distancias[verticeAtual] != Double.MAX_VALUE) {
                double novaDistancia = distancias[verticeAtual] + (usarDistancia ? matrizAdjacencia[verticeAtual][i] : matrizPedagio[verticeAtual][i]);
                if (novaDistancia < distancias[i]) {
                    distancias[i] = novaDistancia;
                    predecessores[i] = verticeAtual;
                }
            }
        }
    }

    public List<Integer> caminhoMaisCurto(int verticeDestino) {
        List<Integer> caminho = new ArrayList<>();
        caminho.add(verticeDestino);

        while (predecessores[verticeDestino] != -1) {
            verticeDestino = predecessores[verticeDestino];
            caminho.add(verticeDestino);
        }

        Collections.reverse(caminho);
        return caminho;
    }

}

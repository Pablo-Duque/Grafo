
package grafo;

import java.util.List;

public class DijkstraFila {

    private List<Aresta> arestas;
    private List<String> vertices;
    private int tamanho;

    public void adicionarAresta(String origem, String destino, int peso) {
            if (verticeValido(origem) && verticeValido(destino)) {
                    arestas.add(new Aresta(origem, destino, peso)); 
            }
    }

    public void adicionarDadosVertice(String dados) {
                    vertices.add(dados);
    }

    public int[] dijkstra(String dadosVerticeInicial) {
            int verticeInicial = encontrarIndice(dadosVerticeInicial);
            int[] distancias = new int[tamanho];
            boolean[] visitados = new boolean[tamanho];

            inicializarDistancias(distancias, verticeInicial);

            for (int i = 0; i < tamanho; i++) {
                    int verticeAtual = encontrarMenorDistancia(distancias, visitados);
                    if (verticeAtual == -1)
                            break;

                    visitados[verticeAtual] = true;
                    atualizarDistancias(verticeAtual, distancias, visitados);
            }
            return distancias;
    }

    private boolean verticeValido(String vertice) {
            return vertices.contains(vertice);
    }

    private void inicializarDistancias(int[] distancias, int verticeInicial) {
            for (int i = 0; i < tamanho; i++) {
                    distancias[i] = Integer.MAX_VALUE;
            }
            distancias[verticeInicial] = 0;
    }

    public int encontrarIndice(String dados) {
            for (int i = 0; i < tamanho; i++) {
                    if (vertices[i].equals(dados)) {
                            return i;
                    }
            }
            return -1;
    }

    public int encontrarMenorDistancia(int[] distancias, boolean[] visitados) {
            int menorDistancia = Integer.MAX_VALUE;
            int indiceMenorDistancia = -1;

            for (int i = 0; i < tamanho; i++) {
                    if (!visitados[i] && distancias[i] <= menorDistancia) {
                            menorDistancia = distancias[i];
                            indiceMenorDistancia = i;
                    }
            }
            return indiceMenorDistancia;
    }

    private void atualizarDistancias(int verticeAtual, int[] distancias, boolean[] visitados) {
            for (int i = 0; i < tamanho; i++) {
                    if (!visitados[i] && arestas[verticeAtual][i] != 0
                                    && distancias[verticeAtual] != Integer.MAX_VALUE) {
                            int novaDistancia = distancias[verticeAtual] + arestas[verticeAtual][i];
                            if (novaDistancia < distancias[i]) {
                                    distancias[i] = novaDistancia;
                            }
                    }
            }
    }
}

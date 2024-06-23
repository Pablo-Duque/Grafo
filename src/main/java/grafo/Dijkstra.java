package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

		private int[][] matrizAdjacencia;
		private String[] dadosVertices;
		private int tamanho;
                private int[] predecessores;

		public Dijkstra(int tamanho) {
			this.tamanho = tamanho;
			this.matrizAdjacencia = new int[tamanho][tamanho];
			this.dadosVertices = new String[tamanho];
		}

		public void adicionarAresta(int origem, int destino, int peso) {
			if (verticeValido(origem) && verticeValido(destino)) {
				matrizAdjacencia[origem][destino] = peso;
				matrizAdjacencia[destino][origem] = peso;
			}
		}

		public void adicionarDadosVertice(int vertice, String dados) {
			if (verticeValido(vertice)) {
				dadosVertices[vertice] = dados;
			}
		}

		public int[] dijkstra(String dadosVerticeInicial) {
			int verticeInicial = encontrarIndice(dadosVerticeInicial);
			int[] distancias = new int[tamanho];
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
				atualizarDistancias(verticeAtual, distancias, visitados);
			}
			return distancias;
		}

		private boolean verticeValido(int vertice) {
			return vertice >= 0 && vertice < tamanho;
		}

		private void inicializarDistancias(int[] distancias, int verticeInicial) {
			for (int i = 0; i < tamanho; i++) {
				distancias[i] = Integer.MAX_VALUE;
			}
			distancias[verticeInicial] = 0;
		}

		public int encontrarIndice(String dados) {
			for (int i = 0; i < tamanho; i++) {
				if (dadosVertices[i].equals(dados)) {
					return i;
				}
			}
			return -1;
		}

		private int encontrarMenorDistancia(int[] distancias, boolean[] visitados) {
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
                
                public int menorDistanciaEspecifica(String origem, int destino){
                    int [] distancias = dijkstra(origem);
                    return distancias[destino];
                }

		private void atualizarDistancias(int verticeAtual, int[] distancias, boolean[] visitados) {
			for (int i = 0; i < tamanho; i++) {
				if (!visitados[i] && matrizAdjacencia[verticeAtual][i] != 0
						&& distancias[verticeAtual] != Integer.MAX_VALUE) {
					int novaDistancia = distancias[verticeAtual] + matrizAdjacencia[verticeAtual][i];
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


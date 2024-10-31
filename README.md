# Aplicação de Navegação entre Cidades com Algoritmo de Dijkstra

## Descrição do Projeto
Esta aplicação Java utiliza o algoritmo de Dijkstra para calcular o caminho mais curto entre cidades com base na menor distância ou no menor custo de pedágio. Com um grafo que representa ao menos 20 cidades conectadas por estradas com distâncias e pedágios variados, a aplicação permite ao usuário definir uma cidade de origem e destino, escolher o critério de busca, e visualizar o caminho mais eficiente.

A aplicação foi implementada com suporte para a biblioteca jgraphx, oferecendo uma interface gráfica que facilita a visualização do grafo e a interação com as cidades e rotas.

## Funcionalidades
### Busca pelo caminho mais curto (Dijkstra):
Opção de busca baseada na menor distância ou no menor custo acumulado de pedágio.
Apresenta a rota mais eficiente no grafo e mostra as informações da rota (distância total ou custo de pedágio total) no painel de saída.

### Manipulação de Grafo:
Interface gráfica que exibe as cidades e conexões entre elas, permitindo visualizar os caminhos e distâncias entre cidades.
Permite adicionar e remover cidades (vértices) e rotas (arestas) diretamente pela interface, atualizando o grafo em tempo real.

### Interatividade:
Seletor de cidades de origem e destino.
Escolha entre os critérios de menor distância ou menor custo de pedágio para a busca do caminho.
Exibição do caminho resultante no painel de interface e saída das informações sobre o percurso.

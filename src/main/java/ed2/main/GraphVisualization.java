package ed2.main;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphVisualization {

    private static Graph<String, DefaultEdge> graph;
    private static Layout<String, DefaultEdge> layout;
    private static BasicVisualizationServer<String, DefaultEdge> vv;

    public static void main(String[] args) {
        // Criação do grafo
        graph = createGraph();

        // Convertendo o grafo do JGraphT para o formato usado pelo JUNG
        edu.uci.ics.jung.graph.Graph<String, DefaultEdge> jungGraph = new SparseMultigraph<>();
        for (String vertex : graph.vertexSet()) {
            jungGraph.addVertex(vertex);
        }
        for (DefaultEdge edge : graph.edgeSet()) {
            jungGraph.addEdge(edge, graph.getEdgeSource(edge), graph.getEdgeTarget(edge));
        }

        // Layout e visualização
        layout = new FRLayout<>(jungGraph);
        layout.setSize(new Dimension(800, 600));
        vv = new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(800, 600));

        JFrame frame = new JFrame("Graph Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Botão para adicionar vértice
        JButton addVertexButton = new JButton("Adicionar Vértice");
        addVertexButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vertex = JOptionPane.showInputDialog(frame, "Digite o nome do vértice:");
                if (vertex != null && !vertex.isEmpty()) {
                    graph.addVertex(vertex);
                    updateGraphVisualization();
                }
            }
        });
        
        // Botão para remover vértice
        JButton removeVertexButton = new JButton("Remover Vértice");
        removeVertexButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vertex = JOptionPane.showInputDialog(frame, "Digite o nome do vértice a ser removido:");
                if (vertex != null && !vertex.isEmpty()) {
                    graph.removeVertex(vertex);
                    updateGraphVisualization();
                }
            }
        });

        // Botão para calcular menor caminho usando Dijkstra
        JButton dijkstraButton = new JButton("Calcular Menor Caminho (Dijkstra)");
        dijkstraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sourceVertex = JOptionPane.showInputDialog(frame, "Digite o vértice de origem:");
                String targetVertex = JOptionPane.showInputDialog(frame, "Digite o vértice de destino:");
                if (sourceVertex != null && targetVertex != null &&
                        graph.containsVertex(sourceVertex) && graph.containsVertex(targetVertex)) {
                    calculateAndShowShortestPath(sourceVertex, targetVertex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Vértices de origem ou destino inválidos.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(addVertexButton);
        panel.add(removeVertexButton);
        panel.add(dijkstraButton);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }

    private static void updateGraphVisualization() {
        edu.uci.ics.jung.graph.Graph<String, DefaultEdge> jungGraph = new SparseMultigraph<>();
        for (String vertex : graph.vertexSet()) {
            jungGraph.addVertex(vertex);
        }
        for (DefaultEdge edge : graph.edgeSet()) {
            jungGraph.addEdge(edge, graph.getEdgeSource(edge), graph.getEdgeTarget(edge));
        }

        layout = new FRLayout<>(jungGraph);
        layout.setSize(new Dimension(800, 600));
        vv.setGraphLayout(layout);
        vv.repaint();
    }

    private static void calculateAndShowShortestPath(String sourceVertex, String targetVertex) {
        // Utiliza o algoritmo de Dijkstra para calcular o menor caminho
        grafo.Dijkstra.Grafo dijkstraGraph = new grafo.Dijkstra.Grafo(graph.vertexSet().size());

        int i = 0;
        for (String vertex : graph.vertexSet()) {
            dijkstraGraph.adicionarDadosVertice(i++, vertex);
        }

        for (DefaultEdge edge : graph.edgeSet()) {
            String source = graph.getEdgeSource(edge);
            String target = graph.getEdgeTarget(edge);
            int sourceIndex = dijkstraGraph.encontrarIndice(source);
            int targetIndex = dijkstraGraph.encontrarIndice(target);
            dijkstraGraph.adicionarAresta(sourceIndex, targetIndex, 1); // Arestas com peso 1
        }

        int[] distances = dijkstraGraph.dijkstra(sourceVertex);
        int targetIndex = dijkstraGraph.encontrarIndice(targetVertex);

        JOptionPane.showMessageDialog(vv, "Menor caminho de " + sourceVertex + " para " + targetVertex + ": " + distances[targetIndex]);
    }

    private static Graph<String, DefaultEdge> createGraph() {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Adicionando vértices e arestas
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("D", "A");
        graph.addEdge("D", "E");
        graph.addEdge("A", "C");
        graph.addEdge("A", "E");
        graph.addEdge("E", "C");
        graph.addEdge("E", "G");
        graph.addEdge("C", "F");
        graph.addEdge("C", "B");
        graph.addEdge("B", "F");
        graph.addEdge("G", "F");

        return graph;
    }
}

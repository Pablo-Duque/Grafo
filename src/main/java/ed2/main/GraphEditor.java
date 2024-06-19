package ed2.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GraphEditor extends JFrame {

    private JPanel panel;
    private JButton addVertexButton;
    private JButton deleteVertexButton;
    private JButton dijkstraButton;
    private JTextField vertexNameField;
    private JTextField connectToField;
    private JTextField distanceField;
    private JTextField sourceField;
    private JTextField destinationField;
    private Map<Integer, Vertex> vertices;
    private int vertexCount;
    private GraphPanel graphPanel;
    private List<Edge> dijkstraPath;

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;
    private static final int VERTEX_RADIUS = 20;
    private static final int EDGE_COLOR_ALPHA = 150; // Transparência da cor das arestas

    public GraphEditor() {
        super("Graph Editor");

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        addVertexButton = new JButton("Add Vertex");
        addVertexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVertex();
            }
        });
        panel.add(addVertexButton);

        deleteVertexButton = new JButton("Delete Vertex");
        deleteVertexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedVertex();
            }
        });
        panel.add(deleteVertexButton);

        vertexNameField = new JTextField(10);
        panel.add(new JLabel("Vertex Name:"));
        panel.add(vertexNameField);

        connectToField = new JTextField(10);
        panel.add(new JLabel("Connect to (Vertex Name):"));
        panel.add(connectToField);

        distanceField = new JTextField(5);
        panel.add(new JLabel("Distance:"));
        panel.add(distanceField);

        sourceField = new JTextField(10);
        panel.add(new JLabel("Source:"));
        panel.add(sourceField);

        destinationField = new JTextField(10);
        panel.add(new JLabel("Destination:"));
        panel.add(destinationField);

        dijkstraButton = new JButton("Find Shortest Path");
        dijkstraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findShortestPath();
            }
        });
        panel.add(dijkstraButton);

        vertices = new HashMap<>();
        vertexCount = 0;

        graphPanel = new GraphPanel();
        add(panel, BorderLayout.NORTH);
        add(graphPanel, BorderLayout.CENTER);

        initializeGraph(); // Initialize the graph with the given cities and distances

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addVertex() {
        String vertexName = vertexNameField.getText().trim();
        if (vertexName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a vertex name.");
            return;
        }

        Vertex newVertex = new Vertex(vertexCount++, vertexName);
        vertices.put(newVertex.getId(), newVertex);

        // Calculate position dynamically based on existing vertices
        layoutVertices();

        // If connectToField and distanceField are filled, add an edge
        String connectToName = connectToField.getText().trim();
        String distanceStr = distanceField.getText().trim();

        if (!connectToName.isEmpty() && !distanceStr.isEmpty()) {
            try {
                int distance = Integer.parseInt(distanceStr);
                addEdge(newVertex, connectToName, distance);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid distance.");
            }
        }

        graphPanel.repaint();

        JOptionPane.showMessageDialog(this, "Vertex added: " + vertexName);
    }

    private void addEdge(Vertex fromVertex, String toVertexName, int distance) {
        boolean found = false;
        for (Vertex vertex : vertices.values()) {
            if (vertex.getName().equalsIgnoreCase(toVertexName)) {
                fromVertex.addEdge(vertex.getId(), distance);
                vertex.addEdge(fromVertex.getId(), distance); // Assuming undirected graph
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Vertex '" + toVertexName + "' not found.");
        }
    }

    private void deleteSelectedVertex() {
        String input = JOptionPane.showInputDialog(this, "Enter Vertex Name to delete:");
        if (input == null || input.trim().isEmpty()) {
            return; // User canceled or entered empty string
        }

        boolean found = false;
        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(input.trim())) {
                int vertexId = entry.getKey();
                vertices.remove(vertexId);
                // Remove all edges connected to this vertex
                for (Vertex vertex : vertices.values()) {
                    vertex.removeEdgeTo(vertexId);
                }
                found = true;
                break;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(this, "Vertex '" + input + "' deleted.");
            layoutVertices(); // Re-layout vertices after deletion
            graphPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Vertex '" + input + "' not found.");
        }
    }

    private void layoutVertices() {
        Random rand = new Random();
        int gridSize = 100; // Espaçamento mínimo entre os vértices
        int maxAttempts = 100; // Número máximo de tentativas de layout

        for (Vertex vertex : vertices.values()) {
            int attemptCount = 0;
            boolean positioned = false;
            while (!positioned && attemptCount < maxAttempts) {
                int x = rand.nextInt(PANEL_WIDTH - 2 * VERTEX_RADIUS);
                int y = rand.nextInt(PANEL_HEIGHT - 2 * VERTEX_RADIUS);
                vertex.setX(x);
                vertex.setY(y);

                // Check if this position overlaps with any existing vertex
                positioned = true;
                for (Vertex other : vertices.values()) {
                    if (other != vertex && Math.abs(other.getX() - x) < gridSize && Math.abs(other.getY() - y) < gridSize) {
                        positioned = false;
                        break;
                    }
                }

                attemptCount++;
            }
        }
    }

    private void initializeGraph() {
        String[] cities = {
            "Sao Paulo", "Santos", "Sao Jose dos Campos", "Sorocaba", "Campinas",
            "Piracicaba", "Araraquara", "Riberao Preto", "Sao Jose do Rio Preto",
            "Bauru", "Marilia", "Presidente Prudente", "Araçatuba"
        };

        for (String city : cities) {
            Vertex newVertex = new Vertex(vertexCount++, city);
            vertices.put(newVertex.getId(), newVertex);
        }

        addEdge("Sao Paulo", "Santos", 85);
        addEdge("Sao Paulo", "Sao Jose dos Campos", 91);
        addEdge("Sao Paulo", "Sorocaba", 101);
        addEdge("Sao Paulo", "Campinas", 92);
        addEdge("Santos", "Sao Paulo", 85);
        addEdge("Sao Jose dos Campos", "Sao Paulo", 91);
        addEdge("Sorocaba", "Bauru", 244);
        addEdge("Sorocaba", "Presidente Prudente", 472);
        addEdge("Sorocaba", "Sao Paulo", 101);
        addEdge("Campinas", "Sao Paulo", 92);
        addEdge("Campinas", "Piracicaba", 72);
        addEdge("Campinas", "Araraquara", 185);
        addEdge("Campinas", "Riberao Preto", 222);
        addEdge("Piracicaba", "Campinas", 72);
        addEdge("Araraquara", "Campinas", 185);
        addEdge("Araraquara", "Sao Jose do Rio Preto", 168);
        addEdge("Riberao Preto", "Campinas", 222);
        addEdge("Sao Jose do Rio Preto", "Araraquara", 185);
        addEdge("Bauru", "Marilia", 106);
        addEdge("Bauru", "Sorocaba", 244);
        addEdge("Bauru", "Araçatuba", 191);
        addEdge("Marilia", "Bauru", 106);
        addEdge("Presidente Prudente", "Sorocaba", 472);
        addEdge("Araçatuba", "Bauru", 191);

        layoutVertices();
        graphPanel.repaint();
    }

    private void addEdge(String fromVertexName, String toVertexName, int distance) {
        Vertex fromVertex = null;
        Vertex toVertex = null;

        for (Vertex vertex : vertices.values()) {
            if (vertex.getName().equalsIgnoreCase(fromVertexName)) {
                fromVertex = vertex;
            }
            if (vertex.getName().equalsIgnoreCase(toVertexName)) {
                toVertex = vertex;
            }
        }

        if (fromVertex != null && toVertex != null) {
            fromVertex.addEdge(toVertex.getId(), distance);
            toVertex.addEdge(fromVertex.getId(), distance); // Assuming undirected graph
        } else {
            JOptionPane.showMessageDialog(this, "Vertices not found.");
        }
    }

    private void findShortestPath() {
        String sourceName = sourceField.getText().trim();
        String destinationName = destinationField.getText().trim();

        if (sourceName.isEmpty() || destinationName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both source and destination.");
            return;
        }

        Vertex sourceVertex = null;
        Vertex destinationVertex = null;

        for (Vertex vertex : vertices.values()) {
            if (vertex.getName().equalsIgnoreCase(sourceName)) {
                sourceVertex = vertex;
            }
            if (vertex.getName().equalsIgnoreCase(destinationName)) {
                destinationVertex = vertex;
            }
        }

        if (sourceVertex == null || destinationVertex == null) {
            JOptionPane.showMessageDialog(this, "Source or Destination vertex not found.");
            return;
        }

        dijkstraPath = dijkstra(sourceVertex, destinationVertex);
        if (dijkstraPath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No path found between the given vertices.");
        }
        graphPanel.repaint();
    }

    private List<Edge> dijkstra(Vertex source, Vertex destination) {
        Map<Vertex, Integer> distances = new HashMap<>();
        Map<Vertex, Vertex> previous = new HashMap<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        List<Edge> path = new ArrayList<>();

        for (Vertex vertex : vertices.values()) {
            distances.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }

        distances.put(source, 0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();

            if (current.equals(destination)) {
                break;
            }

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = vertices.get(edge.getToVertexId());
                int newDist = distances.get(current) + edge.getDistance();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        Vertex step = destination;
        while (previous.get(step) != null) {
            Vertex prev = previous.get(step);
            for (Edge edge : prev.getEdges()) {
                if (edge.getToVertexId() == step.getId()) {
                    path.add(edge);
                    break;
                }
            }
            step = prev;
        }

        Collections.reverse(path); // Reverse the path to start from the source
        return path;
    }

    private class Vertex {
        private int id;
        private String name;
        private List<Edge> edges;
        private int x;
        private int y;

        public Vertex(int id, String name) {
            this.id = id;
            this.name = name;
            this.edges = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void addEdge(int toVertexId, int distance) {
            edges.add(new Edge(toVertexId, distance));
        }

        public void removeEdgeTo(int toVertexId) {
            edges.removeIf(edge -> edge.getToVertexId() == toVertexId);
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

    private class Edge {
        private int toVertexId;
        private int distance;
        private Color color;

        public Edge(int toVertexId, int distance) {
            this.toVertexId = toVertexId;
            this.distance = distance;
            this.color = new Color(223, 124, 135, EDGE_COLOR_ALPHA);
        }

        public int getToVertexId() {
            return toVertexId;
        }

        public int getDistance() {
            return distance;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    private class GraphPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Desenha as arestas primeiro para garantir que os vértices fiquem sobre elas
            for (Vertex vertex : vertices.values()) {
                int startX = vertex.getX();
                int startY = vertex.getY();

                for (Edge edge : vertex.getEdges()) {
                    Vertex toVertex = vertices.get(edge.getToVertexId());
                    if (toVertex != null) {
                        int endX = toVertex.getX();
                        int endY = toVertex.getY();

                        if (dijkstraPath != null && dijkstraPath.contains(edge)) {
                            g.setColor(Color.BLUE);
                        } else {
                            g.setColor(edge.getColor());
                        }

                        g.drawLine(startX, startY, endX, endY);
                        g.drawString(String.valueOf(edge.getDistance()), (startX + endX) / 2, (startY + endY) / 2);
                    }
                }
            }

            // Desenha os vértices
            for (Vertex vertex : vertices.values()) {
                int x = vertex.getX();
                int y = vertex.getY();

                g.setColor(new Color(167, 171, 221));
                g.fillOval(x - VERTEX_RADIUS, y - VERTEX_RADIUS, 2 * VERTEX_RADIUS, 2 * VERTEX_RADIUS);
                g.setColor(Color.BLACK);
                g.drawString(vertex.getName(), x - 10, y);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GraphEditor();
            }
        });
    }
}

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
    private JTextField vertexNameField;
    private JTextField connectToField;
    private JTextField distanceField;
    private Map<Integer, Vertex> vertices;
    private int vertexCount;
    private GraphPanel graphPanel;

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

        vertices = new HashMap<>();
        vertexCount = 0;

        graphPanel = new GraphPanel();
        add(panel, BorderLayout.NORTH);
        add(graphPanel, BorderLayout.CENTER);

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

        graphPanel.repaint();

        JOptionPane.showMessageDialog(this, "Vertex added: " + vertexName);
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
//            this.color = getRandomColor(); // Gera uma cor aleatória para cada aresta
            this.color = new Color(223, 124, 135);
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

        private Color getRandomColor() {
            Random rand = new Random();
            float r = rand.nextInt();
            float g = rand.nextInt();
            float b = rand.nextInt();
            return new Color(r, g, b, EDGE_COLOR_ALPHA);
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

                        g.setColor(edge.getColor());
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
                g.setColor(Color.WHITE);
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

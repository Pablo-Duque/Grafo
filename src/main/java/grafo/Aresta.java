
package grafo;

public class Aresta {
    private String origem;
    private String destino;
    private float peso;

    public Aresta(String origem, String destino, float peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}

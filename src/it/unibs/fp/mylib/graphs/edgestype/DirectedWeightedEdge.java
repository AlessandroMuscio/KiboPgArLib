package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

/**
 * La classe <strong>DirectedWeightedEdge</strong> permette di creare un arco
 * direzionale pesato generico specificando a che tipo di nodi si collega grazie
 * a <strong>N</strong>
 * 
 * @author Alessandro Muscio
 * @see DirectedEdge
 * @version 1.0
 */
public class DirectedWeightedEdge<N extends DefaultNode> extends DirectedEdge<N> {
  /**
   * Serve per verificare che due pesi siano uguali
   */
  private static final double EPSILON = 1e-30;
  /**
   * Rappresenta il <strong>peso</strong> dell'arco
   */
  private double weight;

  /**
   * Crea un oggetto della classe <strong>DirectedWeightedEdge</strong>
   * specificandone i due nodi estremi dell'arco e il peso
   * 
   * @param from_node Indica uno dei due nodi dell'<em>DirectedWeightedEdge</em>
   * @param to_node   Indica l'altro nodo dell'<em>DirectedWeightedEdge</em>
   * @param weight    Indica il peso dell'<em>DirectedWeightedEdge</em>
   */
  public DirectedWeightedEdge(N from_node, N to_node, double weight) {
    super(from_node, to_node);
    this.weight = weight;
  }

  /**
   * Restituisce il <strong>peso</strong> di questo <em>DirectedWeightedEdge</em>
   * 
   * @return Un <code>double</code> rappresentante il <strong>peso</strong>
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Imposta il <strong>peso</strong> di questo <em>DirectedWeightedEdge</em>
   * 
   * @param weight Valore da assegnare al <strong>peso</strong>
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * Verifica se <strong>questo DirectedWeightedEdge</strong> e
   * <strong>obj</strong> sono uguali
   * 
   * @param obj Indica l'oggetto da confrontare con <strong>questo
   *            DirectedWeightedEdge</strong>
   * @return Un <code>boolean</code> che rappresenta se i due oggetti sono uguali
   *         o no
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DirectedWeightedEdge) {
      DirectedWeightedEdge<?> edge_obj = (DirectedWeightedEdge<?>) obj;

      if (getFromNode().equals(edge_obj.getFromNode()) && getToNode().equals(edge_obj.getToNode())
          && (Math.abs(weight - edge_obj.weight)) < EPSILON)
        return true;
    }

    return false;
  }

  /**
   * Restituisce una rappresentazione in forma leggibile di un oggetto
   * <strong>DirectedWeightedEdge</strong>
   * 
   * @return Una <code>String</code> che rappresenta un
   *         <strong>DirectedWeightedEdge</strong>
   */
  @Override
  public String toString() {
    return "DirectedWeightedEdge: { " + getFromNode().toString() + ", " + weight + ", " + getToNode().toString() + "}";
  }
}

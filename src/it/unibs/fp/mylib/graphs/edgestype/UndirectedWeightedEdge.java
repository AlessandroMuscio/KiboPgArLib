package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

/**
 * La classe <strong>UndirectedWeightedEdge</strong> permette di creare un arco
 * non direzionale pesato generico specificando a che tipo di nodi si collega
 * grazie a <strong>N</strong>
 * 
 * @author Alessandro Muscio
 * @see UndirectedEdge
 * @version 1.0
 */
public class UndirectedWeightedEdge<N extends DefaultNode> extends UndirectedEdge<N> {
  /**
   * Serve per verificare che due pesi siano uguali
   */
  private static final double EPSILON = 1e-30;
  /**
   * Rappresenta il <strong>peso</strong> dell'arco
   */
  private double weight;

  /**
   * Crea un oggetto della classe <strong>UndirectedWeightedEdge</strong>
   * specificandone i due nodi estremi dell'arco e il peso
   * 
   * @param first_node  Indica uno dei due nodi
   *                    dell'<em>UndirectedWeightedEdge</em>
   * @param second_node Indica l'altro nodo dell'<em>UndirectedWeightedEdge</em>
   * @param weight      Indica il peso dell'<em>UndirectedWeightedEdge</em>
   */
  public UndirectedWeightedEdge(N first_node, N second_node, double weight) {
    super(first_node, second_node);
    this.weight = weight;
  }

  /**
   * Restituisce il <strong>peso</strong> di questo
   * <em>UndirectedWeightedEdge</em>
   * 
   * @return Un <code>double</code> rappresentante il <strong>peso</strong>
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Imposta il <strong>peso</strong> di questo <em>UndirectedWeightedEdge</em>
   * 
   * @param weight Valore da assegnare al <strong>peso</strong>
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * Verifica se <strong>questo UndirectedWeightedEdge</strong> e
   * <strong>obj</strong> sono uguali
   * 
   * @param obj Indica l'oggetto da confrontare con <strong>questo
   *            UndirectedWeightedEdge</strong>
   * @return Un <code>boolean</code> che rappresenta se i due oggetti sono uguali
   *         o no
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof UndirectedWeightedEdge) {
      UndirectedWeightedEdge<?> edge_obj = (UndirectedWeightedEdge<?>) obj;

      if (getFirstNode().equals(edge_obj.getFirstNode()) && getSecondNode().equals(edge_obj.getSecondNode())
          && (Math.abs(weight - edge_obj.weight)) < EPSILON)
        return true;
    }

    return false;
  }

  /**
   * Restituisce una rappresentazione in forma leggibile di un oggetto
   * <strong>UndirectedWeightedEdge</strong>
   * 
   * @return Una <code>String</code> che rappresenta un
   *         <strong>UndirectedWeightedEdge</strong>
   */
  @Override
  public String toString() {
    return "UndirectedWeightedEdge: { " + getFirstNode().toString() + ", " + weight + ", " + getSecondNode().toString()
        + "}";
  }
}

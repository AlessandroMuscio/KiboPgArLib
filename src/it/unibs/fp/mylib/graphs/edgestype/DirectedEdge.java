package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

/**
 * La classe <strong>DirectedEdge</strong> permette di creare un arco
 * direzionale generico specificando a che tipo di nodi si collega grazie a
 * <strong>N</strong>
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class DirectedEdge<N extends DefaultNode> {
  /**
   * Rappresenta il <strong>nodo</strong> da cui parte l'arco
   */
  private N from_node;
  /**
   * Rappresenta il <strong>nodo</strong> a cui arriva l'arco
   */
  private N to_node;

  /**
   * Crea un oggetto della classe <strong>DirectedEdge</strong> specificandone i
   * due nodi estremi dell'arco
   * 
   * @param from_node Indica il nodo da cui parte il <em>DirectedEdge</em>
   * @param to_node   Indica il nodo a cui arriva il <em>DirectedEdge</em>
   */
  public DirectedEdge(N from_node, N to_node) {
    this.from_node = from_node;
    this.to_node = to_node;
  }

  /**
   * Restituisce il <strong>nodo</strong> da cui parte il <em>DirectedEdge</em>
   * 
   * @return Un <code>N</code> rappresentante il <strong>nodo</strong> da cui
   *         parte <em>DirectedEdge</em>
   */
  public N getFromNode() {
    return from_node;
  }

  /**
   * Restituisce il <strong>nodo</strong> a cui arriva il <em>DirectedEdge</em>
   * 
   * @return Un <code>N</code> rappresentante il <strong>nodo</strong> da cui
   *         parte <em>DirectedEdge</em>
   */
  public N getToNode() {
    return to_node;
  }

  /**
   * Imposta il <strong>nodo</strong> da cui parte il <em>DirectedEdge</em>
   * 
   * @param from_node Valore da assegnare al <strong>nodo</strong> da cui parte il
   *                  <em>DirectedEdge</em>
   */
  public void setFromNode(N from_node) {
    this.from_node = from_node;
  }

  /**
   * Imposta il <strong>nodo</strong> a cui arriva il <em>DirectedEdge</em>
   * 
   * @param to_node Valore da assegnare al <strong>nodo</strong> a cui arriva il
   *                <em>DirectedEdge</em>
   */
  public void setToNode(N to_node) {
    this.to_node = to_node;
  }

  /**
   * Restituisce un <strong>DirectedEdge</strong> uguale a questo ma di <em>verso
   * opposto</em>
   * 
   * @return Un <code>DirectedEdge</code> rappresentante l'arco di verso opposto a
   *         <em>questo</em>
   */
  public DirectedEdge<N> getInverted() {
    return new DirectedEdge<N>(to_node, from_node);
  }

  /**
   * Inverte il <em>verso</em> di questo <strong>DirectedEdge</strong>
   */
  public void invert() {
    N temp;

    temp = from_node;
    from_node = to_node;
    to_node = temp;
  }

  /**
   * Verifica se <strong>questo DirectedEdge</strong> e <strong>obj</strong> sono
   * uguali
   * 
   * @param obj Indica l'oggetto da confrontare con <strong>questo
   *            DirectedEdge</strong>
   * @return Un <code>boolean</code> che rappresenta se i due oggetti sono uguali
   *         o no
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DirectedEdge) {
      DirectedEdge<?> edge_obj = (DirectedEdge<?>) obj;

      if (from_node.equals(edge_obj.from_node) && to_node.equals(edge_obj.to_node))
        return true;
    }

    return false;
  }

  /**
   * Restituisce una rappresentazione in forma leggibile di un oggetto
   * <strong>DirectedEdge</strong>
   * 
   * @return Una <code>String</code> che rappresenta un
   *         <strong>DirectedEdge</strong>
   */
  @Override
  public String toString() {
    return "Directed Edge: { " + from_node.toString() + ", " + to_node.toString() + "}";
  }
}

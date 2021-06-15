package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

/**
 * La classe <strong>UndirectedEdge</strong> permette di creare un arco non
 * direzionale generico specificando a che tipo di nodi si collega grazie a
 * <strong>N</strong>
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class UndirectedEdge<N extends DefaultNode> {
  /**
   * Rappresenta uno dei due <strong>nodi</strong> dell'arco
   */
  private N first_node;
  /**
   * Rappresenta l'altro <strong>nodo</strong> dell'arco
   */
  private N second_node;

  /**
   * Crea un oggetto della classe <strong>UndirectedEdge</strong> specificandone i
   * due nodi estremi dell'arco
   * 
   * @param first_node  Indica uno dei due nodi dell'<em>UndirectedEdge</em>
   * @param second_node Indica l'altro nodo dell'<em>UndirectedEdge</em>
   */
  public UndirectedEdge(N first_node, N second_node) {
    this.first_node = first_node;
    this.second_node = second_node;
  }

  /**
   * Restituisce uno dei due <strong>nodi</strong> di questo
   * <em>UndirectedEdge</em>
   * 
   * @return Un <code>N</code> rappresentante uno dei due <strong>nodi</strong>
   */
  public N getFirstNode() {
    return first_node;
  }

  /**
   * Restituisce l'altro <strong>nodo</strong> di questo <em>UndirectedEdge</em>
   * 
   * @return Un <code>N</code> rappresentante l'altro <strong>nodo</strong>
   */
  public N getSecondNode() {
    return second_node;
  }

  /**
   * Imposta uno dei due <strong>nodi</strong> di questo <em>UndirectedEdge</em>
   * 
   * @param first_node Valore da assegnare ad uno dei due <strong>nodi</strong>
   */
  public void setFirstNode(N first_node) {
    this.first_node = first_node;
  }

  /**
   * Imposta l'altro <strong>nodo</strong> di questo <em>UndirectedEdge</em>
   * 
   * @param second_node Valore da assegnare all'altro <strong>nodo</strong>
   */
  public void setSecondNode(N second_node) {
    this.second_node = second_node;
  }

  /**
   * Verifica se <strong>questo UndirectedEdge</strong> e <strong>obj</strong>
   * sono uguali
   * 
   * @param obj Indica l'oggetto da confrontare con <strong>questo
   *            UndirectedEdge</strong>
   * @return Un <code>boolean</code> che rappresenta se i due oggetti sono uguali
   *         o no
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof UndirectedEdge) {
      UndirectedEdge<?> edge_obj = (UndirectedEdge<?>) obj;

      if ((first_node.equals(edge_obj.first_node) || first_node.equals(edge_obj.second_node))
          && (second_node.equals(edge_obj.first_node) || second_node.equals(edge_obj.second_node)))
        return true;
    }

    return false;
  }

  /**
   * Restituisce una rappresentazione in forma leggibile di un oggetto
   * <strong>UndirectedEdge</strong>
   * 
   * @return Una <code>String</code> che rappresenta un
   *         <strong>UndirectedEdge</strong>
   */
  @Override
  public String toString() {
    return "UndirectedEdge: { " + first_node.toString() + ", " + second_node.toString() + "}";
  }
}

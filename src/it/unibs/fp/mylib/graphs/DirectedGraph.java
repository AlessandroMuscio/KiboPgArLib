package it.unibs.fp.mylib.graphs;

import java.util.HashSet;
import java.util.Set;

import it.unibs.fp.mylib.graphs.edgestype.DirectedEdge;

/**
 * La classe <strong>DirectedGraph</strong> permette di creare un grafo
 * direzionale generico, specificando il tipo dei nodi con <strong>N</strong>,
 * che dovrà estendere <strong>DefaultNode</strong>, e il tipo degli archi con
 * <strong>V</strong>, che dovrà estendere <strong>DirectedEdge</strong>
 * 
 * @author Alessandro Muscio
 * @see Graph
 * @see DefaultNode
 * @see DirectedEdge
 * @version 1.0
 */
public class DirectedGraph<N extends DefaultNode, V extends DirectedEdge<N>> extends Graph<N, V> {
  /**
   * Crea un oggetto della classe <strong>DirectedGraph</strong> specificandone i
   * nodi e gli archi
   * 
   * @param nodes Indica l'insieme dei <strong>nodi</strong>
   * @param edges Indica l'insieme degli <strong>archi</strong>
   */
  public DirectedGraph(Set<N> nodes, Set<V> edges) {
    super(nodes, edges);
  }

  /**
   * Crea un oggetto della classe <strong>DirectedGraph</strong> inizializzando i
   * nodi e gli archi come due insiemi vuoti
   */
  public DirectedGraph() {
    super();
  }

  /**
   * Restituisce tutti gli <strong>archi</strong> che hanno come nodo di partenza
   * <em>node</em> se <em>from_node</em> è <code>true</code>, altrimenti tutti
   * quelli che lo hanno come nodo di arrivo
   * 
   * @param node      Indica il nodo estremo degli archi cercati
   * @param from_node Indica se <em>node</em> è il nodo di partenza o di arrivo
   * @return Un <code>Set</code> rappresentante tutti gli archi trovati
   */
  public Set<V> getEdgesByNode(N node, boolean from_node) {
    HashSet<V> edges_found = new HashSet<>();

    if (from_node) {
      for (V edge : getAllEdges()) {
        if (edge.getFromNode().equals(node))
          edges_found.add(edge);
      }
    } else {
      for (V edge : getAllEdges()) {
        if (edge.getToNode().equals(node))
          edges_found.add(edge);
      }
    }

    return edges_found;
  }

  /**
   * Restituisce l'<strong>arco</strong> che ha come nodo di partenza
   * <em>from_node</em> e come nodo d'arrivo <em>to_node</em>
   * 
   * @param from_node Il nodo di partenza dell'arco cercato
   * @param to_node   Il nodo d'arrivo dell'arco cercato
   * @return L'arco avente come nodo di partenza <em>from_node</em> e come nodo
   *         d'arrivo <em>to_node</em>
   */
  public V getEdge(N from_node, N to_node) {
    if (from_node.equals(to_node))
      return null;

    DirectedEdge<N> edge_to_find = new DirectedEdge<>(from_node, to_node);

    for (V edge : getAllEdges()) {
      if (edge.equals(edge_to_find))
        return edge;
    }

    return null;
  }
}

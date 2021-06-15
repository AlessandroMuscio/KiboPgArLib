package it.unibs.fp.mylib.graphs;

import java.util.HashSet;
import java.util.Set;

import it.unibs.fp.mylib.graphs.edgestype.UndirectedWeightedEdge;

/**
 * La classe <strong>UndirectedWeightedGraph</strong> permette di creare un
 * grafo non direzionale pesato generico, specificando il tipo dei nodi con
 * <strong>N</strong>, che dovrà estendere <strong>DefaultNode</strong>, e il
 * tipo degli archi con <strong>V</strong>, che dovrà estendere
 * <strong>UndirectedWeightedEdge</strong>
 * 
 * @author Alessandro Muscio
 * @see Graph
 * @see DefaultNode
 * @see UndirectedWeightedEdge
 * @version 1.0
 */
public class UndirectedWeightedGraph<N extends DefaultNode, V extends UndirectedWeightedEdge<N>> extends Graph<N, V> {
  /**
   * Crea un oggetto della classe <strong>UndirectedWeightedGraph</strong>
   * specificandone i nodi e gli archi
   * 
   * @param nodes Indica l'insieme dei <strong>nodi</strong>
   * @param edges Indica l'insieme degli <strong>archi</strong>
   */
  public UndirectedWeightedGraph(Set<N> nodes, Set<V> edges) {
    super(nodes, edges);
  }

  /**
   * Crea un oggetto della classe <strong>UndirectedWeightedGraph</strong>
   * inizializzando i nodi e gli archi come due insiemi vuoti
   */
  public UndirectedWeightedGraph() {
    super();
  }

  /**
   * Restituisce tutti gli <strong>archi</strong> che hanno come uno dei due
   * estremi il nodo passato come parametro
   * 
   * @param node Indica uno dei due estremi degli archi cercati
   * @return Un <code>Set</code> rappresentante tutti gli archi trovati
   */
  public Set<V> getEdgesByNode(N node) {
    HashSet<V> edges_found = new HashSet<>();

    for (V edge : getAllEdges()) {
      if (edge.getFirstNode().equals(node) || edge.getSecondNode().equals(node))
        edges_found.add(edge);
    }

    return edges_found;
  }

  /**
   * Restituisce l'<strong>arco</strong> che ha peso e come estremi i due nodi
   * passati come parametri
   * 
   * @param first_node  Uno dei due nodi estremi dell'arco cercato
   * @param second_node L'altro nodo estremo dell'arco cercato
   * @param weight      Indica il peso dell'arco cercato
   * @return L'arco avente come estremi <em>first_node</em> e <em>second_node</em>
   */
  public V getEdge(N first_node, N second_node, double weight) {
    if (first_node.equals(second_node))
      return null;

    UndirectedWeightedEdge<N> edge_to_find = new UndirectedWeightedEdge<>(first_node, second_node, weight);

    for (V edge : getAllEdges()) {
      if (edge.equals(edge_to_find))
        return edge;
    }

    return null;
  }
}
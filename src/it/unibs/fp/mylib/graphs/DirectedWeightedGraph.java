package it.unibs.fp.mylib.graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.unibs.fp.mylib.graphs.edgestype.DirectedWeightedEdge;

public class DirectedWeightedGraph<N extends DefaultNode, V extends DirectedWeightedEdge<N>> extends Graph<N, V> {
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

  public V getEdge(N from_node, N to_node, double weight) {
    if (from_node.equals(to_node))
      return null;

    DirectedWeightedEdge<N> edge_to_find = new DirectedWeightedEdge<>(from_node, to_node, weight);

    for (V edge : getAllEdges()) {
      if (edge.equals(edge_to_find))
        return edge;
    }

    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DirectedWeightedGraph) {
      DirectedWeightedGraph<?, ?> graph_obj = (DirectedWeightedGraph<?, ?>) obj;

      if (getAllNodes().size() != graph_obj.getAllNodes().size()
          || getAllEdges().size() != graph_obj.getAllEdges().size())
        return false;

      Iterator<N> this_nodes_iterator = getAllNodes().iterator();
      Iterator<?> graph_obj_nodes_iterator = graph_obj.getAllNodes().iterator();

      while (this_nodes_iterator.hasNext()) {
        if (!this_nodes_iterator.next().equals(graph_obj_nodes_iterator.next()))
          return false;
      }

      Iterator<V> this_edges_iterator = getAllEdges().iterator();
      Iterator<?> graph_obj_edges_iterator = graph_obj.getAllEdges().iterator();

      while (this_edges_iterator.hasNext()) {
        if (!this_edges_iterator.next().equals(graph_obj_edges_iterator.next()))
          return false;
      }

      return true;
    }

    return false;
  }
}

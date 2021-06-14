package it.unibs.fp.mylib.graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.unibs.fp.mylib.graphs.edgestype.UndirectedEdge;

public class UndirectedGraph<N extends DefaultNode, V extends UndirectedEdge<N>> extends Graph<N, V> {
  public Set<V> getEdgesByNode(N node) {
    HashSet<V> edges_found = new HashSet<>();

    for (V edge : getAllEdges()) {
      if (edge.getFirstNode().equals(node) || edge.getSecondNode().equals(node))
        edges_found.add(edge);
    }

    return edges_found;
  }

  public V getEdge(N first_node, N second_node) {
    if (first_node.equals(second_node))
      return null;

    for (V edge : getAllEdges()) {
      if ((edge.getFirstNode().equals(first_node) || edge.getFirstNode().equals(second_node))
          && (edge.getSecondNode().equals(first_node) || edge.getSecondNode().equals(second_node)))
        return edge;
    }

    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof UndirectedGraph) {
      UndirectedGraph<?, ?> graph_obj = (UndirectedGraph<?, ?>) obj;

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

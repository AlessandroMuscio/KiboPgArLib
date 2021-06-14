package it.unibs.fp.mylib.Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UndirectedGraph<N extends DefaultNode, V extends UndirectedEdge<N>> implements Graph<N, V> {
  private Set<N> nodes;
  private Set<V> edges;

  public UndirectedGraph(Set<N> nodes, Set<V> edges) {
    this.nodes = nodes;
    this.edges = edges;
  }

  public UndirectedGraph() {
    nodes = new HashSet<>();
    edges = new HashSet<>();
  }

  @Override
  public Set<N> getAllNodes() {
    return nodes;
  }

  @Override
  public boolean containsNode(N node) {
    return nodes.contains(node);
  }

  @Override
  public Set<V> getAllEdges() {
    return edges;
  }

  @Override
  public boolean containsEdge(V edge) {
    return edges.contains(edge);
  }

  @Override
  public boolean addNode(N node) {
    return nodes.add(node);
  }

  @Override
  public boolean removeNode(N node) {
    return nodes.remove(node);
  }

  @Override
  public boolean addEdge(V edge) {
    return edges.add(edge);
  }

  @Override
  public boolean removeEdge(V edge) {
    return edges.remove(edge);
  }

  public Set<V> getEdgesByNode(N node) {
    HashSet<V> edges_found = new HashSet<>();

    for (V edge : edges) {
      if (edge.getFirstNode().equals(node) || edge.getSecondNode().equals(node))
        edges_found.add(edge);
    }

    return edges_found;
  }

  public V getEdge(N first_node, N second_node) {
    for (V edge : edges) {
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

      if (nodes.size() != graph_obj.nodes.size() || edges.size() != graph_obj.edges.size())
        return false;

      Iterator<N> this_nodes_iterator = nodes.iterator();
      Iterator<?> graph_obj_nodes_iterator = graph_obj.nodes.iterator();

      while (this_nodes_iterator.hasNext()) {
        if (!this_nodes_iterator.next().equals(graph_obj_nodes_iterator.next()))
          return false;
      }

      Iterator<V> this_edges_iterator = edges.iterator();
      Iterator<?> graph_obj_edges_iterator = graph_obj.edges.iterator();

      while (this_edges_iterator.hasNext()) {
        if (!this_edges_iterator.next().equals(graph_obj_edges_iterator.next()))
          return false;
      }

      return true;
    }

    return false;
  }

  @Override
  public String toString() {
    String to_string = "Undirected Graph: {\n\tNodes: {\n\t\t";
    Object[] nodes_array = nodes.toArray();
    Object[] edges_array = edges.toArray();

    for (int i = 0; i < nodes_array.length; i++) {
      to_string += nodes_array[i].toString();

      if (i != (nodes_array.length - 1))
        to_string += "\n\t\t";
      else
        to_string += "\n\t},\n\t";
    }

    to_string += "Edges: {\n\t\t";
    for (int i = 0; i < edges_array.length; i++) {
      to_string += edges_array[i].toString();

      if (i != (edges_array.length - 1))
        to_string += "\n\t\t";
      else
        to_string += "\n\t}\n}";
    }

    return to_string;
  }
}

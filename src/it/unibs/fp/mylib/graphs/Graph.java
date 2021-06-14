package it.unibs.fp.mylib.graphs;

import java.util.HashSet;
import java.util.Set;

public class Graph<N extends DefaultNode, V> {
  private Set<N> nodes;
  private Set<V> edges;

  public Graph(Set<N> nodes, Set<V> edges) {
    this.nodes = nodes;
    this.edges = edges;
  }

  public Graph() {
    nodes = new HashSet<>();
    edges = new HashSet<>();
  }

  public Set<N> getAllNodes() {
    return nodes;
  }

  public boolean containsNode(N node) {
    return nodes.contains(node);
  }

  public Set<V> getAllEdges() {
    return edges;
  }

  public boolean containsEdge(V edge) {
    return edges.contains(edge);
  }

  public boolean addNode(N node) {
    return nodes.add(node);
  }

  public boolean removeNode(N node) {
    return nodes.remove(node);
  }

  public boolean addEdge(V edge) {
    return edges.add(edge);
  }

  @Override
  public String toString() {
    String to_string = getClass().getSimpleName() + ": {\n\tNodes: {\n\t\t";
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

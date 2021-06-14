package it.unibs.fp.mylib.Graphs;

import java.util.HashSet;
import java.util.Set;

public class DirectedGraph<N extends DefaultNode, V extends DirectedEdge<N>> implements Graph<N, V> {
  private Set<N> nodes;
  private Set<V> edges;

  public DirectedGraph(Set<N> nodes, Set<V> edges) {
    this.nodes = nodes;
    this.edges = edges;
  }

  public DirectedGraph() {
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

  public Set<V> getEdgesByNode(N node, boolean from_node) {
    HashSet<V> edges_found = new HashSet<>();

    if (from_node) {
      for (V edge : edges) {
        if (edge.getFromNode().equals(node))
          edges_found.add(edge);
      }
    } else {
      for (V edge : edges) {
        if (edge.getToNode().equals(node))
          edges_found.add(edge);
      }
    }

    return edges_found;
  }

  public V getEdge(N from_node, N to_node) {
    for (V edge : edges) {
      if (edge.getFromNode().equals(from_node) && edge.getToNode().equals(to_node))
        return edge;
    }

    return null;
  }
}

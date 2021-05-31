package it.unibs.fp.mylib.Graphs;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph<N, V> implements Graph<N, V> {
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
  public boolean containsEdge(V edge) {
    return edges.contains(edge);
  }

  @Override
  public Set<V> getAllEdges() {
    return edges;
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
}

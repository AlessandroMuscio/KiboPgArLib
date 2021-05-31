package it.unibs.fp.mylib.Graphs;

import java.util.Set;

public interface Graph<N, V> {
  public Set<N> getAllNodes();

  public boolean containsNode(N node);

  public boolean containsEdge(V edge);

  public Set<V> getAllEdges();

  public boolean addNode(N node);

  public boolean removeNode(N node);

  public boolean addEdge(V edge);

  public boolean removeEdge(V edge);
}

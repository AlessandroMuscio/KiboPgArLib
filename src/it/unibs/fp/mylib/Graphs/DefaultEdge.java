package it.unibs.fp.mylib.Graphs;

public class DefaultEdge<N> {
  private N from_node;
  private int weight;
  private N to_node;

  public DefaultEdge(N from_node, int weight, N to_node) {
    this.from_node = from_node;
    this.weight = weight;
    this.to_node = to_node;
  }

  public N getFrom_node() {
    return from_node;
  }

  public int getWeight() {
    return weight;
  }

  public N getTo_node() {
    return to_node;
  }

  public void setFrom_node(N from_node) {
    this.from_node = from_node;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setTo_node(N to_node) {
    this.to_node = to_node;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DefaultEdge) {
      DefaultEdge<?> edge_obj = (DefaultEdge<?>) obj;

      if (from_node.equals(edge_obj.from_node) && weight == edge_obj.weight && to_node.equals(edge_obj.to_node))
        return true;
    }

    return false;
  }
}

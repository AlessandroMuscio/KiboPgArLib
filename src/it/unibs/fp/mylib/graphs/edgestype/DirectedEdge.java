package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

public class DirectedEdge<N extends DefaultNode> {
  private N from_node;
  private N to_node;

  public DirectedEdge(N from_node, N to_node) {
    this.from_node = from_node;
    this.to_node = to_node;
  }

  public N getFromNode() {
    return from_node;
  }

  public N getToNode() {
    return to_node;
  }

  public void setFromNode(N from_node) {
    this.from_node = from_node;
  }

  public void setToNode(N to_node) {
    this.to_node = to_node;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DirectedEdge) {
      DirectedEdge<?> edge_obj = (DirectedEdge<?>) obj;

      if (from_node.equals(edge_obj.from_node) && to_node.equals(edge_obj.to_node))
        return true;
    }

    return false;
  }

  public DirectedEdge<N> getInverted() {
    return new DirectedEdge<>(to_node, from_node);
  }

  public void invert() {
    N temp;

    temp = from_node;
    from_node = to_node;
    to_node = temp;
  }

  @Override
  public String toString() {
    return "Directed Edge: { " + from_node.toString() + ", " + to_node.toString() + "}";
  }
}

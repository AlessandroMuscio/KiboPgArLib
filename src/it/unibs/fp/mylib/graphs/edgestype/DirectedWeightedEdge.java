package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

public class DirectedWeightedEdge<N extends DefaultNode> extends DirectedEdge<N> {
  private static final double EPSILON = 1e-30;
  private double weight;

  public DirectedWeightedEdge(N first_node, N second_node, double weight) {
    super(first_node, second_node);
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DirectedWeightedEdge) {
      DirectedWeightedEdge<?> edge_obj = (DirectedWeightedEdge<?>) obj;

      if (getFromNode().equals(edge_obj.getFromNode()) && getToNode().equals(edge_obj.getToNode())
          && (Math.abs(weight - edge_obj.weight)) < EPSILON)
        return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return "DirectedWeightedEdge: { " + getFromNode().toString() + ", " + weight + ", " + getToNode().toString() + "}";
  }
}

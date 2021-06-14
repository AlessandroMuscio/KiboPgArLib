package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

public class UndirectedWeightedEdge<N extends DefaultNode> extends UndirectedEdge<N> {
  private static final double EPSILON = .000000000000000000000000000000000000000000001;
  private double weight;

  public UndirectedWeightedEdge(N first_node, N second_node, double weight) {
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
    if (obj instanceof UndirectedWeightedEdge) {
      UndirectedWeightedEdge<?> edge_obj = (UndirectedWeightedEdge<?>) obj;

      if (getFirstNode().equals(edge_obj.getFirstNode()) && getSecondNode().equals(edge_obj.getSecondNode())
          && (Math.abs(weight - edge_obj.weight)) < EPSILON)
        return true;
    }

    return false;
  }
}

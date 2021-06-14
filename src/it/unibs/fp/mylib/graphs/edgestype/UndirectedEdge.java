package it.unibs.fp.mylib.graphs.edgestype;

import it.unibs.fp.mylib.graphs.DefaultNode;

public class UndirectedEdge<N extends DefaultNode> {
  private N first_node;
  private N second_node;

  public UndirectedEdge(N first_node, N second_node) {
    this.first_node = first_node;
    this.second_node = second_node;
  }

  public N getFirstNode() {
    return first_node;
  }

  public N getSecondNode() {
    return second_node;
  }

  public void setFirstNode(N first_node) {
    this.first_node = first_node;
  }

  public void setSecondNode(N second_node) {
    this.second_node = second_node;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof UndirectedEdge) {
      UndirectedEdge<?> edge_obj = (UndirectedEdge<?>) obj;

      if ((first_node.equals(edge_obj.first_node) || first_node.equals(edge_obj.second_node))
          && (second_node.equals(edge_obj.first_node) || second_node.equals(edge_obj.second_node)))
        return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return "UndirectedEdge: { " + first_node.toString() + ", " + second_node.toString() + "}";
  }
}

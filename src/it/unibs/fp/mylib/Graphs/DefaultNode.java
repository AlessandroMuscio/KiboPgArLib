package it.unibs.fp.mylib.Graphs;

public class DefaultNode {
  private int id;

  public DefaultNode(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DefaultNode) {
      DefaultNode node_obj = (DefaultNode) obj;

      if (id == node_obj.id)
        return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return String.format("Node: {Id: %d}", id);
  }
}

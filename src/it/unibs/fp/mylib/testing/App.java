package it.unibs.fp.mylib.testing;

import it.unibs.fp.mylib.graphs.DefaultNode;
import it.unibs.fp.mylib.graphs.Graph;
import it.unibs.fp.mylib.graphs.UndirectedGraph;
import it.unibs.fp.mylib.graphs.edgestype.UndirectedEdge;

public class App {
  public static void main(String[] args) {
    UndirectedGraph<DefaultNode, UndirectedEdge<DefaultNode>> graph = new UndirectedGraph<>();

    if (graph instanceof Graph) {
      System.out.println("Yes");
    } else {
      System.out.println("Nope");
    }
  }
}

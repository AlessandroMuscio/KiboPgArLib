package it.unibs.fp.mylib.graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * La classe <strong>Graph</strong> permette di creare un grafo generico,
 * specificando il tipo dei nodi con <strong>N</strong>, che dovrà estendere
 * <strong>DefaultNode</strong>, e il tipo degli archi con <strong>V</strong>.
 * Sconsiglio di utilizzare questa classe per creare un grafo, ci sono classi
 * più specifiche, scegliere quella più adatta alla vostra situazione
 * 
 * @author Alessandro Muscio
 * @see DefaultNode
 * @version 1.0
 */
public class Graph<N extends DefaultNode, V> {
  /**
   * Rappresenta l'insieme dei <strong>nodi</strong> del grafo
   */
  private Set<N> nodes;
  /**
   * Rappresenta l'insieme degli <strong>archi</strong> del grafo
   */
  private Set<V> edges;

  /**
   * Crea un oggetto della classe <strong>Graph</strong> specificandone i nodi e
   * gli archi
   * 
   * @param nodes Indica l'insieme dei <strong>nodi</strong>
   * @param edges Indica l'insieme degli <strong>archi</strong>
   */
  public Graph(Set<N> nodes, Set<V> edges) {
    this.nodes = nodes;
    this.edges = edges;
  }

  /**
   * Crea un oggetto della classe <strong>Graph</strong> inizializzando i nodi e
   * gli archi come due insiemi vuoti
   */
  public Graph() {
    nodes = new HashSet<>();
    edges = new HashSet<>();
  }

  /**
   * Restituisce tutti i nodi che appartengono a questo <em>Graph</em>
   * 
   * @return Un <code>Set</code> rappresentante tutti i nodi
   */
  public Set<N> getAllNodes() {
    return nodes;
  }

  /**
   * Verifica se un <strong>nodo</strong> appartiene o meno a questo
   * <em>Graph</em>
   * 
   * @param node Indica il nodo di cui bisogna verificare l'appartenenza
   * @return Un <code>boolean</code> che indica se il nodo appartiene o no al
   *         <em>Graph</em>
   */
  public boolean containsNode(N node) {
    return nodes.contains(node);
  }

  /**
   * Restituisce tutti gli archi che appartengono a questo <em>Graph</em>
   * 
   * @return Un <code>Set</code> rappresentante tutti gli archi
   */
  public Set<V> getAllEdges() {
    return edges;
  }

  /**
   * Verifica se un <strong>arco</strong> appartiene o meno a questo
   * <em>Graph</em>
   * 
   * @param edge Indica l'arco di cui bisogna verificare l'appartenenza
   * @return Un <code>boolean</code> che indica se l'arco appartiene o no al
   *         <em>Graph</em>
   */
  public boolean containsEdge(V edge) {
    return edges.contains(edge);
  }

  /**
   * Aggiunge un qualsiasi <strong>nodo</strong> al <em>Graph</em>
   * 
   * @param node Il nodo da aggiungere
   * @return Un <code>boolean</code> che indica se l'aggiunta è riuscita o meno
   */
  public boolean addNode(N node) {
    return nodes.add(node);
  }

  /**
   * Rimuove un qualsiasi <strong>nodo</strong> dal <em>Graph</em>
   * 
   * @param node Il nodo da rimuovere
   * @return Un <code>boolean</code> che indica se la rimozione è riuscita o meno
   */
  public boolean removeNode(N node) {
    return nodes.remove(node);
  }

  /**
   * Aggiunge un qualsiasi <strong>arco</strong> al <em>Graph</em>
   * 
   * @param edge L'arco da aggiungere
   * @return Un <code>boolean</code> che indica se l'aggiunta è riuscita o meno
   */
  public boolean addEdge(V edge) {
    return edges.add(edge);
  }

  /**
   * Rimuove un qualsiasi <strong>arco</strong> dal <em>Graph</em>
   * 
   * @param node L'arco da rimuovere
   * @return Un <code>boolean</code> che indica se la rimozione è riuscita o meno
   */
  public boolean removeEdge(V edge) {
    return edges.remove(edge);
  }

  /**
   * Verifica se <strong>questo Graph</strong> e <strong>obj</strong> sono uguali
   * 
   * @param obj Indica l'oggetto da confrontare con <strong>questo Graph</strong>
   * @return Un <code>boolean</code> che rappresenta se i due oggetti sono uguali
   *         o no
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Graph) {
      Graph<?, ?> graph_obj = (Graph<?, ?>) obj;

      if (nodes.size() == graph_obj.nodes.size() && edges.size() == graph_obj.edges.size()) {
        Iterator<N> this_nodes_iterator = nodes.iterator();
        Iterator<?> graph_obj_nodes_iterator = graph_obj.nodes.iterator();

        while (this_nodes_iterator.hasNext()) {
          if (!this_nodes_iterator.next().equals(graph_obj_nodes_iterator.next()))
            return false;
        }

        Iterator<V> this_egdes_iterator = edges.iterator();
        Iterator<?> graph_obj_edges_iterator = graph_obj.edges.iterator();

        while (this_egdes_iterator.hasNext()) {
          if (!this_egdes_iterator.next().equals(graph_obj_edges_iterator.next()))
            return false;
        }

        return true;
      }
    }

    return false;
  }

  /**
   * Restituisce una rappresentazione in forma leggibile di un oggetto
   * <strong>Graph</strong>
   * 
   * @return Una <code>String</code> che rappresenta un <strong>Graph</strong>
   */
  @Override
  public String toString() {
    String to_string = getClass().getSimpleName() + ": {\n\tNodes: {\n\t\t";
    Object[] nodes_array = nodes.toArray();
    Object[] edges_array = edges.toArray();

    for (int i = 0; i < nodes_array.length; i++) {
      to_string += nodes_array[i].toString();

      if (i != (nodes_array.length - 1))
        to_string += "\n\t\t";
      else
        to_string += "\n\t},\n\t";
    }

    to_string += "Edges: {\n\t\t";
    for (int i = 0; i < edges_array.length; i++) {
      to_string += edges_array[i].toString();

      if (i != (edges_array.length - 1))
        to_string += "\n\t\t";
      else
        to_string += "\n\t}\n}";
    }

    return to_string;
  }
}

package it.unibs.fp.mylib.graphs;

/**
 * La classe <strong>DefaultNode</strong> permette di creare un nodo generico da
 * inserire in un grafo
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class DefaultNode {
  /**
   * Rappresenta l'<strong>id</strong> del nodo
   */
  private int id;

  /**
   * Crea un oggetto della classe <strong>DefaultNode</strong> specificandone l'id
   * 
   * @param id Indica l'id del <em>DefaultNode</em>
   */
  public DefaultNode(int id) {
    this.id = id;
  }

  /**
   * Restituisce l'<strong>id</strong> di questo <em>DefaultNode</em>
   * 
   * @return Un <code>int</code> rappresentante l'<strong>id</strong>
   */
  public int getId() {
    return id;
  }

  /**
   * Imposta l'<strong>id</strong> di questo <em>DefaultNode</em>
   * 
   * @param id Valore da assegnare all'<strong>id</strong>
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Verifica se <strong>questo DefaultNode</strong> e <strong>obj</strong> sono
   * uguali
   * 
   * @param obj Indica l'oggetto da confrontare con <strong>questo
   *            DefaultNode</strong>
   * @return Un <code>boolean</code> che rappresenta se i due oggetti sono uguali
   *         o no
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DefaultNode) {
      DefaultNode node_obj = (DefaultNode) obj;

      if (id == node_obj.id)
        return true;
    }

    return false;
  }

  /**
   * Restituisce una rappresentazione in forma leggibile di un oggetto
   * <strong>DefaultNode</strong>
   * 
   * @return Una <code>String</code> che rappresenta un
   *         <strong>DefaultNode</strong>
   */
  @Override
  public String toString() {
    return String.format("Node: {Id: %d}", id);
  }
}

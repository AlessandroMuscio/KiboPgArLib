package it.unibs.fp.mylib;

/**
 * La classe <strong>FormuleNote</strong> permette di eseguire alcune formule
 * che possono spesso tornare utili
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class FormuleNote {

  /**
   * Trova l'<strong>MCD</strong> tra due numeri
   * 
   * @param a Indica il primo numero di cui calcolare l'MCD
   * @param b Indica il secondo numero di cui calcolare l'MCD
   * @return Un <code>int</code> rappresentante l'MCD tra a e b
   */
  public static int MCD(int a, int b) {
    while (a != 0 && b != 0) {
      if (a > b)
        a %= b;
      else
        b %= a;
    }

    return a == 0 ? b : a;
  }

  /**
   * Trova l'<strong>MCD</strong> tra diversi numeri
   * 
   * @param valori Indica i numeri di cui si vuole trovare l'<strong>MCD</strong>
   * @return Un <code>int</code> rappresentante l'MCD tra i diversi numeri
   */
  public static int MCD(int[] valori) {
    if (valori == null || valori.length == 0)
      return -1;

    int mcd = valori[0];

    for (int i = 1; i < valori.length; i++)
      mcd = MCD(mcd, valori[i]);

    return mcd;
  }

  /**
   * Trova l'<strong>MCM</strong> tra due numeri
   * 
   * @param a Indica il primo numero di cui calcolare l'MCM
   * @param b Indica il secondo numero di cui calcolare l'MCM
   * @return Un <code>int</code> rappresentante l'MCM tra a e b
   */
  public static int MCM(int a, int b) {
    int mcd = MCD(a, b);

    return (a * b) / mcd;
  }

  /**
   * Trova l'<strong>MCM</strong> tra diversi numeri
   * 
   * @param valori Indica i numeri di cui si vuole trovare l'<strong>MCM</strong>
   * @return Un <code>int</code> rappresentante l'MCM tra i diversi numeri
   */
  public static int MCM(int[] valori) {
    if (valori == null || valori.length == 0)
      return -1;

    int mcm = valori[0];

    for (int i = 1; i < valori.length; i++)
      mcm = MCM(mcm, valori[i]);

    return mcm;
  }
}

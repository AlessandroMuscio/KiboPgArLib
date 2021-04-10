package it.unibs.fp.mylib;

public class BelleStringhe {

  private final static String SPAZIO = " ";
  private final static String CORNICE = "---------------------------------------------------";
  private final static String ACAPO = "\n";

  public static String incornicia(String s) {
    StringBuffer res = new StringBuffer();

    res.append(CORNICE + ACAPO + s + ACAPO + CORNICE + ACAPO);
    return res.toString();
  }

  public static String incolonna(String s, int larghezza) {
    StringBuffer res = new StringBuffer(larghezza);
    int numCharDaStampare = Math.min(larghezza, s.length());

    res.append(s.substring(0, numCharDaStampare));
    for (int i = s.length() + 1; i <= larghezza; i++)
      res.append(SPAZIO);

    return res.toString();
  }

  public static String centrata(String s, int larghezza) {
    StringBuffer res = new StringBuffer(larghezza);

    if (larghezza <= s.length())
      res.append(s.substring(larghezza));
    else {
      int spaziPrima = (larghezza - s.length()) / 2;
      int spaziDopo = larghezza - spaziPrima - s.length();

      for (int i = 1; i <= spaziPrima; i++) {
        res.append(SPAZIO);
      }
      res.append(s);

      for (int i = 1; i <= spaziDopo; i++)
        res.append(SPAZIO);
    }

    return res.toString();
  }

  public static String ripetiChar(char elemento, int larghezza) {
    StringBuffer result = new StringBuffer(larghezza);

    for (int i = 0; i < larghezza; i++) {
      result.append(elemento);
    }

    return result.toString();

  }

  public static String rigaIsolata(String daIsolare) {
    StringBuffer result = new StringBuffer();

    result.append(ACAPO);
    result.append(daIsolare);
    result.append(ACAPO);

    return result.toString();
  }
}

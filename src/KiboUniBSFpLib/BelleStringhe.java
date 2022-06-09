package KiboUniBSFpLib;

public class BelleStringhe {
  private final static String SPAZIO = " ";
  private final static String CORNICE = "---------------------------------------------------";
  private final static String A_CAPO = "\n";

  public static String incornicia(String s) {
    StringBuffer res = new StringBuffer();

    res.append(CORNICE + A_CAPO + s + A_CAPO + CORNICE + A_CAPO);
    return res.toString();
  }

  public static String incolonna(String s, int larghezza) {
    StringBuffer res = new StringBuffer(larghezza);
    int numCharDaStampare = Math.min(larghezza, s.length());

    res.append(s.substring(0, numCharDaStampare));
    /*for (int i = s.length() + 1; i <= larghezza; i++)
      res.append(SPAZIO);*/
    res.append(SPAZIO.repeat(Math.max(0, larghezza - (s.length() + 1) + 1)));

    return res.toString();
  }

  public static String centrata(String s, int larghezza) {
    StringBuffer res = new StringBuffer(larghezza);

    if (larghezza <= s.length())
      res.append(s.substring(larghezza));
    else {
      int spaziPrima = (larghezza - s.length()) / 2;
      int spaziDopo = larghezza - spaziPrima - s.length();

      res.append(SPAZIO.repeat(spaziPrima));

      res.append(s);

      res.append(SPAZIO.repeat(Math.max(0, spaziDopo)));
    }

    return res.toString();
  }

  public static String ripetiChar(char elemento, int larghezza) {
    StringBuffer result = new StringBuffer(larghezza);

    result.append(String.valueOf(elemento).repeat(Math.max(0, larghezza)));

    return result.toString();
  }

  public static String rigaIsolata(String daIsolare) {
    StringBuffer result = new StringBuffer();

    result.append(A_CAPO);
    result.append(daIsolare);
    result.append(A_CAPO);

    return result.toString();
  }
}

package it.unibs.fp.mylib;

public class FormuleNote {

  public static int MCD(int a, int b) {
    while (a != 0 && b != 0) {
      if (a > b)
        a %= b;
      else
        b %= a;
    }

    return a == 0 ? b : a;
  }

  public static int MCD(int[] valori) {
    if (valori == null || valori.length == 0)
      return -1;

    int mcd = valori[0];

    for (int i = 1; i < valori.length; i++)
      mcd = MCD(mcd, valori[i]);

    return mcd;
  }

  public static int MCM(int a, int b) {
    int mcd = MCD(a, b);

    return (a * b) / mcd;
  }

  public static int MCM(int[] valori) {
    if (valori == null || valori.length == 0)
      return -1;

    int mcm = valori[0];

    for (int i = 1; i < valori.length; i++)
      mcm = MCM(mcm, valori[i]);

    return mcm;
  }

  public static int minOrMax(double a, double b) {
    if (a < b)
      return 1;
    else if (a > b)
      return -1;
    else
      return 0;
  }
}

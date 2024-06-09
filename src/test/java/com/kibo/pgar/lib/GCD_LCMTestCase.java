package com.kibo.pgar.lib;

public class GCD_LCMTestCase {
  private final int a;
  private final int b;
  private final int gcd;
  private final int lcm;

  public GCD_LCMTestCase(int a, int b, int gcd, int lcm) {
    this.a = a;
    this.b = b;
    this.gcd = gcd;
    this.lcm = lcm;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }

  public int getGCD() {
    return gcd;
  }

  public int getLCM() {
    return lcm;
  }
}

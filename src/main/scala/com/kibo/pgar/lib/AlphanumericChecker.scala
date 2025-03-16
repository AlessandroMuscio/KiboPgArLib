package com.kibo.pgar.lib

object AlphanumericChecker {
  private val ALPHANUMERIC_CHARACTERS: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

  def hasAlphanumericCharacters(message: String): Boolean = {
    message.forall(c => ALPHANUMERIC_CHARACTERS.contains(c))
  }
}

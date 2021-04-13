## MyUniBSFpLib

Questa è la libreria dell'UniBS modificata da me con metodi che possono tornare utili, e rimossi metodi inutili.<br>Modifiche attuali:

- BelleStringhe.java
  - Aggiornato metodo <code>**incornicia(String s)**</code>
- EstrazioniCasuali.java
  - Aggiunto metodo <code>**estraiDouble(double min, double max)**</code>
  - Aggiunto metodo <code>**estraiBoolean()**</code>
- InputDati.java
  - Aggiornati messaggi di errore
  - Aggiunto attributo **CARATTERI_ALFANUMERICI**
  - Aggiunto metodo <code>**contieneCaratteriAlfanumerici(String messaggio)**</code>
  - Aggiornato metodo <code>**leggiStringa(String messaggio, boolean alfanumerico)**</code>
  - Aggiornato metodo <code>**leggiStringaNonVuota(String messaggio, boolean alfanumerico)**</code>
  - Aggiornato metodo <code>**leggiChar(String messaggio, String ammissibili)**</code>
  - Rimosso metodo <code>**leggiUpperChar(String messaggio, String ammissibili)**</code>
  - Rimosso metodo <code>**leggiInteroPositivo(String messaggio)**</code>
  - Rimosso metodo <code>**leggiInteroNonNegativo(String messaggio)**</code>
  - Aggiunto metodo <code>**leggiInteroConMassimo(String messaggio, int massimo)**</code>
  - Rinominato metodo da <code>**leggiIntero(String messaggio, int minimo, int massimo)**</code> a <code>**leggiInteroCompreso(String messaggio, int minimo, int massimo)**</code>
  - Aggiunto metodo <code>**leggiDoubleConMassimo(String messaggio, double massimo)**</code>
  - Aggiunto metodo <code>**leggiDoubleCompreso(String messaggio, double minimo, double massimo)**</code>
  - Rinominato metodo da <code>**yesOrNo(String messaggio)**</code> a <code>**leggiSiONo(String messaggio)**</code> e modificato
- MyMenu.java
  - Aggiunto metodo <code>**pulisciConsole()**</code>
  - Aggiunto metodo <code>**aspetta(int millisecondi)**</code>
  - Aggiunto metodo <code>**messaggioCaricamento(String messaggio)**</code>
- Rimosso NumeriCasuali.java
- ServizioFile.java
  - Invariato

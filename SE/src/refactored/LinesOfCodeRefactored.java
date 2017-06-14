package refactored;

import java.io.*;

public class LinesOfCodeRefactored {

    /**
     * Die Methode liefert die Anzahl "echter Programmzeilen" in einer
     * Java-Datei.
     * Eine echte Programmzeilee hier ist eine Zeile, auf die keiner der
     * folgenden Punkte zutrifft:
     * (1) Die Zeile ist leer oder beinhaltet nur Leerzeichen oder
     * Tabulatoren.
     * (2) Die Zeile beginnt nach eventuellen Leerzeichen mit einem
     * Zeilenkommentar, gekennzeichnet mit "//".
     * (3) Die Zeile beginnt mit einem Blockkommentar, gekennzeichnet mit "/*".
     * (4) Die Zeile beginnt nach eventuellen Leerzeichen mit dem Ende eines
     * Blockkommentars, gekennzeichnet mit "* /" ohne Abstand dazwischen.
     * (5) Die Zeile ist Teil eines Blockkommentars.
     * Alle anderen Zeilen werden als Programmzeilen verstanden und sollen
     * gezählt werden.
     *
     * @param filename der Dateiname
     * @return die Anzahl echter Programmzeilen in der Datei filename
     */
    public static int countLines(String filename) throws IOException {
        int lineCounter = 0;
        boolean isMultiLineComment = false;
        BufferedReader javaDatei = null;
        //hier wird die Datei analysiert
        try {
            javaDatei = new BufferedReader(new FileReader(filename));
            while (javaDatei.ready()) {
                String currentLine = deleteSpaces(javaDatei.readLine());
                boolean isComment = false;
                if (!currentLine.equals("")) {
                    if(currentLine.indexOf("//") == 0) {
                        isComment = true;
                    } else if(currentLine.indexOf("/*") == 0) {
                        isMultiLineComment = true;
                        isComment = true;
                    } else if(currentLine.indexOf("*/") == 0) {
                        isMultiLineComment = false;
                        isComment = true;
                    }

                    if (!isComment && !isMultiLineComment) {
                        lineCounter++;
                    }
                }
            }
            javaDatei.close();
            return lineCounter;
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (javaDatei != null) {
                    javaDatei.close();
                }
            } catch (Exception e) {
                System.out.printf("Failed to close java file %s\n", e.getMessage());
            }
        }
    }

    /**
     * Entferne Leerzeichen und Tabs aus einem String.
     *
     * @param original Original String mit Leerzeichen und Tabs
     * @return Neuer String ohne Leerzeichen und Tabs
     */
    private static String deleteSpaces(String original) {
        int counter = 0;
        String rest = "";
        if (original.length() == 0) {
            return "";
        }
        while (counter < original.length() && (original.charAt(counter) == '\t' || original.charAt(counter) == ' ')) {
            counter++;
        }
        while (counter < original.length()) {
            rest = rest + original.charAt(counter);
            counter++;
        }

        return rest;
    }
}

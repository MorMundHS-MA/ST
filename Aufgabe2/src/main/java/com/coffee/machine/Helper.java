package com.coffee.machine;

public class Helper {
    private Helper() {

    }

    public static boolean stringEqualsAny(String str,String[] matchTo,boolean ignoreCase)    {
        for(String s : matchTo) {
            if (ignoreCase && s.equalsIgnoreCase(str)) {
                return true;
            } else if(s.equals(str)){
                return true;
            }
        }

        return false;
    }

    /**
     * Formats the list to pretty string list separated by the separator for elements at the start and the final separator
     * for the last word. I.e. a,b,c and d.
     * @param list The list of elements to format.
     * @param finalListSeparator The final separator usually "and" or "or".
     * @param separator The common separator usually ",".
     * @return A formatted String representing the list in a pretty way.
     */
    public static String makePrettyList(String[] list, String finalListSeparator,char separator) {
        if (list.length == 0) {
            return "";
        } else if( list.length == 1) {
            return list[0];
        }

        String formatted = "";
        for (int i = 0; i < list.length - 2; i++) {
            formatted += String.format("%s%s ", list[i] , separator );
        }

        formatted += String.format("%s %s %s.",list[list.length - 2],finalListSeparator,list[list.length - 1]);

        return formatted;
    }

    public static String formatMoney(int moneyInCent,char currency) {
        return String.format("%d.%02d%s",moneyInCent / 100,moneyInCent % 100,currency);
    }
}

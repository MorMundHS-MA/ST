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

}

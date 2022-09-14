package PathTravelFilter;

import java.util.regex.Pattern;

/**
 @ author: Drunkbaby
 @ usages: 用于目录遍历的单个字符防御
 */

public class PathFilter {

    //private static Pattern FilePattern = Pattern.compile("[\\\\/:*?\"<>|]");

    private static Pattern FilePattern = Pattern.compile("[\\s\\.:?<>|]"); //过滤规则

    public static String filenameFilter(String str) {
        return str==null?null:FilePattern.matcher(str).replaceAll("");
    }

    public static void main(String[] args) {
        String str="home/..  <>|logs/../:edata?";
        //String filenameFilter = filenameFilter(str);
        String filenameFilter = fileNameValidate(str);
        System.out.println(filenameFilter);
    }

    private static String fileNameValidate(String str) {

        String strInjectListStr ="../|./|/..| |<|>|:|?";
        if(null!=strInjectListStr && !"".equals(strInjectListStr))
        {
            str = str.toLowerCase();
            String[] badStrs = strInjectListStr.split("\\|");
            for (int i = 0; i < badStrs.length; i++) {
                if (str.indexOf(badStrs[i]) >= 0) {
                    str= str.replace(badStrs[i], "");
                }
            }
        }
        return str;
    }
}
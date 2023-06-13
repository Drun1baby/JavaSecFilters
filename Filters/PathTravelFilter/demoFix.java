// 偶然看到的一种修复方法

public class demoFix {

    public String getOriginalFilename() {
        String filename = this.fileItem.getName();
        if (filename == null) {
            return "";
        }
        int unixSep = filename.lastIndexOf('/');
        int winSep = filename.lastIndexOf('\\');
        int pos = Math.max(winSep, unixSep);
        if (pos != -1) {
            return filename.substring(pos + 1);
        }
        return filename;
    }
}

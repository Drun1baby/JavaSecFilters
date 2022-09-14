/**
 @ author: Drunkbaby
 @ usages: 用于文件上传的接口修改
 @ 需要在对应接口中修改
 */

@RestController
public class securityUpload {
    @RequestMapping("/securityUpload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            return "请上传文件";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String contentType = file.getContentType();

        //过滤
        String[] picWhite = {".png",".jpg",".gif",".webp",".bmp"};
        String[] white_type = {"image/gif","image/jpeg","image/jpg","image/png"};
        Boolean SuffixFlag = false;
        Boolean TypeFlag = false;
        for (String pic_suffix:picWhite){
            if (suffix.toLowerCase().equals(pic_suffix)){
                SuffixFlag = true;
                break;
            }
        }
        for (String white_suffix:white_type){
            if (contentType.toLowerCase().equals(white_suffix)){
                TypeFlag = true;
                break;
            }
        }
        if (!SuffixFlag||!TypeFlag){
            return "File Type not allow";
        }

        String filePath = System.getProperty("user.dir")+"/tmp";

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String newfileName = dateFormat.format(date)+Integer.toHexString((int)new Date().getTime())+suffix;

        File dest = new File(filePath+File.separator+newfileName);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try{
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}

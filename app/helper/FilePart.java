package helper;

import play.mvc.Http;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午10:02
 * @Descrition:
 */
public class FilePart extends Http.MultipartFormData.FilePart {


    public FilePart(String key, String filename, String contentType, Object file) {
        super(key, filename, contentType, file);
    }
}

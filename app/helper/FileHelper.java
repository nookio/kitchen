package helper;

import play.mvc.Controller;
import play.mvc.Http;

import java.io.File;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午9:59
 * @Descrition:
 */
public class FileHelper {

    public Http.MultipartFormData.FilePart upload(Http.Request request, String fileKey) {
        Http.MultipartFormData<File> body = request.body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> picture = body.getFile(fileKey);
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            return picture;
        } else {
            return null;
        }
    }
}

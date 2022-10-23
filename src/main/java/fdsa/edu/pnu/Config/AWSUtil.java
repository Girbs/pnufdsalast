package fdsa.edu.pnu.Config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class AWSUtil {
    private AmazonS3 s3client;
    private static final String endpointUrl = "https://pnubukcet.s3.amazonaws.com";
    private static final String bucketName = "pnubukcet";
    private static final String accessKey = "AKIAXQ3S5MUTISSH6V4N";
    private static final String secretKey = "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";

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3client = new AmazonS3Client(credentials);
        // this.s3client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        // this.s3client.setObjectAcl(bucketName, secretKey, CannedAccessControlList.PublicRead);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file));
        s3client.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);
    }

    public String uploadFile(MultipartFile multipartFile) {

        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

//    Below code is for delete documents
//    public String deleteFileFromS3Bucket(String fileUrl) {
//        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
//        s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
//        return "Successfully deleted";
//    }

}
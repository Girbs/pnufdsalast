package fdsa.edu.pnu;

import org.springframework.stereotype.Controller;

@Controller
public class MainAppController {
//   @GetMapping ("")
//    public String index() {
//        return "upload";
//    }
//
//
//    @PostMapping("/upload")
//    public String handleUploadForm(Model model, String description,
//                                   @RequestParam("file") MultipartFile multipart) {
//        String fileName = multipart.getOriginalFilename();
//
//        System.out.println("Description: " + description);
//        System.out.println("filename: " + fileName);
//
//        String message = "";
//
//        try {
//            S3Util.uploadFile(fileName, multipart.getInputStream());
//            message = "Your file has been uploaded successfully!";
//        } catch (Exception ex) {
//            message = "Error uploading file: " + ex.getMessage();
//        }
//
//        model.addAttribute("message", message);
//
//        return "message";
//    }
}
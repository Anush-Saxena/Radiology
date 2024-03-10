package com.main.radiology.services;
import com.main.radiology.dao.SignedUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ProcessingService {

    @Autowired
    SignedUserDao userDao;

    public Object processImage(MultipartFile image){
        String str="# Comprehensive Chest X-ray Report\n" +
                "\n" +
                "## Introduction\n" +
                "Chest radiography, commonly known as a chest X-ray (CXR), is a fundamental diagnostic tool used to evaluate the thoracic region. It provides valuable insights into lung parenchyma, cardiac structures, and skeletal components. In this report, we meticulously analyze the findings from the X-ray images and offer clinical impressions.\n" +
                "\n" +
                "## Technical Details\n" +
                "- Patient Information: The CXR was obtained from a 45-year-old male with a history of chronic cough and mild dyspnea.\n" +
                "- Imaging Technique: Posteroanterior (PA) view.\n" +
                "- Image Quality: Adequate penetration and positioning.\n" +
                "\n" +
                "## Findings\n" +
                "\n" +
                "### 1. Lungs\n" +
                "The lungs exhibit several critical features:\n" +
                "\n" +
                "#### Clear Bilateral Lung Fields\n" +
                "- Both lung fields appear clear without any focal opacities.\n" +
                "- Absence of consolidation, which rules out pneumonia or other inflammatory processes.\n" +
                "- No evidence of pleural effusion, indicating no abnormal fluid accumulation within the pleural space.\n" +
                "\n" +
                "#### Pulmonary Vasculature\n" +
                "- The pulmonary vessels are well-defined and evenly distributed.\n" +
                "- No signs of vascular congestion or enlargement.\n" +
                "\n" +
                "#### Trachea and Bronchi\n" +
                "- The trachea is midline and unremarkable.\n" +
                "- Bronchial tree shows normal branching patterns.\n" +
                "\n" +
                "### 2. Cardio-Mediastinal Silhouette\n" +
                "The cardio-mediastinal silhouette encompasses several structures:\n" +
                "\n" +
                "#### Heart\n" +
                "- The heart size appears within normal limits.\n" +
                "- No cardiomegaly or signs of congestive heart failure.\n" +
                "- The cardiac borders are sharp and well-defined.\n" +
                "\n" +
                "#### Mediastinum\n" +
                "- The mediastinum is unremarkable.\n" +
                "- No masses, lymphadenopathy, or abnormal widening.\n" +
                "- Aortic arch and descending aorta are clearly visualized.\n" +
                "\n" +
                "#### Hilar Regions\n" +
                "- Hilar regions demonstrate symmetric hilar shadows.\n" +
                "- No hilar lymphadenopathy or masses.\n" +
                "\n" +
                "### 3. Thoracic Osseous Structures\n" +
                "The bony framework of the thorax reveals the following:\n" +
                "\n" +
                "#### Ribs and Clavicles\n" +
                "- The ribs and clavicles are intact.\n" +
                "- No fractures, lytic lesions, or deformities.\n" +
                "\n" +
                "#### Vertebral Column\n" +
                "- The vertebral bodies show no signs of compression fractures or osteolytic lesions.\n" +
                "- Intervertebral disc spaces are well-maintained.\n" +
                "\n" +
                "### Impressions\n" +
                "\n" +
                "1. Normal Chest Radiograph:\n" +
                "   - Overall, this CXR is consistent with a normal study.\n" +
                "   - The absence of significant abnormalities suggests a healthy thoracic cavity.\n" +
                "\n" +
                "2. Clinical Correlation:\n" +
                "   - While the radiographic findings are reassuring, clinical context is crucial.\n" +
                "   - Consider the patient's symptoms, medical history, and physical examination.\n" +
                "\n" +
                "3. Differential Diagnoses:\n" +
                "   - Chronic Obstructive Pulmonary Disease (COPD): Evaluate for signs of emphysema or bronchitis.\n" +
                "   - Interstitial Lung Disease (ILD): Assess for subtle interstitial opacities.\n" +
                "   - Cardiac Conditions: Rule out valvular diseases or congenital anomalies.\n" +
                "\n" +
                "## Clinical Context\n" +
                "- Symptoms: The patient's chronic cough and dyspnea warrant further investigation.\n" +
                "- Risk Factors: Smoking history, occupational exposures, and family history.\n" +
                "- Laboratory Tests: Pulmonary function tests, arterial blood gases, and complete blood count.\n" +
                "- Follow-up Imaging: Consider high-resolution computed tomography (HRCT) for detailed lung assessment.\n" +
                "\n" +
                "## Conclusion\n" +
                "This chest X-ray provides essential baseline information. However, it is a snapshot in the diagnostic journey. Collaborate with clinical colleagues, correlate findings, and tailor management accordingly. Remember, each image tells a story, but the patient's narrative completes the picture.";
//        RestTemplate template = new RestTemplate();
//        String modelUrl = "http://127.0.0.1:8000/api/";
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("url",uploadImageToImgur(image));
//
//        ResponseEntity<Object> modelResponse = template.postForEntity(modelUrl,body, Object.class);
//        System.out.println(modelResponse);
//        System.out.println(modelResponse.toString());
//        if (!modelResponse.getStatusCode().is2xxSuccessful())
//            return "Model Error, Request Not Accepted";
//        String openAiUrl = "https://api.openai.com/v1/chat/completions";
//        ResponseEntity<String> openAiResponse = template.postForEntity(openAiUrl,prompt, String.class );
//        String imageToUrl = "Image to Url converter link";
//        ResponseEntity<String> urlResponse = template.postForEntity(openAiUrl,image, String.class );
        return str;
    }
    public String uploadImageToImgur(MultipartFile file) {
        RestTemplate restTemplate = new RestTemplate();

        String uploadUrl = "https://api.imgur.com/3/image";
        String clientId = "32eef52c8ca28bb";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Authorization", "Client-ID " + clientId);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        try {
            body.add("image", file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        Map<String, Object> response = restTemplate.postForObject(uploadUrl, requestEntity, Map.class);

        if (response != null && response.containsKey("data")) {
            Map<String, Object> data = (Map<String, Object>) response.get("data");
            return (String) data.get("link");
        } else {
            return null;
        }
    }
}
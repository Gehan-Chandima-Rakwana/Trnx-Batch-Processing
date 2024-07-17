package com.redowl.batch_processing.controllers.transaction;

import com.redowl.batch_processing.services.transaction.XmlGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Validated
@Slf4j
@RestController
@RequestMapping("/base/xml")
public class BaseXmlController {

    private final XmlGenerationService xmlGenerationService;

    public BaseXmlController(XmlGenerationService xmlGenerationService) {
        this.xmlGenerationService = xmlGenerationService;
    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadXml(
            @RequestParam(defaultValue = "", required = false) String reportCode
    ) {
        String xml = xmlGenerationService.callApiAndGenerateXml(reportCode);

        if (xml != null) {
            try {
                String fileName = "response.xml";
                byte[] xmlBytes = xml.getBytes("UTF-8");

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_XML);
                headers.setContentDispositionFormData(fileName, fileName);

                return new ResponseEntity<>(xmlBytes, headers, HttpStatus.OK);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

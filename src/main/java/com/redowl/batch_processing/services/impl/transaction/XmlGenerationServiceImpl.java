package com.redowl.batch_processing.services.impl.transaction;


import com.redowl.batch_processing.exceptions.BadRequestAlertException;
import com.redowl.batch_processing.services.transaction.XmlGenerationService;
import com.redowl.batch_processing.services.transaction.XmlReportTagRenderService;
import com.redowl.batch_processing.xmlProceser.service.ReportService;
import com.redowl.batch_processing.xmlProceser.xmlConfigDto.Report;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlReportDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Service
@Slf4j
public class XmlGenerationServiceImpl implements XmlGenerationService {

    private final XmlReportTagRenderService xmlReportTagRenderService;

    public XmlGenerationServiceImpl(XmlReportTagRenderService xmlReportTagRenderService) {
        this.xmlReportTagRenderService = xmlReportTagRenderService;
    }

    @Override
    public String callApiAndGenerateXml(String reportCode) {

        xmlReportDto xmlReportDto = xmlReportTagRenderService.getRenderedReport(reportCode);

        if (xmlReportDto == null) {
            throw new BadRequestAlertException("XML NOT FOUND FOR THE GIVEN REPORT CODE: " + reportCode, "Report", "error");
        }

        ReportService reportService = new ReportService();
        Report report = reportService.generateReportTag(xmlReportDto);
//        System.out.println(report);


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(report, stringWriter);

            String xmlString = stringWriter.toString();
//            System.out.println(xmlString);
            return xmlString;
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        return null;
    }
}

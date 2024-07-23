package com.redowl.batch_processing.services.impl.transaction;

import com.redowl.batch_processing.exceptions.BadRequestAlertException;
import com.redowl.batch_processing.models.transaction.TTransaction;
import com.redowl.batch_processing.services.transaction.XmlTransactionTagRenderService;
import com.redowl.batch_processing.xmlProceser.utils.EnumTagVerifier;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlLateDepositDto;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlTransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@Slf4j
@Service
public class XmlTransactionTagRenderServiceImpl implements XmlTransactionTagRenderService {


    @Override
    public xmlTransactionDto getRenderedTransaction(TTransaction transaction) {
        log.info("Inside XmlTransactionTagRenderService: getRenderedTransaction method");
        try {
            xmlTransactionDto xmlTransactionDto = new xmlTransactionDto();
            if (transaction != null) {
//            System.out.println("xmlTransactionDto: " + transaction);

                xmlTransactionDto.setTransactionnumber(transaction.getTransactionNumber());
                xmlTransactionDto.setInternalRefNumber(transaction.getInternalRefNumber());
                xmlTransactionDto.setTransactionLocation(transaction.getTransactionLocation());
                xmlTransactionDto.setTransactionDescription(transaction.getTransactionDescription());

                if (transaction.getDateTransaction() != null)
                    xmlTransactionDto.setDateTransaction(transaction.getDateTransaction().atTime(0, 0, 0));

                if (transaction.getLateDeposit().booleanValue()) {
                    xmlLateDepositDto xmlLateDepositDto = new xmlLateDepositDto();
                    xmlLateDepositDto.setValue(transaction.getLateDeposit());
                    xmlTransactionDto.setLateDeposit(xmlLateDepositDto);
                }

//            if (transaction.getDatePosting() != null)
//                xmlTransactionDto.setDatePosting(transaction.getDatePosting().atTime(0, 0, 0));

                if (transaction.getValueDate() != null)
                    xmlTransactionDto.setValueDate(transaction.getValueDate().atTime(0, 0, 0));

                xmlTransactionDto.setTransmodeComment(transaction.getTransmodeComment());
                xmlTransactionDto.setAmountLocal(transaction.getAmountLocal());


                xmlTransactionDto.setComments(transaction.getComments());
            }


            return xmlTransactionDto;

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error while getRenderedTransaction: {}", e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }


    public static LocalDateTime convertToLocalDateTime(LocalDate date) {
        return date.atStartOfDay();
    }

}



package com.redowl.batch_processing.services.transaction;


import com.redowl.batch_processing.models.transaction.TTransaction;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlTransactionDto;

public interface XmlTransactionTagRenderService {
    xmlTransactionDto getRenderedTransaction(TTransaction transaction);
}

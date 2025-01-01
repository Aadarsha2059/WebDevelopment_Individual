package org.example.individual.Service;



import org.example.individual.Entity.CashPayment;
import org.example.individual.Pojo.CashPaymentPojo;
import org.example.individual.Pojo.CashPaymentProjection;

import java.util.List;

public interface CashPaymentService {

    List<CashPaymentProjection> findAllCashPayments();

    List<CashPayment> findByPaymentStatus(boolean paymentStatus);

    CashPayment findByEmail(String email);

    Long save(CashPaymentPojo cashPaymentPojo);

    void update(CashPaymentPojo cashPaymentPojo);

    void deleteById(Long id);

    CashPayment findById(Long id);
}

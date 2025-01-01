package org.example.individual.Service.Impl;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.CashPayment;
import org.example.individual.Pojo.CashPaymentPojo;
import org.example.individual.Pojo.CashPaymentProjection;
import org.example.individual.Repository.CashPaymentRepository;
import org.example.individual.Service.CashPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashPaymentServiceImpl implements CashPaymentService {

    private final CashPaymentRepository cashPaymentRepository;

    @Override
    public List<CashPaymentProjection> findAllCashPayments() {
        return cashPaymentRepository.findAllCashPayments();
    }

    @Override
    public List<CashPayment> findByPaymentStatus(boolean paymentStatus) {
        return cashPaymentRepository.findByPaymentStatus(paymentStatus);
    }

    @Override
    public CashPayment findByEmail(String email) {
        Optional<CashPayment> cashPayment = cashPaymentRepository.findByEmail(email);
        return cashPayment.orElse(null);
    }

    @Override
    public Long save(CashPaymentPojo cashPaymentPojo) {
        CashPayment cashPayment = new CashPayment();
        cashPayment.setCustomerName(cashPaymentPojo.getCustomerName());
        cashPayment.setAddress(cashPaymentPojo.getAddress());
        cashPayment.setContactNumber(cashPaymentPojo.getContactNumber());
        cashPayment.setEmail(cashPaymentPojo.getEmail());
        cashPayment.setPaymentStatus(cashPaymentPojo.isPaymentStatus());
        cashPayment = cashPaymentRepository.save(cashPayment);
        return cashPayment.getId();
    }

    @Override
    public void update(CashPaymentPojo cashPaymentPojo) {
        Optional<CashPayment> cashPayment = cashPaymentRepository.findById(cashPaymentPojo.getId());
        if (cashPayment.isPresent()) {
            CashPayment existingPayment = cashPayment.get();
            existingPayment.setCustomerName(cashPaymentPojo.getCustomerName());
            existingPayment.setAddress(cashPaymentPojo.getAddress());
            existingPayment.setContactNumber(cashPaymentPojo.getContactNumber());
            existingPayment.setEmail(cashPaymentPojo.getEmail());
            existingPayment.setPaymentStatus(cashPaymentPojo.isPaymentStatus());
            cashPaymentRepository.save(existingPayment);
        }
    }

    @Override
    public void deleteById(Long id) {
        cashPaymentRepository.deleteById(id);
    }

    @Override
    public CashPayment findById(Long id) {
        Optional<CashPayment> cashPayment = cashPaymentRepository.findById(id);
        return cashPayment.orElse(null);
    }
}

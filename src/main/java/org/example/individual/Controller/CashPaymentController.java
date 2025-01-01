package org.example.individual.Controller;




import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.CashPayment;
import org.example.individual.Pojo.CashPaymentPojo;
import org.example.individual.Pojo.CashPaymentProjection;
import org.example.individual.Pojo.GlobalAPIResponse;
import org.example.individual.Service.CashPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cash_payment")
@RequiredArgsConstructor
public class CashPaymentController {

    private final CashPaymentService cashPaymentService;

    @GetMapping("/getAll")
    public List<CashPaymentProjection> findAllCashPayments() {
        return cashPaymentService.findAllCashPayments();
    }

    @GetMapping("/{id}")
    public CashPayment findById(@PathVariable Long id) {
        return cashPaymentService.findById(id);
    }

    @GetMapping("/email/{email}")
    public CashPayment findByEmail(@PathVariable String email) {
        return cashPaymentService.findByEmail(email);
    }

    @GetMapping("/status/{status}")
    public List<CashPayment> findByPaymentStatus(@PathVariable boolean status) {
        return cashPaymentService.findByPaymentStatus(status);
    }

    @PostMapping
    public GlobalAPIResponse<Long> save(@RequestBody CashPaymentPojo cashPaymentPojo) {
        GlobalAPIResponse<Long> response = new GlobalAPIResponse<>();
        Long paymentId = cashPaymentService.save(cashPaymentPojo);
        response.setData(paymentId);
        response.setMessage("Cash payment saved successfully");
        return response;
    }

    @PutMapping
    public GlobalAPIResponse<Long> update(@RequestBody CashPaymentPojo cashPaymentPojo) {
        GlobalAPIResponse<Long> response = new GlobalAPIResponse<>();
        cashPaymentService.update(cashPaymentPojo);
        response.setData(cashPaymentPojo.getId());
        response.setMessage("Cash payment updated successfully");
        return response;
    }

    @DeleteMapping("/{id}")
    public GlobalAPIResponse<Long> delete(@PathVariable Long id) {
        GlobalAPIResponse<Long> response = new GlobalAPIResponse<>();
        cashPaymentService.deleteById(id);
        response.setData(id);
        response.setMessage("Cash payment deleted successfully");
        return response;
    }
}

package org.example.individual.Repository;









import org.example.individual.Entity.CashPayment;
import org.example.individual.Pojo.CashPaymentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CashPaymentRepository extends JpaRepository<CashPayment, Long> {

    // Custom query to fetch all cash payments along with additional details (if necessary)
    @Query(nativeQuery = true, value = "SELECT cp.id, cp.customer_name, cp.address, cp.contact_number, cp.email, cp.payment_status, cp.created_at FROM cash_payment cp")
    List<CashPaymentProjection> findAllCashPayments();

    // Method to find all payments for a specific user (can be linked if a User entity exists)
    // For now, it assumes the user_id is stored in the CashPayment table or that such a link is required
    @Query("SELECT cp FROM CashPayment cp WHERE cp.email = ?1")
    Optional<CashPayment> findByEmail(String email);

    // Method to find payments by payment status
    List<CashPayment> findByPaymentStatus(boolean paymentStatus);
}

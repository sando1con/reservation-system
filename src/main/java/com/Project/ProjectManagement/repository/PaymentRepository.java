package com.Project.ProjectManagement.repository;

import com.Project.ProjectManagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

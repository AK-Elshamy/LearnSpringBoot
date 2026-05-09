package com.codeWithElshamy.voucherApp.voucherApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeWithElshamy.voucherApp.voucherApp.model.Voucher;

public interface VoucherRepo extends JpaRepository<Voucher, Long> {

    Voucher findByCode(String code);
}
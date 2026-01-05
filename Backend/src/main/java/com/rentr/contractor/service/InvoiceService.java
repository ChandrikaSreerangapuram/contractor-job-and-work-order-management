package com.rentr.contractor.service;

import com.rentr.contractor.dto.InvoiceRequestDTO;
import com.rentr.contractor.model.*;
import com.rentr.contractor.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepo;
    private final WorkOrderRepository workOrderRepo;

    public InvoiceService(InvoiceRepository invoiceRepo, WorkOrderRepository workOrderRepo) {
        this.invoiceRepo = invoiceRepo;
        this.workOrderRepo = workOrderRepo;
    }

    public Invoice submitInvoice(InvoiceRequestDTO requestDTO) {
        WorkOrder wo = workOrderRepo.findById(requestDTO.getWorkOrderId()).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
        Invoice inv = new Invoice();
        inv.setWorkOrder(wo);
        inv.setAmount(requestDTO.getAmount());
        inv.setPaid(false); // New invoices are unpaid by default
        return invoiceRepo.save(inv);
    }

    public List<Invoice> getPendingInvoices() { return invoiceRepo.findByPaidFalse(); }

    public Invoice approveInvoice(Long invoiceId) {
        Invoice inv = invoiceRepo.findById(invoiceId).orElseThrow(() -> new RuntimeException("Invoice not found"));
        inv.setPaid(true);
        return invoiceRepo.save(inv);
    }

    public Invoice rejectInvoice(Long invoiceId) {
        Invoice inv = invoiceRepo.findById(invoiceId).orElseThrow(() -> new RuntimeException("Invoice not found"));
        inv.setPaid(false); // Explicitly set to false if it was approved and then rejected, or just keep it false
        return invoiceRepo.save(inv);
    }
}

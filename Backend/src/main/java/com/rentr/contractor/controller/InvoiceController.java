package com.rentr.contractor.controller;

import com.rentr.contractor.dto.InvoiceRequestDTO;
import com.rentr.contractor.model.Invoice;
import com.rentr.contractor.service.InvoiceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) { this.invoiceService = invoiceService; }

    @PostMapping("/submit")
    public Invoice submitInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
        return invoiceService.submitInvoice(invoiceRequestDTO);
    }

    @GetMapping("/pending")
    public List<Invoice> getPendingInvoices() { return invoiceService.getPendingInvoices(); }

    @PutMapping("/{invoiceId}/approve")
    public Invoice approveInvoice(@PathVariable Long invoiceId) { return invoiceService.approveInvoice(invoiceId); }

    @PutMapping("/{invoiceId}/reject")
    public Invoice rejectInvoice(@PathVariable Long invoiceId) { return invoiceService.rejectInvoice(invoiceId); }
}

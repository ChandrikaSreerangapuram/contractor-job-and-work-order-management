import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-Type": "application/json",
  },
});

API.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// Auth Endpoints
export const login = (credentials) => API.post("/auth/login", credentials);

// JobOrder Endpoints
export const getApprovedJobOrders = () => API.get("/jobOrders/approved"); // Will implement this endpoint in backend later

// WorkOrder Endpoints
export const submitWorkOrder = (jobOrderId, contractorId) => API.post("/api/work-orders", { jobOrderId, contractorId });
export const getContractorWorkOrders = (contractorId) => API.get(`/api/work-orders/contractor/${contractorId}`); // Will implement this endpoint in backend later
export const getPendingWorkOrders = () => API.get("/api/work-orders/pending");
export const approveWorkOrder = (id) => API.put(`/api/work-orders/${id}/approve`);
export const rejectWorkOrder = (id) => API.put(`/api/work-orders/${id}/reject`);

// WorkPlan Endpoints
export const submitWorkPlan = (workOrderId, planDetails) => API.post("/workPlans", { workOrderId, planDetails });

// Invoice Endpoints
export const submitInvoice = (workOrderId, amount) => API.post("/invoices/submit", { workOrderId, amount });
export const getPendingInvoices = () => API.get("/invoices/pending");
export const approveInvoice = (id) => API.put(`/invoices/${id}/approve`);
export const rejectInvoice = (id) => API.put(`/invoices/${id}/reject`);

export default API;
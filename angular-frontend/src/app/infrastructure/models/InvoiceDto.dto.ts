export interface InvoiceDto {
  supplierCode: number,
  invoiceNumber: number;
  invoiceDate: string;
  invoiceAmount: number;
  currency: string;
  file: File
}

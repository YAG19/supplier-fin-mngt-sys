export interface InvoiceDto {
  supplierCode: number,
  invoiceNumber: number;
  invoiceDate: string;
  invoiceAmount: number;
  currency: string;
  username: string;
  invoiceStatus: string;
  file: File
}

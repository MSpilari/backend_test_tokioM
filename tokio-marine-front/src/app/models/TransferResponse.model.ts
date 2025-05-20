export interface TransferResponse {
  senderAccount: string;
  destinationAccount: string;
  value: number;
  tax: number;
  totalWithTax: number;
  scheduleAt: string;
  transferDate: string;
}

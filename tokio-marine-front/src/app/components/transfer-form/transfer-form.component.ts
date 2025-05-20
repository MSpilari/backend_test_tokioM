import { Component } from '@angular/core';
import { TransferRequest } from '../../models/TransferRequest.model';
import { TransferService } from '../../services/Transfer.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-transfer-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './transfer-form.component.html',
  styleUrl: './transfer-form.component.scss',
})
export class TransferFormComponent {
  transfer: TransferRequest = {
    senderAccount: '',
    destinationAccount: '',
    value: 0,
    transferDate: '',
  };

  constructor(private transferService: TransferService) {}

  submit() {
    this.transferService.makeTransfer(this.transfer).subscribe({
      next: (res) => {
        alert(res.Message);
      },
      error: (err) => {
        alert('Error: ' + err.error?.errorMessage || 'Unknown error');
      },
    });
  }
}

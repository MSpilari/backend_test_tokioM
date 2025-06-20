import { Component } from '@angular/core';
import { TransferRequest } from '../../models/TransferRequest.model';
import { TransferService } from '../../services/Transfer.service';
import { FormsModule, NgForm } from '@angular/forms';
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

  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private transferService: TransferService) {}

  submit(form: NgForm) {
    this.transferService.makeTransfer(this.transfer).subscribe({
      next: (res) => {
        this.successMessage = res.Message;
        this.errorMessage = null;

        form.resetForm();
        setTimeout(() => {
          this.successMessage = null;
        }, 5000);
      },
      error: (err) => {
        this.errorMessage = err.error?.errorMessage || 'Erro desconhecido';
        this.successMessage = null;

        setTimeout(() => (this.errorMessage = null), 5000);
      },
    });
  }
}

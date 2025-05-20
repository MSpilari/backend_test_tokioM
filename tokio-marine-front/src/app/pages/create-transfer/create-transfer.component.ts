import { Component } from '@angular/core';
import { TransferFormComponent } from '../../components/transfer-form/transfer-form.component';

@Component({
  selector: 'app-create-transfer',
  standalone: true,
  imports: [TransferFormComponent],
  templateUrl: './create-transfer.component.html',
  styleUrl: './create-transfer.component.scss',
})
export class CreateTransferComponent {}

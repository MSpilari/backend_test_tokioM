import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { TransferResponse } from '../../models/TransferResponse.model';

@Component({
  selector: 'app-table-extract',
  imports: [CommonModule],
  templateUrl: './table-extract.component.html',
  styleUrl: './table-extract.component.scss',
})
export class TableExtractComponent {
  @Input()
  transfers: TransferResponse[] = [];
}

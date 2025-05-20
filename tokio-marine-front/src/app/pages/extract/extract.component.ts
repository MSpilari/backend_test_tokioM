import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TransferResponse } from '../../models/TransferResponse.model';
import { TransferService } from '../../services/Transfer.service';
import { TableExtractComponent } from '../../components/table-extract/table-extract.component';

@Component({
  selector: 'app-extract',
  standalone: true,
  imports: [TableExtractComponent],
  templateUrl: './extract.component.html',
  styleUrl: './extract.component.scss',
})
export class ExtractComponent implements OnInit {
  transfers: TransferResponse[] = [];

  constructor(private transferService: TransferService) {}

  ngOnInit() {
    this.transferService.getTransfers().subscribe({
      next: (data) => {
        this.transfers = data;
      },
      error: (err) =>
        alert(
          'Erro ao carregar transferências: ' +
            (err.error?.message || 'Erro desconhecido')
        ),
    });
  }
}

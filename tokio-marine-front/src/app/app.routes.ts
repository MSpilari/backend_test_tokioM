import { Routes } from '@angular/router';
import { CreateTransferComponent } from './pages/create-transfer/create-transfer.component';
import { ExtractComponent } from './pages/extract/extract.component';

export const routes: Routes = [
  { path: '', component: CreateTransferComponent },
  { path: 'extrato', component: ExtractComponent },
];

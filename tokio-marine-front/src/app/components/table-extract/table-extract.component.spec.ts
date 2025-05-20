import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableExtractComponent } from './table-extract.component';

describe('TableExtractComponent', () => {
  let component: TableExtractComponent;
  let fixture: ComponentFixture<TableExtractComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableExtractComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableExtractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

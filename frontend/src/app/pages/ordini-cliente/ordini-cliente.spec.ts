import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrdiniCliente } from './ordini-cliente';

describe('OrdiniCliente', () => {
  let component: OrdiniCliente;
  let fixture: ComponentFixture<OrdiniCliente>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrdiniCliente],
    }).compileComponents();

    fixture = TestBed.createComponent(OrdiniCliente);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

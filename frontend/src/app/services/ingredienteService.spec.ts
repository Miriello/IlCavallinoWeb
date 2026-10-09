import { TestBed } from '@angular/core/testing';
import { Ingrediente } from './ingredienteService';

describe('Ingrediente', () => {
  let service: Ingrediente;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Ingrediente);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

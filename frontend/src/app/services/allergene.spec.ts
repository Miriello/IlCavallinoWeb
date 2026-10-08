import { TestBed } from '@angular/core/testing';
import { Allergene } from './allergene';

describe('Allergene', () => {
  let service: Allergene;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Allergene);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

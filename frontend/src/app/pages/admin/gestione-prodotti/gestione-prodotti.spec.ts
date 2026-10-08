import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GestioneProdotti } from './gestione-prodotti';

describe('GestioneProdotti', () => {
  let component: GestioneProdotti;
  let fixture: ComponentFixture<GestioneProdotti>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestioneProdotti],
    }).compileComponents();

    fixture = TestBed.createComponent(GestioneProdotti);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

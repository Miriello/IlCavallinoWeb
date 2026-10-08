import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GestioneIngredienti } from './gestione-ingredienti';

describe('GestioneIngredienti', () => {
  let component: GestioneIngredienti;
  let fixture: ComponentFixture<GestioneIngredienti>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestioneIngredienti],
    }).compileComponents();

    fixture = TestBed.createComponent(GestioneIngredienti);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

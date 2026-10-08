import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrdineCard } from './ordine-card';

describe('OrdineCard', () => {
  let component: OrdineCard;
  let fixture: ComponentFixture<OrdineCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrdineCard],
    }).compileComponents();

    fixture = TestBed.createComponent(OrdineCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

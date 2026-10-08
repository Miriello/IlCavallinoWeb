import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CarrelloItem } from './carrello-item';

describe('CarrelloItem', () => {
  let component: CarrelloItem;
  let fixture: ComponentFixture<CarrelloItem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarrelloItem],
    }).compileComponents();

    fixture = TestBed.createComponent(CarrelloItem);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

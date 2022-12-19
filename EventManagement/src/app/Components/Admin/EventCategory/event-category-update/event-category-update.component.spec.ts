import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventCategoryUpdateComponent } from './event-category-update.component';

describe('EventCategoryUpdateComponent', () => {
  let component: EventCategoryUpdateComponent;
  let fixture: ComponentFixture<EventCategoryUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventCategoryUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventCategoryUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

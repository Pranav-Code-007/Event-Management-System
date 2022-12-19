import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserShowEventsComponent } from './user-show-events.component';

describe('UserShowEventsComponent', () => {
  let component: UserShowEventsComponent;
  let fixture: ComponentFixture<UserShowEventsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserShowEventsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserShowEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

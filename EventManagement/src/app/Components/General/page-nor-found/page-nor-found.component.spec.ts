import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageNorFoundComponent } from './page-nor-found.component';

describe('PageNorFoundComponent', () => {
  let component: PageNorFoundComponent;
  let fixture: ComponentFixture<PageNorFoundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageNorFoundComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageNorFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

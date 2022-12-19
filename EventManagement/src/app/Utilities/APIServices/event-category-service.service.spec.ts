import { TestBed } from '@angular/core/testing';

import { EventCategoryServiceService } from './event-category-service.service';

describe('EventCategoryServiceService', () => {
  let service: EventCategoryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventCategoryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

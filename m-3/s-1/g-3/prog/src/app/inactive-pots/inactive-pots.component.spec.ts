import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InactivePotsComponent } from './inactive-pots.component';

describe('InactivePotsComponent', () => {
  let component: InactivePotsComponent;
  let fixture: ComponentFixture<InactivePotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InactivePotsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InactivePotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

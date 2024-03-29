import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DacompletareComponent } from './dacompletare.component';

describe('DacompletareComponent', () => {
  let component: DacompletareComponent;
  let fixture: ComponentFixture<DacompletareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DacompletareComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DacompletareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

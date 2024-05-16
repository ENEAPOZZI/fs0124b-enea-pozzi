import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProflePageComponent } from './profle-page.component';

describe('ProflePageComponent', () => {
  let component: ProflePageComponent;
  let fixture: ComponentFixture<ProflePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProflePageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProflePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

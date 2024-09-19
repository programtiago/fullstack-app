import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginAttemptsListComponent } from './login-attempts-list.component';

describe('LoginAttemptsListComponent', () => {
  let component: LoginAttemptsListComponent;
  let fixture: ComponentFixture<LoginAttemptsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoginAttemptsListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LoginAttemptsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

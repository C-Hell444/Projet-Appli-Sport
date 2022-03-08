import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
@Component({
  selector: 'app-inscription-club',
  templateUrl: './inscription-club.component.html',
  styleUrls: ['./inscription-club.component.css'],
})
export class InscriptionClubComponent implements OnInit {
  form!: FormGroup;
  compte: any;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  clickUser() {
    this.router.navigate(['/inscription-utilisateur']);
  }

  save() {
    let user = {
      username: this.form.get('login')?.value,
      password: this.form.get('passwordGrp')?.get('password')?.value,
    };
    console.log(user);

    this.compte.type;

    this.authService.inscription(user).subscribe(() => {
      this.router.navigateByUrl('/acceuil');
    });
  }
}

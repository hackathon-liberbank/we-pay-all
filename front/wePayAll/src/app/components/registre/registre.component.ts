import { Component, OnInit } from '@angular/core';
import { UserRegistre, Address } from '../../model/userRegistre';

@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css']
})
export class RegistreComponent implements OnInit {

  public user: UserRegistre;

  constructor() {
    this.user = new UserRegistre("","","","",new Address("","","","","") ,"");
  }

  ngOnInit() {
  }

  resgistrar() {
    console.log('Estamos haciendo registro');
  }

}

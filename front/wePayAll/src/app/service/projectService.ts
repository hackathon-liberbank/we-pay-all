import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserRegistre } from '../model/userRegistre';
import { Login } from '../model/login';
import { User } from '../model/user';
import { Event } from '../model/event';
import { sha256 } from 'js-sha256';
import { UsersEvent } from '../model/usersEvent';

import { GLOBAL } from '../model/Global';

@Injectable()

export class UserRegistreService {ss

    public url: string;
    public apiUser: User;



    constructor(
       public _http: HttpClient
    ) {
        this.url = GLOBAL.url
        this.apiUser  = JSON.parse(localStorage.getItem('userLogin'));
    }

    registrado(userRegister: UserRegistre): Observable<any>{
        userRegister.password = sha256(userRegister.password)
        console.log(userRegister.password)
        let json = JSON.stringify(userRegister);
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        let uri = 'registry';

        return this._http.post(this.url + uri, json, {headers: headers});

    }

    acceder(user: Login ): Observable<any> {
        user.password = sha256(user.password)
        let json = JSON.stringify(user);
        console.log(user)
        let headers = new HttpHeaders().set('Content-Type', 'application/json');

        return this._http.post(this.url + 'login', json, {headers: headers})
    }

    getUserLogin() {

       let apiUser = JSON.parse(localStorage.getItem('userLogin'));
        if(apiUser != 'undefined') {
            this.apiUser = apiUser;
        } else {
            this.apiUser = null;
        }

        return this.apiUser;
    }

    // getToken(): Observable<any> {
    //   let code = localStorage.getItem('code')
    //   console.log(code)
    //   let headers = new HttpHeaders().set('Content-Type', 'application/json').set('code', code).set('Accept', '*/*');

    //   return this._http.post(this.url + 'token', null, {headers: headers})
    // }

// CREA UN EVENTO DESDE EL PERFIL DE USUARIO

createEvent( event: Event): Observable<any> {
  let apiUser = JSON.parse(localStorage.getItem('userLogin'));
  let json = JSON.stringify(event);
  console.log(json)
  let headers = new HttpHeaders().set('Content-Type', 'application/json').set('Authorization','Bearer: '+ this.apiUser.bearer).set('token', '1234');
  console.log(headers)
  console.log(apiUser.bearer)

  return this._http.post(this.url + 'users/'+  apiUser.userID + '/events', json, {headers: headers})
}

// RECUPERAR INFORMACION DE UN EVENTO

  getEvent( detalle: UsersEvent ): Observable<any> {
  let apiUser = JSON.parse(localStorage.getItem('userLogin'));
  let json = JSON.stringify(detalle);
  console.log(json)
  let headers = new HttpHeaders().set('Content-Type', 'application/json').set('Authorization','Bearer: '+ this.apiUser.bearer).set('token', '1234');
  console.log(headers)
  console.log(apiUser.bearer)

  return this._http.get(this.url + 'users/'+  apiUser.userID + '/events', json, {headers: headers})
  }

// REALIZAR UN PAGO

makePayment() {
  let apiUser = JSON.parse(localStorage.getItem('userLogin'));
  let headers = new HttpHeaders().set('Content-Type', 'application/json').set('Authorization','Bearer: '+ this.apiUser.bearer).set('token', '1234');
  console.log(headers)
  return this._http.post(this.url + 'users/'+  apiUser.userID + '/events/payments', {headers: headers})
}

  // consultHash( idTransaccion: Hash) {

  //   let headers = new HttpHeaders().set('Content-Type', 'application/json').set('Authorization','Bearer '+ this.apiUser.bearer);

  //   return this._http.get(this.url + 'transactions/'+  idTransaccion.hash, {headers: headers})

  // }

}

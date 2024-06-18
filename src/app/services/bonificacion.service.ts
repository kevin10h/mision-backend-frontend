import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BonificacionModel } from '../models/bonificacion-model';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BonificacionService {
  URL_API: string = 'http://localhost:8082/'
  constructor(private http: HttpClient) { }

  getBonificaciones(id_bonificacion: string, id_tipo: string) {
    let params = new HttpParams()
      .set('id_bonificacion', id_bonificacion)
      .set('id_tipo', id_tipo);
    return this.http.get<BonificacionModel[]>(this.URL_API + 'bonificacion/getBonificaciones', { params }).pipe(map(res => res));
  }
}

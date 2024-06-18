import { Component } from '@angular/core';
import { BonificacionModel } from '../../models/bonificacion-model';
import { BonificacionService } from '../../services/bonificacion.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bonificacion',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  templateUrl: './bonificacion.component.html',
  styleUrl: './bonificacion.component.css'
})
export class BonificacionComponent {
  bonificaciones: BonificacionModel[] = [];
  busqueda_id_bonif: String = "";
  id_tipo_bonificacion: String = "";
  constructor(private service: BonificacionService) {
  }

  ngOnInit(): void {
    this.getBonificaciones(this.busqueda_id_bonif, this.id_tipo_bonificacion);
  }

  getBonificaciones(id_bonificacion: String, id_tipo: String) {
    let id_bonif: string = id_bonificacion.valueOf();
    let tipo_bonif: string = id_tipo.valueOf();
    this.service.getBonificaciones(id_bonif, tipo_bonif).subscribe(
      (data: BonificacionModel[]) => {
        this.bonificaciones = data;
        console.log(data);
        console.log(this.bonificaciones);
      }
    )
  }

}

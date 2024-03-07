import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-edit',
  standalone: true,
  imports: [],
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent {
  id:any;
  datos:any = [];

  constructor( private api: ApiService, private router: Router, private _route: ActivatedRoute ){
    this.id = Number(this._route.snapshot.paramMap.get("id"));
    this.obtenerPersona();
  }

  atras(){
    this.router.navigate(["/"]);
  }

  obtenerPersona(){
    this.api.obtenerPersonaId(this.id).subscribe((data:any)=>{
      this.datos = data;
    })
  }

  editar( nombre:any, num_ide:any, fecha_nac: any ){
    let body = {
      "nombre": nombre.value,
      "numero_identificacion": num_ide.value,
      "fecha_nacimiento": fecha_nac.value
    }

    this.api.editarPersona(this.id, body).subscribe((data:any)=>{
      alert("La persona con el id No. " + this.id + ' ha sido modificada con exito!');
      this.atras();
    });

  }


}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  api = "http://localhost:8080/api/";

  constructor(private http: HttpClient) { }

  public crearPersona(body: any) {
    console.log(body)
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    let options = { headers: headers };
    return this.http.post(this.api + 'personas/create', body);
  }

  public obtenerPersonas() {
    return this.http.get(this.api + 'personas');
  }

  public obtenerPersonaId(id: any) {
    return this.http.get(this.api + 'personas/' + id);
  }

  public editarPersona(id: any, body: any) {
    return this.http.put(this.api + 'personas/edit/' + id, body);
  }

  public eliminarPersona(id: any) {
    return this.http.delete(this.api + 'personas/delete/' + id);
  }

}

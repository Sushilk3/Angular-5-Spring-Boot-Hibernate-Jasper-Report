/**
 * Created by SRX on 1/7/2018.
 */
import {Component, AfterViewInit} from "@angular/core";
import {CurriculumViteaService} from "../service/cv.service";
import {CurriculumVitaeModel} from "../model/cv.model";


@Component  ({
  selector: 'register',
  templateUrl: './cv.register.component.html'
})

export class RegisterComponent {

  newCv: CurriculumVitaeModel = new CurriculumVitaeModel();
  registerCv: boolean = true;
  private dataRegisterCv: Object[];

  constructor (private curriculumViteaService: CurriculumViteaService){}


  // Submit POST
  onSubmit(){
    this.curriculumViteaService.sendCV(this.newCv).subscribe( data => {
      this.registerCv = true, this.newCv = new CurriculumVitaeModel(); },
      error => console.log(error), () => console.log('Register CV Sukses --> ', this.dataRegisterCv));
  }
}

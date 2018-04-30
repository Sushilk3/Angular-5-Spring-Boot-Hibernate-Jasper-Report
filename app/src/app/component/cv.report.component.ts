/**
 * Created by SRX on 1/7/2018.
 */


import {Component, OnInit, AfterViewInit, Input} from "@angular/core";
import {CurriculumViteaService} from "../service/cv.service";
@Component({
  selector: 'report',
  templateUrl: './cv.report.component.html'
})

export class ReportComponent implements AfterViewInit{

  public daftarRegister: Object[];
  public daftarRegisters: Object[];
  public dataTemp: Object[];

  generateReport: boolean = false;


  @Input() age = "";
 
  @Input() ages = "";
  @Input() token = "";

  constructor( private curriculumVitaeService: CurriculumViteaService){};


  // ngOnInit(){
  //   this.curriculumViteaService.getCV().subscribe(
  //     data => {this.dataRegister = data}, (err) => console.log(err), () => console.log('Input ---->>>', this.dataRegister)
  //   )
  // }


  ngAfterViewInit(){
    this.curriculumVitaeService.getCV().subscribe(
    data => {this.daftarRegister = data},
    (err) => console.log(err),
    () => console.log('Output Report get ---->>>', this.daftarRegister))

    this.curriculumVitaeService.getCVs().subscribe(
      data => {this.daftarRegisters = data},
      (err) => console.log(err),
      () => console.log('Output Report post ---->>>', this.daftarRegisters))
  }


  getSubmit() {
    this.curriculumVitaeService.getCV().subscribe(
      data => {
        this.generateReport = true,
        this.daftarRegister = data;
        this.dataTemp = data;
      }, error => { console.error(error), () => console.log('Get All Sukses ------> ', this.daftarRegister);
      })
  }
}

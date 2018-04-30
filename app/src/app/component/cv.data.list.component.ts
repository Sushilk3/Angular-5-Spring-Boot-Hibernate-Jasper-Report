import { Component, OnInit } from '@angular/core';
import {CurriculumViteaService} from "../service/cv.service";
import {CurriculumVitaeModel} from "../model/cv.model";

@Component({
  selector: 'data-list-view',
  templateUrl: 'cv.data.list.component.html'
})
export class DataComponent implements OnInit {

  public dataList: Object[];
  listData: CurriculumVitaeModel = new CurriculumVitaeModel();

  constructor(private curriculumVitaeService: CurriculumViteaService) { };

  ngOnInit() {
    this.curriculumVitaeService.getCV().subscribe(
      data => {this.dataList = data}, (err) => console.log(err), () => console.log('Output Data List---->>>', this.dataList));

    this.curriculumVitaeService.getCV().subscribe((data:Object[]) => this.dataList = data, error => console.log("error getMenuActive:",error));
  }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  public username!: string;
  public role!: string;
  public toRender: boolean = true;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    let  paramsData : string =  this.route.snapshot.queryParamMap.get('userData') || "";
    console.log(JSON.parse(paramsData));
    let userData = JSON.parse(paramsData);
    this.username = userData?.username;
    this.role = userData?.role;

    if(this.role === 'SUPPLIER') this.toRender = false;
  }

}

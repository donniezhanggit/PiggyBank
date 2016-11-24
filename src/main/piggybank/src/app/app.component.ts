import {Component, OnInit} from '@angular/core';
import {BalanceService} from "./balance.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent implements OnInit{
  balance = 0;


  constructor(private balanceService: BalanceService) {

  }

  ngOnInit() {
    this.balanceService.load().subscribe(json => {
      this.balance=json.amount;
    })
  }

  submitform(newBalance : number) {

    this.balanceService.submit(newBalance).subscribe(json => {
      console.log(json);
      var body = JSON.parse(json._body);
      this.balance=body.amount;
    });
  }
}

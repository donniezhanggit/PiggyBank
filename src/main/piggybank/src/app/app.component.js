"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require('@angular/core');
var AppComponent = (function () {
    function AppComponent(balanceService) {
        this.balanceService = balanceService;
        this.balance = 0;
    }
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.balanceService.load().subscribe(function (json) {
            _this.balance = json.amount;
        });
    };
    AppComponent.prototype.submitform = function (newBalance) {
        var _this = this;
        this.balanceService.submit(newBalance).subscribe(function (json) {
            console.log(json);
            var body = JSON.parse(json._body);
            _this.balance = body.amount;
        });
    };
    AppComponent = __decorate([
        core_1.Component({
            selector: 'app-root',
            templateUrl: './app.component.html',
            styleUrls: ['./app.component.scss']
        })
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map
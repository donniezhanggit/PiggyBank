"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require('@angular/core');
var http_1 = require("@angular/http");
require('rxjs/add/operator/map');
var BalanceService = (function () {
    function BalanceService(http) {
        this.http = http;
    }
    BalanceService.prototype.load = function () {
        return this.http.get('http://localhost:8080/api/balance')
            .map(function (response) { return response.json(); });
    };
    BalanceService.prototype.submit = function (deposit) {
        console.log(deposit);
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post('http://localhost:8080/api/deposit', { "depositAmount": deposit }, headers);
    };
    BalanceService = __decorate([
        core_1.Injectable()
    ], BalanceService);
    return BalanceService;
}());
exports.BalanceService = BalanceService;
//# sourceMappingURL=balance.service.js.map
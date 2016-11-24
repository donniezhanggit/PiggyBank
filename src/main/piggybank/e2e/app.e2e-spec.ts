import { PiggybankPage } from './app.po';

describe('piggybank App', function() {
  let page: PiggybankPage;

  beforeEach(() => {
    page = new PiggybankPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

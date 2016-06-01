// var csd = require('../src/One.js')

describe("A suite", function() {
  it("contains spec with an expectation", function() {
    expect(true).toBe(true);
  });
  it("contains spec with an error", function() {
    expect(true).toBe(false);
  });

  it("rating csd", function() {
    expect(one()).toBe('Awesome');
  });

});

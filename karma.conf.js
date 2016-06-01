module.exports = function(config) {
  config.set({
    frameworks: ['jasmine'],
    reporters: [
      // 'junit',
      // 'coverage',
      'progress'
    ],
    files: [
      'src/**/*.js',
      'tst/**/*.js'
    ],
    browsers: [
      //'Chrome',
      'PhantomJS'
    ],
    autoWatch: true,
    singleRun: true
  });
};

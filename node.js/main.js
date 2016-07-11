const save = require('./saveHomeToFile.js');
const colour = require('colour');

save.saveHomeToFile('report4.txt', (err) => {
	console.log('Done'.green);
});
const fs = require('fs');

// Not good to block the thread
const contents = fs.readdirSync('C:\\Users\\Tibor_Kovacs1').join('\n');
fs.writeFileSync('w:/report.txt', contents)
console.log('Done');

// Better way:
fs.readdir('C:\\Users\\Tibor_Kovacs1', (err, data) => {
	fs.writeFile('w:/report2.txt', data.join('\n'), (err) => {
		console.log('Done');
	});
});

//
const fileName = process.argv[2];
const os = require('os');

fs.readdir(os.homedir(), (err, data) => {
	fs.writeFile(fileName, data.join('\n'), (err) => {
		console.log('Done');
	});
});

const save = require('./saveHomeToFile.js');

save.saveHomeToFile(fileName, (err) => {
	console.log('Done');
});

const colour = require('colour');

save.saveHomeToFile(fileName, (err) => {
	console.log('Done'.green);
});


const fs = require('fs');

/*=======================
Write out what you type there
=======================*/
/*
process.stdin.on('data', (chunk) => {
	process.stdout.write('Your input is: ' + chunk);
});
*/

const inp = fs.createReadStream(process.argv[2])
inp.setEncoding('utf-8');//by default it is a binary, but we change it.

/*=======================
Write out the file by line
=======================*/
/*
inp.on('data', (chunk) => {
	process.stdout.write(chunk);
});
*/

/*=======================
Write the count of spaces
=======================*/
let count = 0;

/*
inp.on('data', (chunk) => {
	chunk.split('').forEach((c) => {
		if (c === ' ') {
			count++;
		}
	});
});

inp.on('end', () => {
	console.log(`Total ${count} spaces`);
});
*/

/*=======================
Write the count of spaces
=======================*/
inp.on('readable', () => {
	const chunk = inp.read();//controll how many byte would like to read

	if (chunk === null) {
		console.log(`Total ${count} spaces`);

		return;
	}

	chunk.split('').forEach((c) => {
		if (c === ' ') {
			count++;
		}
	});
});

/*=======================
Create a zipped file with the argv[2] file.
=======================*/
const zlib = require('zlib');

const zipper = zlib.createGzip();
const out = fs.createWriteStream(process.argv[2] + '.zip');

inp.pipe(zipper).pipe(out);

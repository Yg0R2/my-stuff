const http = require('http');

http.createServer((req, res) = > {
	res.writeHead(200, {
		'Content-Type': 'text/plain'
	});

	const inp = fs.createReadStream('index.html');

	inp.out
	//res.end('Hi there');
}).listen(7171);
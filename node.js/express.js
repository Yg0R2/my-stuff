const http = require('http');
const express = require('express');

const app = express();

app.use((req, res, next) => {
	if (Math.random() > .5) {
		//res.send('Booo, not authorized');
		foo.bar = 5; //<-to create an error!!
	}
	else {
		next();
	}
});

app.use((req, res, next) => {
	res.send('Hi there');
});

app.use((err, req, res, next) => {
	res.send('Ooooops, we got an error');
});

const server = http.createServer(app);

server.listen(8080, () => {
	console.log('Listening on 8080');
});
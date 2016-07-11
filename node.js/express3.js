const http = require('http');
const express = require('express');
const bodyParser = require('body-parser');
const api = require('./express-api.js');

const app = express();

app.use('/api/books', api.router);
app.use(express.static(`${__dirname}/public`));

const server = http.createServer(app);
server.listen(8080, () => {
	console.log('Listening on 8080');
});

const http = require('http');
const express = require('express');
const bodyParser = require('body-parser');

const app = express();

let maxId = 2;
const store = [{
	id: 1,
	title: 'The Time Machine'
}, {
	id: 2,
	title: 'Hobbit'
}];

app.use(bodyParser.json());

// api/books
app.get('/api/books', (req, res) => {
	res.json(store);
});

app.post('/api/books', (req, res) => {
	const item = req.body;
	item.id = ++maxId;
	store.push(item);
	res.json(item);
});

app.get('/api/books/:id', (req, res) => {
	const id = +req.params.id; // <- convert a string to number

	const idx = store.findIndex((item) => {
		return item.id === id;
	});
	console.log(req.query.foo);

	res.json(store[idx]);
});

app.use(express.static(`${__dirname}/public`));

const server = http.createServer(app);
server.listen(8080, () => {
	console.log('Listening on 8080');
});

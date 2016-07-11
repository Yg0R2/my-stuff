const express = require('express');

let maxId = 2;
const store = [{
	id: 1,
	title: 'The Time Machine'
}, {
	id: 2,
	title: 'Hobbit'
}];

const router = express.Router();

router.route('/api/books')
	.get((req, res) => {
		res.json(store);
	})
	.post((req, res) => {
		const item = req.body;
		item.id = ++maxId;
		store.push(item);
		res.json(item);
	});

router.route('/api/books/:id')
	.get((req, res) => {
		const id = +req.params.id; // <- convert a string to number

		const idx = store.findIndex((item) => {
			return item.id === id;
		});
		console.log(req.query.foo);

		res.json(store[idx]);
	});

module.exports = router;
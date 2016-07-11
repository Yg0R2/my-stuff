const http = require('http');
const express = require('express');
const socketio = require('socket.io');

const app = express();
const server = http.createServer(app);
const io = socketio(server);

const nconf = require('nconf');

nconf.argv().env().file(`${__dirname}/chat.json`);

app.use(express.static(`${__dirname}/public`));

const port = nconf.get('api:port');
console.log('Using port', port);

const winston = require('winston');
const debug = require('debug')('app');

debug('About to configure logging');
winston.add(winston.transports.File, {
	filename: 'app.log'
});

debug('Registering listeners');
io.on('connection', (sock) => {
	//console.log('Somebody connected');
	winston.info('Somebody connected');
	sock.emit('msg', 'Hi there.');

	sock.on('msg', (text) => {
		io.emit('msg', text);
	});
});

server.listen(port, () => {
	//console.log('Listening on 8080');
	winston.info('App has started');
});

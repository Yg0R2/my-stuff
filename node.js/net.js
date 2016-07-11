const net = require('net');

const clients = [];

net.createServer((sock) => {
	sock.setEncoding('utf-8');
	console.log('I got a new client: ' + sock);

	clients.push(sock);

	sock.on('readable', () => {
		const chunk = sock.read();

		if (chunk === null) {
			return;
		}

		clients.forEach((s) => {
			s.write(chunk);
		});

		sock.write(chunk);
	});

	sock.on('end', () => {
		console.log('Disconnected');
		const index = clients.indexOf(sock);
		clients.splice(index);
	});

}).listen(7171);
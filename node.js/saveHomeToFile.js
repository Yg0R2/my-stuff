const fs = require('fs');
const os = require('os');

module.exports = {
	saveHomeToFile : function(fileName, callback) {
		fs.readdir(os.homedir(), (err, data) => {
			if (err) {
				return callback(err);
			}
	
			fs.writeFile(fileName, data.join('\n'), (err) => {
				if (err) {
					return callback(err);
				}
	
				callback(null);
			});
		});
	}
}
var tcpProxy = require('tcp-proxy');
 
var server = tcpProxy.createServer({
  target: {
    host: '192.168.0.40',
    port: 80
  }
});

var handleData=function()
{
	console.log("recv");
}

server.on('data',handleData);


server.listen(80);
const http = require('http');

const hostname = '127.0.0.1';
const port = 3030;

const server = http.createServer((req, res)=>{
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain; charset=UTF-8');
  res.end('¡hola mundo!');
}
);

server.listen(port, hostname, ()=>{
  console.log(`Servidor corriendo! en http://${hostname}:${port}`);
});

var express = require('express');
var superagent = require('superagent');
var consolidate = require('consolidate');

var app = express();

app.engine('html', consolidate.handlebars);
app.set('view engine', 'html');
app.set('views', __dirname + '/views');

app.use(express.static(__dirname + '/public'));

app.get('/',function(req, res){
  superagent.get("http://www.mocky.io/v2/5be459182f00006700d9f4a2")
  .end(function(e, response){
    if (e) next(e);

    //console.log(response);
    
    return res.render('index', response.body);
  })
});
app.listen(3001);

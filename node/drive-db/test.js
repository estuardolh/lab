const drive = require('drive-db')({sheet: "1m5wWunmjcteujNeWaaEC7aiyc3KX7zQWqA1kD_XhFZI", tab: '2'});
drive.load().then(db => {
  const people = drive.find().order('id', 'desc');
  people.forEach(function(item){ console.log(item) });

  console.log('Database loaded correctly');
}).catch(err => console.log);
console.log("okay");

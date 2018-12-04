var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "wooyeon",
  password: "kkcc1313"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});
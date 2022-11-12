const mysql = require("mysql2/promise");
const { logger } = require("./winston");

// TODO: 본인의 DB 계정 입력
const pool = mysql.createPool({
  host: "umcserver.cnlc9k9pbypa.ap-northeast-2.rds.amazonaws.com",
  user: "dongho18",
  port: "3306",
  password: "?ja12184660",
  database: "UMC_hackathon-Team8",
});

module.exports = {
  pool: pool,
};

const { pool } = require("../../../config/database");
const { logger } = require("../../../config/winston");

const roomDao = require("./roomDao");

// Provider: Read 비즈니스 로직 처리

exports.retrieveRoomList = async function (email) {
  const connection = await pool.getConnection(async (conn) => conn);
  const roomListResult = await roomDao.selectRoom(connection);
  connection.release();

  return roomListResult;
};

exports.retrieveRoom = async function (roomIdx) {
  const connection = await pool.getConnection(async (conn) => conn);
  const roomResult = await roomDao.selectRoomIdx(connection, roomIdx);
  connection.release();
  return roomResult[0];
};

exports.retrieveRoom = async function (km) {
  const connection = await pool.getConnection(async (conn) => conn);
  const roomResult = await roomDao.selectRoomKm(connection, km);
  connection.release();
  return roomResult[0];
};

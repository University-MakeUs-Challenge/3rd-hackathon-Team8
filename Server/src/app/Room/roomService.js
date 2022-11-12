const { logger } = require("../../../config/winston");
const { pool } = require("../../../config/database");
const secret_config = require("../../../config/secret");
const roomProvider = require("./roomProvider");
const roomDao = require("./roomDao");
const baseResponse = require("../../../config/baseResponseStatus");
const { response } = require("../../../config/response");
const { errResponse } = require("../../../config/response");

exports.deleteRoom = async function (roomIdx) {
  try {
    const connection = await pool.getConnection(async (conn) => conn);
    const deleteRoomResult = await roomDao.deleteRoom(connection, roomIdx);
    connection.release();

    return response(baseResponse.SUCCESS);
  } catch (err) {
    logger.error(`App - editUser Service error\n: ${err.message}`);
    return errResponse(baseResponse.DB_ERROR);
  }
};

exports.editRoom = async function (roomidx, roomtitle) {
  try {
    console.log(roomidx);
    const connection = await pool.getConnection(async (conn) => conn);
    const editRoomResult = await roomDao.updateRoomInfo(
      connection,
      roomidx,
      roomtitle
    );
    connection.release();
    return response(baseResponse.SUCCESS);
  } catch (err) {
    logger.error(`App - editUser Service error\n: ${err.message}`);
    return errResponse(baseResponse.DB_ERROR);
  }
};

exports.createRoom = async function (time_limit, roomTitle, totalMembers) {
  const insertRoomInfoParams = [time_limit, roomTitle, totalMembers];

  const connection = await pool.getConnection(async (conn) => conn);

  const roominsertResult = await roomDao.insertRoomInfo(
    connection,
    insertRoomInfoParams
  );
  connection.release();
  return response(baseResponse.SUCCESS);
};

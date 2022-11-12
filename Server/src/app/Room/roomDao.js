// 매칭 대기 중인 방의 목록 조회
async function selectRoom(connection) {
  const selectRoomListQuery = `
    select Room.roomTitle, Room.totalMember, College.collegeName from Room
    join User on Room.userIdx = User.collegeIdx
    join College on User.collegeIdx = College.Idx;
                `;
  const [roomRows] = await connection.query(selectRoomListQuery);
  return roomRows;
}

async function deleteRoom(connection, roomIdx) {
  const selectRoomQuery = `
    UPDATE Challenger 
    SET status = "closed"
    WHERE roomIdx = ?;
                `;
  const updateRoomStateRow = await connection.query(selectRoomQuery, roomIdx);
  return updateRoomStateRow[0];
}

async function selectRoomIdx(connection, idx) {
  const selectRoomIdQuery = `
                 SELECT roomTitle, totalMember, status
                 FROM Room
                 WHERE idx = ?;
                 `;
  const [roomRow] = await connection.query(selectRoomIdQuery, idx);
  return roomRow;
}
async function updateRoomInfo(connection, roomidx, roomtitle) {
  const updateRoomQuery = `
  UPDATE Room
  SET status = '불가능'
  WHERE idx = ?;`;
  const updateRoomRow = await connection.query(updateRoomQuery, [
    roomidx,
    roomtitle,
  ]);
  return updateRoomRow[0];
}
async function selectRoomKm(connection, km) {
  const myLat = 37.55234567;
  const myLong = 127.8963334;
  const selectRoomkmQuery = `
  select * from User
  where abs(round((6371 * acos(cos(radians(${myLat}))*cos(radians(latitude))
  *cos(radians(${myLong}) - radians(longitude))
  + sin(radians(${myLat}))*sin(radians(latitude)))), 2)) < 10000;
  `;
  const roomRow = await connection.query(selectRoomkmQuery, km);
  return roomRow;
}
async function insertRoomInfo(connection, insertRoomInfoParams) {
  const insertRoomQuery = `
      INSERT INTO Room(timeLimit,roomTitle, totalMember) 
      Values (?,?,?);
  `;
  const insertRoomInfoRow = await connection.query(
    insertRoomQuery,
    insertRoomInfoParams
  );

  return insertRoomInfoRow;
}
module.exports = {
  selectRoom,
  deleteRoom,
  selectRoomIdx,
  updateRoomInfo,
  selectRoomKm,
  insertRoomInfo,
};

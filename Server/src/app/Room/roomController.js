const jwtMiddleware = require("../../../config/jwtMiddleware");
const roomProvider = require("../../app/Room/roomProvider");
const { pool } = require("../../../config/database");
const roomService = require("../../app/Room/roomService");
const baseResponse = require("../../../config/baseResponseStatus");
const roomDao = require("./roomDao");
const { response, errResponse } = require("../../../config/response");

/**
 * API No. 1
 * API Name : 매칭 대기 중인 방의 목록 조회
 * [GET] /rooms
 * 작성자 : 러코, 조이
 */
exports.getRoom = async function (req, res) {
  const getRoomResult = await roomProvider.retrieveRoomList();
  return res.send(response(baseResponse.SUCCESS, getRoomResult));
};

/**
 * API No. 2
 * API Name : 방 생성 Post
 * [POST] /rooms
 * 작성자 : 폴
 */
exports.postRoom = async function (req, res) {
  const { roomTitle, time_limit, totalMembers } = req.body;

  // 빈 값 체크
  if (!roomTitle) return res.send(response(baseResponse.ROOM_TITLE_EMPTY));

  // 길이 체크
  if (roomTitle.length > 30)
    return res.send(response(baseResponse.ROOM_TITLE_LENGTH));

  const roomCreateResponce = await roomService.createRoom(
    time_limit,
    roomTitle,
    totalMembers
  );

  return res.send(roomCreateResponce);
};

/**
 * API No. 4
 * API Name : 대기 중인 방 상세정보
 * [GET] /rooms/:roomIdx
 * 작성자 : 제이씨
 */
exports.getRoomInfo = async function (req, res) {
  const roomIdx = req.params.roomIdx;
  if (!roomIdx) return res.send(errResponse(baseResponse.USER_USERID_EMPTY));
  const roomByRoomIdx = await roomProvider.retrieveRoom(roomIdx);
  return res.send(response(baseResponse.SUCCESS, roomByRoomIdx));
};

/**
 * API No. 5
 * API Name : 특정 반경 이내 생성된 방 조회
 * [GET] /rooms/getKm/:km
 * 작성자 : 제이씨, 조이
 */
exports.getKm = async function (req, res) {
  const km = req.params.km;
  const roomBykm = await roomProvider.retrieveRoom(km);
  return res.send(response(baseResponse.SUCCESS, roomBykm));
};

/**
 * API No. 7
 * API Name : 생성된 방 상세정보 수정
 * [PATCH] /rooms/edit/:roomIdx
 * 작성자 : 폴
 */

/**
 * API No. 8
 * API Name : 대결 신청 보내기
 * [POST] /rooms/sendChallenge/:roomidx
 * 작성자 : 폴
 */

/**
 * API No. 9
 * API Name : 방 삭제
 * [PATCH] /rooms/delete/:roomIdx
 * 작성자 : 러코
 */
exports.deleteRoom = async function (req, res) {
  const roomIdx = req.params.roomIdx;
  const deleteRoomResult = await roomService.deleteRoom(roomIdx);
  return res.send(deleteRoomResult);
};

/**
 * API No. 10
 * API Name : 대결 끝난 방
 * [PATCH] /rooms/:roomIdx
 * 작성자 : 제이씨
 */
exports.endRoom = async function (req, res) {
  const roomIdx = req.params.roomIdx;
  const roomtitle = req.body.roomtitle;
  const endRoomInfo = await roomService.editRoom(roomIdx, roomtitle);
  return res.send(endRoomInfo);
};

module.exports = function (app) {
  const room = require("./roomController");
  const jwtMiddleware = require("../../../config/jwtMiddleware");

  // 1. 매칭 대기 중인 방의 목록 조회
  app.get("/rooms", room.getRoom);

  // 2. 방 생성 Post
  app.post("/rooms", room.postRoom);

  // 3. 새로운 방 생성 페이지
  //app.get("/rooms/create", room.createRoom);

  // 4. 대기 중인 방 상세정보
  app.get("/rooms/:roomIdx", room.getRoomInfo);

  // 5. 특정 반경 이내 생성된 방 조회
  app.get("/rooms/getKm/:km", room.getKm);

  // 6. 방 상세정보 수정 페이지
  //app.get("/rooms/edit/:roomIdx", room.getEditRoom);

  // 7. 생성된 방 상세정보 수정
  //app.patch("/rooms/edit/:roomIdx", room.patchEditRoom);

  // 8. 대결 신청 보내기
  //app.post("/rooms/sendChallenge/:roomidx", room.sendChallenge);

  // 9. 방 삭제
  app.patch("/rooms/delete/:roomIdx", room.deleteRoom);

  // 10. 대결 끝난 방
  app.patch("/rooms/:roomIdx", room.endRoom);
};

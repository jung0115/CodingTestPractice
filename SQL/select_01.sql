-- SELCT: 조건에 부합하는 중고거래 댓글 조회하기(Lv.1)
SELECT TITLE, REPLY.BOARD_ID as BOARD_ID, REPLY_ID,
    REPLY.WRITER_ID as WRITER_ID, REPLY.CONTENTS as CONTENTS,
    DATE_FORMAT(REPLY.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_REPLY as REPLY, USED_GOODS_BOARD as BOARD
WHERE REPLY.BOARD_ID = BOARD.BOARD_ID
    AND BOARD.CREATED_DATE >= '2022-10-01'
    AND BOARD.CREATED_DATE <= '2022-10-31'
ORDER BY REPLY.CREATED_DATE, TITLE;
-- 프로그래머스 - 언어별 개발자 분류하기(Lv.4)
WITH FRONT_END
  AS (SELECT SUM(CODE) as SKILL_CODE
      FROM SKILLCODES 
      WHERE CATEGORY LIKE 'Front End')
          
SELECT 
  (CASE
    WHEN DEVELOPERS.SKILL_CODE & FRONT_END.SKILL_CODE
      AND DEVELOPERS.SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME LIKE 'Python')
      THEN 'A'
    WHEN DEVELOPERS.SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME LIKE 'C#')
      THEN 'B'
    WHEN DEVELOPERS.SKILL_CODE & FRONT_END.SKILL_CODE THEN 'C'
    ELSE NULL
  END) as GRADE,
  ID,
  EMAIL
FROM DEVELOPERS, FRONT_END
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID;
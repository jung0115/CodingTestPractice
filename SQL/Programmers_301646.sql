-- 프로그래머스 - 특정 형질을 가지는 대장균 찾기(Lv.1)
SELECT COUNT(*) as COUNT
FROM ECOLI_DATA
WHERE GENOTYPE & 7 IN (1, 4, 5);
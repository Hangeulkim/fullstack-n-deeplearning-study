SELECT distinct CITY
FROM STATION
WHERE CITY REGEXP ('^A|^E|^I|^O|^U');
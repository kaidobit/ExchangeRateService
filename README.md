# ExchangeRateService
This project is a portfolio project.

The ExchangeRateService requests the third party API exchangeratesapi.com
for currently requested currency-rates.
It also maintains a database-history, which is used to calculate the average currency-rate for days between two dates.

Prerequisites:

mysql v5.7.22
port: 3306
database: exchange_rate_service
user: ExchangeRateService
password: 123qweasd

docker command for database: 
docker run --name MySQL -e MYSQL_ROOT_PASSWORD=123qweasd -e MYSQL_DATABASE=exchange_rate_service -e MYSQL_USER=ExchangeRateService -e MYSQL_PASSWORD=123qweasd -p 3306:3306 -d mysql:5.7.22

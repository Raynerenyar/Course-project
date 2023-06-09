FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

## FIRST STAGE ##
COPY src /app/src
COPY pom.xml /app

# skip test as it can't run without env var
# no need for test either
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

## SECOND STAGE ##
FROM openjdk:17-oracle

# these get env var on docker image run
ARG MYSQLUSER
ENV MYSQLUSER=$MYSQLUSER
ARG MYSQLPASSWORD
ENV MYSQLPASSWORD=$MYSQLPASSWORD
ARG MYSQLDATABASE
ENV MYSQLDATABASE=$MYSQLDATABASE
ARG MYSQLHOST
ENV MYSQLHOST=$MYSQLHOST
ARG MYSQLPORT
ENV MYSQLPORT=$MYSQLPORT
ARG MYSQL_URL
ENV MYSQL_URL=jdbc:mysql://$MYSQLHOST:$MYSQLPORT/$MYSQLDATABASE
# ENV MYSQL_URL=jdbc:mysql://${MYSQLHOST}:${MYSQLPORT}/$MYSQLDATABASE}

ARG CLIENT_URL
ENV CLIENT_URL=$CLIENT_URL

ARG ETH_WALLET_PUBLIC_ADDRESS
ENV ETH_WALLET_PUBLIC_ADDRESS=$ETH_WALLET_PUBLIC_ADDRESS
ARG ETH_WALLET_PRIVATE_KEY
ENV ETH_WALLET_PRIVATE_KEY=$ETH_WALLET_PRIVATE_KEY

ARG CROWDFUNDING_FACTORY_CONTRACT_ADDRESS
ENV CROWDFUNDING_FACTORY_CONTRACT_ADDRESS=$CROWDFUNDING_FACTORY_CONTRACT_ADDRESS
ARG FAUCET_CONTRACT_ADDRESS
ENV FAUCET_CONTRACT_ADDRESS=$FAUCET_CONTRACT_ADDRESS
ARG RPC0
ENV RPC0=$RPC0
ARG CHAIN_ID
ENV CHAIN_ID=$CHAIN_ID

ARG ETHERSCAN_API_KEY
ENV ETHERSCAN_API_KEY=$ETHERSCAN_API_KEY

ARG MONGOHOST
ENV MONGOHOST=$MONGOHOST
ARG MONGOPORT
ENV MONGOPORT=$MONGOPORT
ARG MONGOUSER
ENV MONGOUSER=$$MONGOUSER
ARG MONGOPASSWORD
ENV MONGOPASSWORD=$MONGOPASSWORD
ARG MONGODB
ENV MONGODB=$MONGODB
ARG MONGO_URL
ENV MONGO_URL=$MONGO_URL

ARG DA_APP_JWT_SECRET
ENV DA_APP_JWT_SECRET=$DA_APP_JWT_SECRET
ARG DA_APP_JWT_EXPIRATION
ENV DA_APP_JWT_EXPIRATION=$DA_APP_JWT_EXPIRATION
ARG DA_APP_JWT_COOKIENAME
ENV DA_APP_JWT_COOKIENAME=$DA_APP_JWT_COOKIENAME

COPY --from=build /app/target/assessment-0.0.1-SNAPSHOT.jar /app/target/assessment-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/target/assessment-0.0.1-SNAPSHOT.jar"]
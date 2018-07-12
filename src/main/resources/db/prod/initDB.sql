CREATE DATABASE IF NOT EXISTS twitter;

GRANT ALL PRIVILEGES ON twitter.* TO pc@localhost IDENTIFIED BY 'pc';

USE twitter;

CREATE TABLE `Users` (
	`userId` bigint NOT NULL AUTO_INCREMENT,
	`userName` varchar(20) NOT NULL UNIQUE,
	PRIMARY KEY (`userId`)
);

CREATE TABLE `Tweets` (
	`tweetId` bigint NOT NULL AUTO_INCREMENT,
	`userId` bigint NOT NULL,
	`message` varchar(140) NOT NULL,
	`created` DATETIME NOT NULL,
	PRIMARY KEY (`tweetId`)
);

CREATE TABLE `Followees` (
	`userId` bigint NOT NULL,
	`followeeId` bigint NOT NULL,
	PRIMARY KEY (`userId`,`followeeId`)
);

CREATE TABLE `Comments` (
	`commentId` bigint(140) NOT NULL AUTO_INCREMENT,
	`userId` bigint NOT NULL,
	`tweetId` bigint NOT NULL,
	`message` varchar(140) NOT NULL,
	`created` DATETIME NOT NULL,
	PRIMARY KEY (`commentId`)
);

CREATE TABLE `Retweets` (
	`reTweetId` bigint NOT NULL AUTO_INCREMENT,
	`tweetId` bigint NOT NULL,
	`userId` bigint NOT NULL,
	`message` varchar(140),
	`created` DATETIME NOT NULL,
	PRIMARY KEY (`reTweetId`)
);

ALTER TABLE `Tweets` ADD CONSTRAINT `Tweets_fk0` FOREIGN KEY (`userId`) REFERENCES `Users`(`userId`);

ALTER TABLE `Followees` ADD CONSTRAINT `Followees_fk0` FOREIGN KEY (`userId`) REFERENCES `Users`(`userId`);

ALTER TABLE `Followees` ADD CONSTRAINT `Followees_fk1` FOREIGN KEY (`followeeId`) REFERENCES `Users`(`userId`);

ALTER TABLE `Comments` ADD CONSTRAINT `Comments_fk0` FOREIGN KEY (`userId`) REFERENCES `Users`(`userId`);

ALTER TABLE `Comments` ADD CONSTRAINT `Comments_fk1` FOREIGN KEY (`tweetId`) REFERENCES `Tweets`(`tweetId`);

ALTER TABLE `Retweets` ADD CONSTRAINT `Retweets_fk0` FOREIGN KEY (`tweetId`) REFERENCES `Tweets`(`tweetId`);

ALTER TABLE `Retweets` ADD CONSTRAINT `Retweets_fk1` FOREIGN KEY (`userId`) REFERENCES `Users`(`userId`);

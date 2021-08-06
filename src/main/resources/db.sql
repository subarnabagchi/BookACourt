DROP TABLE IF EXISTS `court`;

CREATE TABLE `court`
(
    `id`               INTEGER PRIMARY KEY AUTO_INCREMENT,
    `court_name`       VARCHAR(100) not null
);

DROP TABLE IF EXISTS `player`;

CREATE TABLE `player`
(
    `id`               INTEGER PRIMARY KEY AUTO_INCREMENT,
    `first_name`       VARCHAR(100) not null,
    `last_name`        VARCHAR(100) not null,
    `email`            VARCHAR(200) not null
);

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking`
(
    `id`               INTEGER PRIMARY KEY AUTO_INCREMENT,
    `court_id`         INTEGER not null,
    `player_id`        INTEGER not null,
    `booking_date`     VARCHAR(10) not null
);

ALTER TABLE `booking` ADD CONSTRAINT FK_COURT FOREIGN KEY (court_id) REFERENCES court(id);
ALTER TABLE `booking` ADD CONSTRAINT FK_PLAYER FOREIGN KEY (player_id) REFERENCES player(id);
ALTER TABLE `booking` ADD CONSTRAINT UNIQUE_VAL UNIQUE (`player_id`, `booking_date`);
